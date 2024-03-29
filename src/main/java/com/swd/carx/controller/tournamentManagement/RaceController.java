package com.swd.carx.controller.tournamentManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.swd.carx.entity.tournamentManagement.Map;
import com.swd.carx.entity.tournamentManagement.Race;
import com.swd.carx.entity.tournamentManagement.Round;
import com.swd.carx.entity.tournamentManagement.Umpire;
import com.swd.carx.service.tournamentManagement.MapService;
import com.swd.carx.service.tournamentManagement.RaceService;
import com.swd.carx.service.tournamentManagement.RoundService;
import com.swd.carx.service.tournamentManagement.UmpireService;
import com.swd.carx.utilities.Constants;
import com.swd.carx.view.RaceDTO;

@RestController
public class RaceController {
	
	@Autowired
	private RaceService raceService;
		
	@Autowired
	private RoundService roundService;
	
	@Autowired
	private UmpireService umpireService;
	
	@Autowired
	private MapService mapService;
	
	@GetMapping("/races")
	public ResponseEntity<List<RaceDTO>> retrieveAllRaces(){
		return ResponseEntity.ok(raceService.display(raceService.findAll()));
    }
	
	@GetMapping("/race/{id}")
	public ResponseEntity<Race> retrieveRace(@PathVariable long id) {
		Race race = raceService.findById(id);
		if(race != null) {
			return ResponseEntity.status(HttpStatus.OK).body(race);
		}else {
			return ResponseEntity.notFound().build();
		}
	}

	//Combined Query
	@GetMapping("round/{roundIdStr}/umpire/{umpireIdStr}/map/{mapIdStr}/race/status/{statusStr}")
	public ResponseEntity<List<RaceDTO>> retrieveRace(@PathVariable String roundIdStr, @PathVariable String umpireIdStr, @PathVariable String mapIdStr, @PathVariable String statusStr) {
		//Validation
		Long roundId = Constants.strToLong(roundIdStr);
		Integer umpireId = Constants.strToInt(umpireIdStr);
		Integer mapId = Constants.strToInt(mapIdStr);
		Integer status =  Constants.strToInt(statusStr);
		
		List<Race> race = raceService.findByCombinedQuery(roundId, umpireId, mapId, status);
		return ResponseEntity.ok(raceService.display(race));
	}
	
	@PostMapping("round/{roundId}/umpire/{umpireId}/map/{mapId}/race")
	public ResponseEntity<Race> createRace(@PathVariable Long roundId, @PathVariable Integer umpireId, @PathVariable Integer mapId, @RequestBody Race race){
		try {
			//Check existence
			if(raceService.findById(race.getRaceId()) != null) 
				return ResponseEntity.badRequest().header("message", "Race with such ID already exists").build();
				
			Round round = roundService.findById(roundId);
			if(round == null)
				return ResponseEntity.notFound().header("message", "No Round found with such ID").build();
			
			Umpire umpire = umpireService.findById(umpireId);
			if(umpire == null)
				return ResponseEntity.notFound().header("message", "No Umpire found with such ID").build();
			
			Map map = mapService.findById(mapId);
			if(map == null)
				return ResponseEntity.notFound().header("message", "No Map found with such ID").build();
			
			//Set foreign keys
			race.setRound(round);
			race.setUmpire(umpire);
			race.setMap(map);
			
			Race savedRace = raceService.add(race);
			return ResponseEntity.status(HttpStatus.CREATED).body(savedRace);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).header("message", "Failed to add new race").build();
		}
	}
	
	@PutMapping("round/{roundId}/umpire/{umpireId}/map/{mapId}/race")
	public ResponseEntity<Race> updateRace(@PathVariable Long roundId, @PathVariable Integer umpireId, @PathVariable Integer mapId, @RequestBody Race race){
		//Check existence
		if(raceService.findById(race.getRaceId()) == null)
			return ResponseEntity.notFound().header("message", "No Race found for such ID").build();
		
		Round round = roundService.findById(roundId);
		if(round == null)
			return ResponseEntity.notFound().header("message", "No Round found with such ID").build();
		
		Umpire umpire = umpireService.findById(umpireId);
		if(umpire == null)
			return ResponseEntity.notFound().header("message", "No Umpire found with such ID").build();
		
		Map map = mapService.findById(mapId);
		if(map == null)
			return ResponseEntity.notFound().header("message", "No Map found with such ID").build();
		
		//Set foreign keys
		race.setRound(round);
		race.setUmpire(umpire);
		race.setMap(map);
		
		Race updatedRace = raceService.update(race);
		if(updatedRace != null)
			return ResponseEntity.ok(updatedRace);
		else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	@DeleteMapping("/race/{id}")
	public ResponseEntity<Void> deleteRace(@PathVariable long id){
		try{
			if(raceService.findById(id) == null) 
				return ResponseEntity.notFound().header("message", "No Race found for such ID. Deletion failed").build();
			
			raceService.delete(id);
			return ResponseEntity.noContent().header("message", "race deleted successfully").build();
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).header("message", "race deletion failed").build();
		}
	}
}

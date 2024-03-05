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

import com.swd.carx.entity.schoolManagement.Team;
import com.swd.carx.entity.tournamentManagement.CarInRace;
import com.swd.carx.entity.tournamentManagement.Race;
import com.swd.carx.service.schoolManagement.TeamService;
import com.swd.carx.service.tournamentManagement.CarInRaceService;
import com.swd.carx.service.tournamentManagement.RaceService;
import com.swd.carx.utilities.Constants;

@RestController
public class CarInRaceController {
	
	@Autowired
	private CarInRaceService carInRaceService;
		
	@Autowired
	private TeamService teamService;
	
	@Autowired
	private RaceService raceService;
	
	@GetMapping("/carInRaces")
	public ResponseEntity<List<CarInRace>> retrieveAllCarInRaces(){
		return ResponseEntity.ok(carInRaceService.findAll());
    }
	
	@GetMapping("/carInRace/{id}")
	public ResponseEntity<CarInRace> retrieveCarInRace(@PathVariable long id) {
		CarInRace carInRace = carInRaceService.findById(id);
		if(carInRace != null) {
			return ResponseEntity.status(HttpStatus.OK).body(carInRace);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//Combined Query
	@GetMapping("team/{teamId}/race/{raceId}/carInRace/score/{lower}/{upper}/status/{status}")
	public ResponseEntity<List<CarInRace>> retrieveCarInRace(@PathVariable Long teamId, @PathVariable Long raceId, @PathVariable Integer lower, @PathVariable Integer upper, @PathVariable Integer status) {
		//Validation
		if(lower == null) lower = Constants.SCORE_MIN;
		if(upper == null) upper = Constants.SCORE_MAX;
		if(status == null) status = Constants.DEFAULT_STATUS;
		
		List<CarInRace> carInRace = carInRaceService.findByCombinedQuery(teamId, raceId, lower, upper, status);
		return ResponseEntity.ok(carInRace);
	}
	
	@PostMapping("team/{teamId}/race/{raceId}/carInRace")
	public ResponseEntity<CarInRace> createCarInRace(@PathVariable Long teamId, @PathVariable Long raceId, @RequestBody CarInRace carInRace){
		try {
			//Check existence
			if(carInRaceService.findById(carInRace.getCarRaceId()) != null) 
				return ResponseEntity.badRequest().header("message", "Car In Race with such ID already exists").build();
				
			Team team = teamService.findById(teamId);
			if(team == null)
				return ResponseEntity.notFound().header("message", "No Team found with such ID").build();
			
			Race race = raceService.findById(raceId);
			if(race == null)
				return ResponseEntity.notFound().header("message", "No Race found with such ID").build();
			
			//Set foreign keys
			carInRace.setTeam(team);
			carInRace.setRace(race);
			
			CarInRace savedCarInRace = carInRaceService.add(carInRace);
			return ResponseEntity.status(HttpStatus.CREATED).body(savedCarInRace);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).header("message", "Failed to add new Car In Race").build();
		}
	}
	
	@PutMapping("team/{teamId}/race/{raceId}/carInRace")
	public ResponseEntity<CarInRace> updateCarInRace(@PathVariable Long teamId, @PathVariable Long raceId, @RequestBody CarInRace carInRace){
		//Check existence
		if(carInRaceService.findById(carInRace.getCarRaceId()) == null)
			return ResponseEntity.notFound().header("message", "No Car In Race found for such ID").build();
		
		Team team = teamService.findById(teamId);
		if(team == null)
			return ResponseEntity.notFound().header("message", "No Team found with such ID").build();
		
		Race race = raceService.findById(raceId);
		if(race == null)
			return ResponseEntity.notFound().header("message", "No Race found with such ID").build();
		
		//Set foreign keys
		carInRace.setTeam(team);
		carInRace.setRace(race);
		
		CarInRace updatedCarInRace = carInRaceService.update(carInRace);
		if(updatedCarInRace != null)
			return ResponseEntity.ok(updatedCarInRace);
		else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	@DeleteMapping("/carInRace/{id}")
	public ResponseEntity<Void> deleteCarInRace(@PathVariable long id){
		try{
			if(carInRaceService.findById(id) == null) 
				return ResponseEntity.notFound().header("message", "No Car In Race found for such ID. Deletion failed").build();
			
			carInRaceService.delete(id);
			return ResponseEntity.noContent().header("message", "Car In Race deleted successfully").build();
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).header("message", "Car In Race deletion failed").build();
		}
	}
}

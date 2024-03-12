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

import com.swd.carx.entity.tournamentManagement.MapType;
import com.swd.carx.entity.tournamentManagement.Tournament;
import com.swd.carx.service.tournamentManagement.MapTypeService;
import com.swd.carx.service.tournamentManagement.TournamentService;
import com.swd.carx.utilities.Constants;
import com.swd.carx.view.MapTypeDTO;

@RestController
public class MapTypeController {
	
	@Autowired
	private MapTypeService mapTypeService;
		
	@Autowired
	private TournamentService tournamentService;
	
	@GetMapping("/mapTypes")
	public ResponseEntity<List<MapTypeDTO>> retrieveAllMapTypes(){
		return ResponseEntity.ok(mapTypeService.display(mapTypeService.findAll()));
    }
	
	@GetMapping("/mapType/{id}")
	public ResponseEntity<MapType> retrieveMapType(@PathVariable int id) {
		MapType mapType = mapTypeService.findById(id);
		if(mapType != null) {
			return ResponseEntity.status(HttpStatus.OK).body(mapType);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//Display for Guests
	@GetMapping("tournament/{tournamentId}/mapTypes")
	public ResponseEntity<List<MapTypeDTO>> findByTournamentIdForDisplay(@PathVariable long tournamentId){
		Tournament tournament = tournamentService.findById(tournamentId);
		if(tournament != null) {
			List<MapType> ls = mapTypeService.findByTournamentIdDisplay(tournamentId);
			return ResponseEntity.ok(mapTypeService.display(ls));
		}
		else return ResponseEntity.notFound().header("message", "No Tournament found for such ID").build();
    }
	
	//Combined Query
	@GetMapping("tournament/{tournamentIdStr}/mapType/searchKey/{searchKey}/status/{statusStr}")
	public ResponseEntity<List<MapTypeDTO>> retrieveMapType(@PathVariable String tournamentIdStr, @PathVariable String searchKey, @PathVariable String statusStr) {
		//Validation
		if(searchKey == null) searchKey = "";
		else searchKey = searchKey.toLowerCase().trim();
		
		Long tournamentId = Constants.strToLong(tournamentIdStr);
		Integer status =  Constants.strToInt(statusStr);
		
		List<MapType> mapType = mapTypeService.findByCombinedQuery(tournamentId, searchKey, status);
		return ResponseEntity.ok(mapTypeService.display(mapType));
	}
	
	@PostMapping("tournament/{tournamentId}/mapType")
	public ResponseEntity<MapType> createMapType(@PathVariable Long tournamentId, @RequestBody MapType mapType){
		try {
			//Check existence
			if(mapTypeService.findById(mapType.getMapTypeId()) != null) 
				return ResponseEntity.badRequest().header("message", "Map Type with such ID already exists").build();
				
			Tournament tournament = tournamentService.findById(tournamentId);
			if(tournament == null)
				return ResponseEntity.notFound().header("message", "No Tournament found with such ID").build();
			
			//Set foreign keys
			mapType.setTournament(tournament);
			
			MapType savedMapType = mapTypeService.add(mapType);
			return ResponseEntity.status(HttpStatus.CREATED).body(savedMapType);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).header("message", "Failed to add new Map Type").build();
		}
	}
	
	@PutMapping("tournament/{tournamentId}/mapType")
	public ResponseEntity<MapType> updateMapType(@PathVariable Long tournamentId, @RequestBody MapType mapType){
		//Check existence
		if(mapTypeService.findById(mapType.getMapTypeId()) == null)
			return ResponseEntity.notFound().header("message", "No Map Type found for such ID").build();
		
		Tournament tournament = tournamentService.findById(tournamentId);
		if(tournament == null)
			return ResponseEntity.notFound().header("message", "No Tournament found with such ID").build();
		
		//Set foreign keys
		mapType.setTournament(tournament);
		
		MapType updatedMapType = mapTypeService.update(mapType);
		if(updatedMapType != null)
			return ResponseEntity.ok(updatedMapType);
		else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	@DeleteMapping("/mapType/{id}")
	public ResponseEntity<Void> deleteMapType(@PathVariable int id){
		try{
			if(mapTypeService.findById(id) == null) 
				return ResponseEntity.notFound().header("message", "No Map Type found for such ID. Deletion failed").build();
			
			mapTypeService.delete(id);
			return ResponseEntity.noContent().header("message", "Map Type deleted successfully").build();
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).header("message", "Map Type deletion failed").build();
		}
	}
}

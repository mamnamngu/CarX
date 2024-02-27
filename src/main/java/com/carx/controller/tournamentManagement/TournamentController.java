package com.carx.controller.tournamentManagement;

import java.util.Date;
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

import com.carx.entity.tournamentManagement.Tournament;
import com.carx.entity.tournamentManagement.SchoolYear;
import com.carx.entity.tournamentManagement.Location;
import com.carx.service.tournamentManagement.TournamentService;
import com.carx.service.tournamentManagement.SchoolYearService;
import com.carx.service.tournamentManagement.LocationService;
import com.carx.utilities.Constants;

@RestController
public class TournamentController {
	
	@Autowired
	private TournamentService tournamentService;
		
	@Autowired
	private SchoolYearService schoolYearService;
	
	@Autowired
	private LocationService locationService;
	
	@GetMapping("/tournaments")
	public ResponseEntity<List<Tournament>> retrieveAllTournaments(){
		return ResponseEntity.ok(tournamentService.findAll());
    }
	
	@GetMapping("/tournament/{id}")
	public ResponseEntity<Tournament> retrieveTournament(@PathVariable long id) {
		Tournament tournament = tournamentService.findById(id);
		if(tournament != null) {
			return ResponseEntity.status(HttpStatus.OK).body(tournament);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//Combined Query
	@GetMapping("schoolYear/{yearId}/location/{locationId}/tournament/tournamentName/{tournamentName}/date/{lowerStr}/{upperStr}/status/{status}")
	public ResponseEntity<List<Tournament>> retrieveTournament(@PathVariable Integer yearId, @PathVariable Integer locationId, @PathVariable String tournamentName, @PathVariable String lowerStr, @PathVariable String upperStr, @PathVariable Integer status) {
		//Validation
		if(tournamentName == null) tournamentName = "";
		else tournamentName = tournamentName.toLowerCase().trim();
		
		Date lower;
		Date upper;
		
		if(lowerStr == null) lower = Constants.START_DATE;
		else lower = Constants.strToDate(lowerStr);
		
		if(upperStr == null) upper = Constants.currentDate();
		else upper = Constants.strToDate(upperStr);
		
		if(status == null) status = Constants.DEFAULT_STATUS;
		
		List<Tournament> tournament = tournamentService.findByCombinedQuery(tournamentName, yearId, locationId, lower, upper, status);
		return ResponseEntity.ok(tournament);
	}
	
	@PostMapping("schoolYear/{yearId}/location/{locationId}/tournament")
	public ResponseEntity<Tournament> createTournament(@PathVariable Integer yearId, @PathVariable Integer locationId, @RequestBody Tournament tournament){
		try {
			//Check existence
			if(tournamentService.findById(tournament.getTournamentId()) != null) 
				return ResponseEntity.badRequest().header("message", "Tournament with such ID already exists").build();
				
			SchoolYear schoolYear = schoolYearService.findById(yearId);
			if(schoolYear == null)
				return ResponseEntity.notFound().header("message", "No School Year found with such ID").build();
			
			Location location = locationService.findById(locationId);
			if(location == null)
				return ResponseEntity.notFound().header("message", "No Location found with such ID").build();
			
			//Set foreign keys
			tournament.setSchoolYear(schoolYear);
			tournament.setLocation(location);
			
			Tournament savedTournament = tournamentService.add(tournament);
			return ResponseEntity.status(HttpStatus.CREATED).body(savedTournament);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).header("message", "Failed to add new tournament").build();
		}
	}
	
	@PutMapping("schoolYear/{yearId}/location/{locationId}/tournament")
	public ResponseEntity<Tournament> updateTournament(@PathVariable Integer yearId, @PathVariable Integer locationId, @RequestBody Tournament tournament){
		//Check existence
		if(tournamentService.findById(tournament.getTournamentId()) == null)
			return ResponseEntity.notFound().header("message", "No Tournament found for such ID").build();
		
		SchoolYear schoolYear = schoolYearService.findById(yearId);
		if(schoolYear == null)
			return ResponseEntity.notFound().header("message", "No School Year found with such ID").build();
		
		Location location = locationService.findById(locationId);
		if(location == null)
			return ResponseEntity.notFound().header("message", "No Location found with such ID").build();
		
		//Set foreign keys
		tournament.setSchoolYear(schoolYear);
		tournament.setLocation(location);
		
		Tournament updatedTournament = tournamentService.update(tournament);
		if(updatedTournament != null)
			return ResponseEntity.ok(updatedTournament);
		else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	@DeleteMapping("/tournament/{id}")
	public ResponseEntity<Void> deleteTournament(@PathVariable long id){
		try{
			if(tournamentService.findById(id) == null) 
				return ResponseEntity.notFound().header("message", "No Tournament found for such ID. Deletion failed").build();
			
			tournamentService.delete(id);
			return ResponseEntity.noContent().header("message", "tournament deleted successfully").build();
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).header("message", "tournament deletion failed").build();
		}
	}
}

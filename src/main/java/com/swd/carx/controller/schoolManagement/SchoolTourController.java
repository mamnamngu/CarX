package com.swd.carx.controller.schoolManagement;

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

import com.swd.carx.entity.schoolManagement.School;
import com.swd.carx.entity.schoolManagement.SchoolTour;
import com.swd.carx.entity.tournamentManagement.Tournament;
import com.swd.carx.service.schoolManagement.SchoolService;
import com.swd.carx.service.schoolManagement.SchoolTourService;
import com.swd.carx.service.tournamentManagement.TournamentService;
import com.swd.carx.utilities.Constants;

@RestController
public class SchoolTourController {

	@Autowired
	private SchoolTourService schoolTourService;
		
	@Autowired
	private TournamentService tournamentService;
	
	@Autowired
	private SchoolService schoolService;
	
	@GetMapping("/schoolTours")
	public ResponseEntity<List<SchoolTour>> retrieveAllSchoolTours(){
		return ResponseEntity.ok(schoolTourService.findAll());
    }
	
	@GetMapping("/schoolTour/{id}")
	public ResponseEntity<SchoolTour> retrieveSchoolTour(@PathVariable long id) {
		SchoolTour schoolTour = schoolTourService.findById(id);
		if(schoolTour != null) {
			return ResponseEntity.status(HttpStatus.OK).body(schoolTour);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//Display for Guests
	@GetMapping("tournament/{tournamentId}/schoolTours")
	public ResponseEntity<List<SchoolTour>> findByTournamentIdForDisplay(@PathVariable long tournamentId){
		Tournament tournament = tournamentService.findById(tournamentId);
		if(tournament != null) {
			List<SchoolTour> ls = schoolTourService.findByTournamentIdForDisplay(tournamentId);
			return ResponseEntity.ok(ls);
		}
		else return ResponseEntity.notFound().header("message", "No Tournament found for such ID").build();
    }
	
	//Display for Guests
	@GetMapping("school/{schoolId}/schoolTours")
	public ResponseEntity<List<SchoolTour>> findBySchoolIdForDisplay(@PathVariable int schoolId){
		School school = schoolService.findById(schoolId);
		if(school != null) {
			List<SchoolTour> ls = schoolTourService.findBySchoolIdForDisplay(schoolId);
			return ResponseEntity.ok(ls);
		}
		else return ResponseEntity.notFound().header("message", "No School found for such ID").build();
    }
	
	//Combined Query
	@GetMapping("tournament/{tournamentId}/school/{schoolId}/schoolTour/status/{status}")
	public ResponseEntity<List<SchoolTour>> retrieveSchoolTour(@PathVariable Long tournamentId, @PathVariable Integer schoolId, @PathVariable Integer status) {
		//Validation
		if(status == null) status = Constants.DEFAULT_STATUS;
		
		List<SchoolTour> schoolTour = schoolTourService.findByCombinedQuery(tournamentId, schoolId, status);
		return ResponseEntity.ok(schoolTour);
	}
	
	@PostMapping("tournament/{tournamentId}/school/{schoolId}/schoolTour")
	public ResponseEntity<SchoolTour> createSchoolTour(@PathVariable Long tournamentId, @PathVariable Integer schoolId, @RequestBody SchoolTour schoolTour){
		try {
			//Check existence
			if(schoolTourService.findById(schoolTour.getSchoolTourId()) != null) 
				return ResponseEntity.badRequest().header("message", "SchoolTour with such ID already exists").build();
				
			Tournament tournament = tournamentService.findById(tournamentId);
			if(tournament == null)
				return ResponseEntity.notFound().header("message", "No Tournament found with such ID").build();
			
			School school = schoolService.findById(schoolId);
			if(school == null)
				return ResponseEntity.notFound().header("message", "No School found with such ID").build();
			
			//Set foreign keys
			schoolTour.setTournament(tournament);
			schoolTour.setSchool(school);
			
			SchoolTour savedSchoolTour = schoolTourService.add(schoolTour);
			return ResponseEntity.status(HttpStatus.CREATED).body(savedSchoolTour);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).header("message", "Failed to add new schoolTour").build();
		}
	}
	
	@PutMapping("tournament/{tournamentId}/school/{schoolId}/schoolTour")
	public ResponseEntity<SchoolTour> updateSchoolTour(@PathVariable Long tournamentId, @PathVariable Integer schoolId, @RequestBody SchoolTour schoolTour){
		//Check existence
		if(schoolTourService.findById(schoolTour.getSchoolTourId()) == null)
			return ResponseEntity.notFound().header("message", "No SchoolTour found for such ID").build();
		
		Tournament tournament = tournamentService.findById(tournamentId);
		if(tournament == null)
			return ResponseEntity.notFound().header("message", "No Tournament found with such ID").build();
		
		School school = schoolService.findById(schoolId);
		if(school == null)
			return ResponseEntity.notFound().header("message", "No School found with such ID").build();
		
		//Set foreign keys
		schoolTour.setTournament(tournament);
		schoolTour.setSchool(school);
		
		SchoolTour updatedSchoolTour = schoolTourService.update(schoolTour);
		if(updatedSchoolTour != null)
			return ResponseEntity.ok(updatedSchoolTour);
		else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	@DeleteMapping("/schoolTour/{id}")
	public ResponseEntity<Void> deleteSchoolTour(@PathVariable long id){
		try{
			if(schoolTourService.findById(id) == null) 
				return ResponseEntity.notFound().header("message", "No SchoolTour found for such ID. Deletion failed").build();
			
			schoolTourService.delete(id);
			return ResponseEntity.noContent().header("message", "schoolTour deleted successfully").build();
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).header("message", "schoolTour deletion failed").build();
		}
	}
}

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

import com.swd.carx.entity.tournamentManagement.SchoolYear;
import com.swd.carx.service.tournamentManagement.SchoolYearService;
import com.swd.carx.utilities.Constants;

@RestController
public class SchoolYearController {
	
	@Autowired
	private SchoolYearService schoolYearService;
	
	@GetMapping("/schoolYears")
	public ResponseEntity<List<SchoolYear>> retrieveAllSchoolYears(){
		return ResponseEntity.ok(schoolYearService.findAll());
    }
	
	@GetMapping("/schoolYear/{id}")
	public ResponseEntity<SchoolYear> retrieveSchoolYear(@PathVariable int id) {
		SchoolYear schoolYear = schoolYearService.findById(id);
		if(schoolYear != null) {
			return ResponseEntity.status(HttpStatus.OK).body(schoolYear);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//Display for Guests
	@GetMapping("/schoolYear/display")
	public ResponseEntity<List<SchoolYear>> retrieveSchoolYearDisplay() {
		return ResponseEntity.status(HttpStatus.OK).body(schoolYearService.findByStatusDisplay());
	}
	
	//Combined Query
	@GetMapping("/schoolYear/searchKey/{searchKey}/status/{status}")
	public ResponseEntity<List<SchoolYear>> retrieveSchoolYear(@PathVariable String searchKey, @PathVariable Integer status) {
		//Validation
		if(searchKey == null) searchKey = "";
		else searchKey = searchKey.toLowerCase().trim();
		
		if(status == null) status = Constants.DEFAULT_STATUS;
		
		List<SchoolYear> schoolYear = schoolYearService.findByCombinedQuery(searchKey, status);
		return ResponseEntity.ok(schoolYear);
	}
	
	@PostMapping("/schoolYear")
	public ResponseEntity<SchoolYear> createSchoolYear(@RequestBody SchoolYear schoolYear){
		try {
			if(schoolYearService.findById(schoolYear.getYearId()) != null) 
				return ResponseEntity.badRequest().header("message", "School Year with such ID already exists").build();
				
			SchoolYear savedSchoolYear = schoolYearService.add(schoolYear);
			return ResponseEntity.status(HttpStatus.CREATED).body(savedSchoolYear);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).header("message", "Failed to add new schoolYear").build();
		}
	}
	
	@PutMapping("/schoolYear")
	public ResponseEntity<SchoolYear> updateSchoolYear(@RequestBody SchoolYear schoolYear){
		if(schoolYearService.findById(schoolYear.getYearId()) == null)
			return ResponseEntity.notFound().header("message", "No School Year found for such ID").build();
		
		SchoolYear updatedSchoolYear = schoolYearService.update(schoolYear);
		if(updatedSchoolYear != null)
			return ResponseEntity.ok(updatedSchoolYear);
		else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	@DeleteMapping("/schoolYear/{id}")
	public ResponseEntity<Void> deleteSchoolYear(@PathVariable int id){
		try{
			if(schoolYearService.findById(id) == null) 
				return ResponseEntity.notFound().header("message", "No School Year found for such ID. Deletion failed").build();
			
			schoolYearService.delete(id);
			return ResponseEntity.noContent().header("message", "school Year deleted successfully").build();
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).header("message", "School Year deletion failed").build();
		}
	}
}

package com.carx.controller.schoolManagement;

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

import com.carx.entity.schoolManagement.School;
import com.carx.service.schoolManagement.SchoolService;
import com.carx.utilities.Constants;

@RestController
public class SchoolController {

	@Autowired
	private SchoolService schoolService;
	
	@GetMapping("/schools")
	public ResponseEntity<List<School>> retrieveAllSchools(){
		return ResponseEntity.ok(schoolService.findAll());
    }
	
	@GetMapping("/school/{id}")
	public ResponseEntity<School> retrieveSchool(@PathVariable int id) {
		School school = schoolService.findById(id);
		if(school != null) {
			return ResponseEntity.status(HttpStatus.OK).body(school);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//Combined Query
	@GetMapping("/school/schoolName/{schoolName}/date/{startDateStr}/{endDateStr}/status/{status}")
	public ResponseEntity<List<School>> retrieveSchool(@PathVariable String schoolName, @PathVariable String startDateStr, @PathVariable String endDateStr, @PathVariable Integer status) {
		//Validation
		if(schoolName == null) schoolName = "";
		else schoolName = schoolName.toLowerCase().trim();
		
		Date startDate;
		Date endDate;
		
		if(startDateStr == null) startDate = Constants.START_DATE;
		else startDate = Constants.strToDate(startDateStr);
		
		if(endDateStr == null) endDate = Constants.currentDate();
		else endDate = Constants.strToDate(endDateStr);
		
		if(status == null) status = Constants.DEFAULT_STATUS;
		
		List<School> school = schoolService.findByCombinedQuery(schoolName, startDate, endDate, status);
		return ResponseEntity.ok(school);
	}
	
	@PostMapping("/school")
	public ResponseEntity<School> createSchool(@RequestBody School school){
		try {
			if(schoolService.findById(school.getSchoolId()) != null) 
				return ResponseEntity.badRequest().header("message", "School with such ID already exists").build();
				
			School savedSchool = schoolService.add(school);
			return ResponseEntity.status(HttpStatus.CREATED).body(savedSchool);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).header("message", "Failed to add new school").build();
		}
	}
	
	@PutMapping("/school")
	public ResponseEntity<School> updateSchool(@RequestBody School school){
		if(schoolService.findById(school.getSchoolId()) == null)
			return ResponseEntity.notFound().header("message", "No School found for such ID").build();
		
		School updatedSchool = schoolService.update(school);
		if(updatedSchool != null)
			return ResponseEntity.ok(updatedSchool);
		else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	@DeleteMapping("/school/{id}")
	public ResponseEntity<Void> deleteSchool(@PathVariable int id){
		try{
			if(schoolService.findById(id) == null) 
				return ResponseEntity.notFound().header("message", "No School found for such ID. Deletion failed").build();
			
			schoolService.delete(id);
			return ResponseEntity.noContent().header("message", "school deleted successfully").build();
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).header("message", "school deletion failed").build();
		}
	}
}

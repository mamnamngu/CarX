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

import com.swd.carx.entity.schoolManagement.Assistant;
import com.swd.carx.entity.schoolManagement.School;
import com.swd.carx.service.schoolManagement.AssistantService;
import com.swd.carx.service.schoolManagement.SchoolService;
import com.swd.carx.utilities.Constants;
import com.swd.carx.view.AssistantDTO;

public class AssistantController {

	@Autowired
	private AssistantService assistantService;
	
	@Autowired
	private SchoolService schoolService;
	
	@GetMapping("/assistants")
	public ResponseEntity<List<AssistantDTO>> retrieveAllAssistants(){
		return ResponseEntity.ok(assistantService.display(assistantService.findAll()));
    }
	
	@GetMapping("/assistant/{id}")
	public ResponseEntity<Assistant> retrieveAssistant(@PathVariable int id) {
		Assistant assistant = assistantService.findById(id);
		if(assistant != null) {
			return ResponseEntity.status(HttpStatus.OK).body(assistant);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//Combined Query
	@GetMapping("/school/{schoolIdStr}/assistant/searchKey/{searchKey}/status/{statusStr}")
	public ResponseEntity<List<AssistantDTO>> retrieveAssistant(@PathVariable String schoolIdStr, @PathVariable String searchKey, @PathVariable String statusStr) {
		//Validation
		if(searchKey == null) searchKey = "";
		else searchKey = searchKey.toLowerCase().trim();
		
		Integer schoolId =  Constants.strToInt(schoolIdStr);
		Integer status =  Constants.strToInt(statusStr);
		
		List<Assistant> assistant = assistantService.findByCombinedQuery(searchKey, schoolId, status);
		return ResponseEntity.ok(assistantService.display(assistant));
	}
	
	@PostMapping("/school/{schoolId}/assistant")
	public ResponseEntity<Assistant> createAssistant(@PathVariable Integer schoolId, @RequestBody Assistant assistant){
		try {
			if(assistantService.findById(assistant.getAssistantId()) != null) 
				return ResponseEntity.badRequest().header("message", "Assistant with such ID already exists").build();
				
			School school = schoolService.findById(schoolId);
			if(school == null)
				return ResponseEntity.notFound().header("message", "No School found with such ID").build();
			
			//Set foreign keys
			assistant.setSchool(school);
			
			Assistant savedAssistant = assistantService.add(assistant);
			return ResponseEntity.status(HttpStatus.CREATED).body(savedAssistant);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).header("message", "Failed to add new assistant").build();
		}
	}
	
	@PutMapping("/school/{schoolId}/assistant")
	public ResponseEntity<Assistant> updateAssistant(@PathVariable Integer schoolId, @RequestBody Assistant assistant){
		if(assistantService.findById(assistant.getAssistantId()) == null)
			return ResponseEntity.notFound().header("message", "No Assistant found for such ID").build();
		
		School school = schoolService.findById(schoolId);
		if(school == null)
			return ResponseEntity.notFound().header("message", "No School found with such ID").build();
		
		//Set foreign keys
		assistant.setSchool(school);
		
		Assistant updatedAssistant = assistantService.update(assistant);
		if(updatedAssistant != null)
			return ResponseEntity.ok(updatedAssistant);
		else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	@DeleteMapping("/assistant/{id}")
	public ResponseEntity<Void> deleteAssistant(@PathVariable int id){
		try{
			if(assistantService.findById(id) == null) 
				return ResponseEntity.notFound().header("message", "No Assistant found for such ID. Deletion failed").build();
			
			assistantService.delete(id);
			return ResponseEntity.noContent().header("message", "assistant deleted successfully").build();
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).header("message", "assistant deletion failed").build();
		}
	}
}

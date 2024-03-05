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

import com.swd.carx.entity.tournamentManagement.Umpire;
import com.swd.carx.service.tournamentManagement.UmpireService;
import com.swd.carx.utilities.Constants;

@RestController
public class UmpireController {
	
	@Autowired
	private UmpireService umpireService;
	
	@GetMapping("/umpires")
	public ResponseEntity<List<Umpire>> retrieveAllUmpires(){
		return ResponseEntity.ok(umpireService.findAll());
    }
	
	@GetMapping("/umpire/{id}")
	public ResponseEntity<Umpire> retrieveUmpire(@PathVariable int id) {
		Umpire umpire = umpireService.findById(id);
		if(umpire != null) {
			return ResponseEntity.status(HttpStatus.OK).body(umpire);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//Combined Query
	@GetMapping("/umpire/searchKey/{searchKey}/status/{status}")
	public ResponseEntity<List<Umpire>> retrieveUmpire(@PathVariable String searchKey, @PathVariable Integer status) {
		//Validation
		if(searchKey == null) searchKey = "";
		else searchKey = searchKey.toLowerCase().trim();
		
		if(status == null) status = Constants.DEFAULT_STATUS;
		
		List<Umpire> umpire = umpireService.findByCombinedQuery(searchKey, status);
		return ResponseEntity.ok(umpire);
	}
	
	@PostMapping("/umpire")
	public ResponseEntity<Umpire> createUmpire(@RequestBody Umpire umpire){
		try {
			if(umpireService.findById(umpire.getUmpireId()) != null) 
				return ResponseEntity.badRequest().header("message", "Umpire with such ID already exists").build();
				
			Umpire savedUmpire = umpireService.add(umpire);
			return ResponseEntity.status(HttpStatus.CREATED).body(savedUmpire);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).header("message", "Failed to add new umpire").build();
		}
	}
	
	@PutMapping("/umpire")
	public ResponseEntity<Umpire> updateUmpire(@RequestBody Umpire umpire){
		if(umpireService.findById(umpire.getUmpireId()) == null)
			return ResponseEntity.notFound().header("message", "No Umpire found for such ID").build();
		
		Umpire updatedUmpire = umpireService.update(umpire);
		if(updatedUmpire != null)
			return ResponseEntity.ok(updatedUmpire);
		else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	@DeleteMapping("/umpire/{id}")
	public ResponseEntity<Void> deleteUmpire(@PathVariable int id){
		try{
			if(umpireService.findById(id) == null) 
				return ResponseEntity.notFound().header("message", "No Umpire found for such ID. Deletion failed").build();
			
			umpireService.delete(id);
			return ResponseEntity.noContent().header("message", "umpire deleted successfully").build();
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).header("message", "umpire deletion failed").build();
		}
	}
}

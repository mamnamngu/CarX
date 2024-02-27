package com.carx.controller.tournamentManagement;

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

import com.carx.entity.tournamentManagement.Location;
import com.carx.service.tournamentManagement.LocationService;
import com.carx.utilities.Constants;

@RestController
public class LocationController {
	@Autowired
	private LocationService locationService;
	
	@GetMapping("/locations")
	public ResponseEntity<List<Location>> retrieveAllLocations(){
		return ResponseEntity.ok(locationService.findAll());
    }
	
	@GetMapping("/location/{id}")
	public ResponseEntity<Location> retrieveLocation(@PathVariable int id) {
		Location location = locationService.findById(id);
		if(location != null) {
			return ResponseEntity.status(HttpStatus.OK).body(location);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//Combined Query
	@GetMapping("/location/searchKey/{searchKey}/status/{status}")
	public ResponseEntity<List<Location>> retrieveLocation(@PathVariable String searchKey, @PathVariable Integer status) {
		//Validation
		if(searchKey == null) searchKey = "";
		else searchKey = searchKey.toLowerCase().trim();
		
		if(status == null) status = Constants.DEFAULT_STATUS;
		
		List<Location> location = locationService.findByCombinedQuery(searchKey, status);
		return ResponseEntity.ok(location);
	}
	
	@PostMapping("/location")
	public ResponseEntity<Location> createLocation(@RequestBody Location location){
		try {
			if(locationService.findById(location.getLocationId()) != null) 
				return ResponseEntity.badRequest().header("message", "Location with such ID already exists").build();
				
			Location savedLocation = locationService.add(location);
			return ResponseEntity.status(HttpStatus.CREATED).body(savedLocation);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).header("message", "Failed to add new location").build();
		}
	}
	
	@PutMapping("/location")
	public ResponseEntity<Location> updateLocation(@RequestBody Location location){
		if(locationService.findById(location.getLocationId()) == null)
			return ResponseEntity.notFound().header("message", "No Location found for such ID").build();
		
		Location updatedLocation = locationService.update(location);
		if(updatedLocation != null)
			return ResponseEntity.ok(updatedLocation);
		else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	@DeleteMapping("/location/{id}")
	public ResponseEntity<Void> deleteLocation(@PathVariable int id){
		try{
			if(locationService.findById(id) == null) 
				return ResponseEntity.notFound().header("message", "No Location found for such ID. Deletion failed").build();
			
			locationService.delete(id);
			return ResponseEntity.noContent().header("message", "location deleted successfully").build();
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).header("message", "location deletion failed").build();
		}
	}
}

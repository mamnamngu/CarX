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
import com.swd.carx.entity.tournamentManagement.MapType;
import com.swd.carx.service.tournamentManagement.MapService;
import com.swd.carx.service.tournamentManagement.MapTypeService;
import com.swd.carx.utilities.Constants;

@RestController
public class MapController {

	@Autowired
	private MapService mapService;
	
	@Autowired
	private MapTypeService mapTypeService;
	
	@GetMapping("/maps")
	public ResponseEntity<List<Map>> retrieveAllMaps(){
		return ResponseEntity.ok(mapService.findAll());
    }
	
	@GetMapping("/map/{id}")
	public ResponseEntity<Map> retrieveMap(@PathVariable int id) {
		Map map = mapService.findById(id);
		if(map != null) {
			return ResponseEntity.status(HttpStatus.OK).body(map);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//Guest Display
	@GetMapping("mapType/{mapTypeId}/map")
	public ResponseEntity<List<Map>> findByMapTypeIdForDisplay(@PathVariable int mapTypeId){
		MapType mapType = mapTypeService.findById(mapTypeId);
		if(mapType != null) {
			List<Map> ls = mapService.findByMapTypeIdDisplay(mapTypeId);
			return ResponseEntity.ok(ls);
		}
		else return ResponseEntity.notFound().header("message", "No Map Type found for such ID").build();
    }
	
	//Combined Query
	@GetMapping("mapType/{mapTypeId}/map/searchKey/{searchKey}/status/{status}")
	public ResponseEntity<List<Map>> retrieveMap(@PathVariable Integer mapTypeId, @PathVariable String searchKey, @PathVariable Integer status) {
		//Validation
		if(searchKey == null) searchKey = "";
		else searchKey = searchKey.toLowerCase().trim();
		
		if(status == null) status = Constants.DEFAULT_STATUS;
		
		List<Map> map = mapService.findByCombinedQuery(mapTypeId, searchKey, status);
		return ResponseEntity.ok(map);
	}
	
	@PostMapping("mapType/{mapTypeId}/map")
	public ResponseEntity<Map> createMap(@PathVariable Integer mapTypeId, @RequestBody Map map){
		try {
			//Check existence
			if(mapService.findById(map.getMapId()) != null) 
				return ResponseEntity.badRequest().header("message", "Map with such ID already exists").build();
			
			MapType mapType = mapTypeService.findById(mapTypeId);
			if(mapType == null)
				return ResponseEntity.notFound().header("message", "No Map Type found with such ID").build();
			
			//Set foreign keys
			map.setMapType(mapType);
			
			Map savedMap = mapService.add(map);
			return ResponseEntity.status(HttpStatus.CREATED).body(savedMap);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).header("message", "Failed to add new map").build();
		}
	}
	
	@PutMapping("mapType/{mapTypeId}/map")
	public ResponseEntity<Map> updateMap(@PathVariable Integer mapTypeId, @RequestBody Map map){
		//Check existence
		if(mapService.findById(map.getMapId()) == null)
			return ResponseEntity.notFound().header("message", "No Map found for such ID").build();
		
		MapType mapType = mapTypeService.findById(mapTypeId);
		if(mapType == null)
			return ResponseEntity.notFound().header("message", "No Map Type found with such ID").build();
		
		//Set foreign keys
		map.setMapType(mapType);
		
		Map updatedMap = mapService.update(map);
		if(updatedMap != null)
			return ResponseEntity.ok(updatedMap);
		else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	@DeleteMapping("/map/{id}")
	public ResponseEntity<Void> deleteMap(@PathVariable int id){
		try{
			if(mapService.findById(id) == null) 
				return ResponseEntity.notFound().header("message", "No Map found for such ID. Deletion failed").build();
			
			mapService.delete(id);
			return ResponseEntity.noContent().header("message", "map deleted successfully").build();
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).header("message", "map deletion failed").build();
		}
	}
}

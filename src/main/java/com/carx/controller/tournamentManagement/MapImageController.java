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

import com.carx.entity.tournamentManagement.Map;
import com.carx.entity.tournamentManagement.MapImage;
import com.carx.service.tournamentManagement.MapImageService;
import com.carx.service.tournamentManagement.MapService;

@RestController
public class MapImageController {
	
	@Autowired
	private MapImageService mapImageService;
		
	@Autowired
	private MapService mapService;
	
	@GetMapping("/mapImages")
	public ResponseEntity<List<MapImage>> retrieveAllMapImages(){
		return ResponseEntity.ok(mapImageService.findAll());
    }
	
	@GetMapping("/mapImage/{id}")
	public ResponseEntity<MapImage> retrieveMapImage(@PathVariable long id) {
		MapImage mapImage = mapImageService.findById(id);
		if(mapImage != null) {
			return ResponseEntity.status(HttpStatus.OK).body(mapImage);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//Combined Query
	@GetMapping("map/{mapId}/mapImage")
	public ResponseEntity<List<MapImage>> retrieveMapImage(@PathVariable Integer mapId) {		
		List<MapImage> mapImage = mapImageService.findByMapId(mapId);
		return ResponseEntity.ok(mapImage);
	}
	
	@PostMapping("map/{mapId}/mapImage")
	public ResponseEntity<MapImage> createMapImage(@PathVariable Integer mapId, @RequestBody MapImage mapImage){
		try {
			//Check existence
			if(mapImageService.findById(mapImage.getMapImageId()) != null) 
				return ResponseEntity.badRequest().header("message", "Map Image with such ID already exists").build();
				
			Map map = mapService.findById(mapId);
			if(map == null)
				return ResponseEntity.notFound().header("message", "No Map found with such ID").build();
			
			//Set foreign keys
			mapImage.setMap(map);
			
			MapImage savedMapImage = mapImageService.add(mapImage);
			return ResponseEntity.status(HttpStatus.CREATED).body(savedMapImage);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).header("message", "Failed to add new mapImage").build();
		}
	}
	
	@PutMapping("map/{mapId}/mapImage")
	public ResponseEntity<MapImage> updateMapImage(@PathVariable Integer mapId, @RequestBody MapImage mapImage){
		//Check existence
		if(mapImageService.findById(mapImage.getMapImageId()) == null)
			return ResponseEntity.notFound().header("message", "No Map Image found for such ID").build();
		
		Map map = mapService.findById(mapId);
		if(map == null)
			return ResponseEntity.notFound().header("message", "No Map found with such ID").build();
		
		//Set foreign keys
		mapImage.setMap(map);
		
		MapImage updatedMapImage = mapImageService.update(mapImage);
		if(updatedMapImage != null)
			return ResponseEntity.ok(updatedMapImage);
		else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	@DeleteMapping("/mapImage/{id}")
	public ResponseEntity<Void> deleteMapImage(@PathVariable long id){
		try{
			if(mapImageService.findById(id) == null) 
				return ResponseEntity.notFound().header("message", "No Map Image found for such ID. Deletion failed").build();
			
			mapImageService.delete(id);
			return ResponseEntity.noContent().header("message", "Map Image deleted successfully").build();
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).header("message", "Map Image deletion failed").build();
		}
	}
}

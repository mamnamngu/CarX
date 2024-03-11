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

import com.swd.carx.entity.tournamentManagement.CarType;
import com.swd.carx.service.tournamentManagement.CarTypeService;
import com.swd.carx.utilities.Constants;

@RestController
public class CarTypeController {
	
	@Autowired
	private CarTypeService carTypeService;
	
	@GetMapping("/carTypes")
	public ResponseEntity<List<CarType>> retrieveAllCarTypes(){
		return ResponseEntity.ok(carTypeService.findAll());
    }
	
	@GetMapping("/carType/{id}")
	public ResponseEntity<CarType> retrieveCarType(@PathVariable int id) {
		CarType carType = carTypeService.findById(id);
		if(carType != null) {
			return ResponseEntity.status(HttpStatus.OK).body(carType);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//Combined Query
	@GetMapping("/carType/searchKey/{searchKey}/status/{statusStr}")
	public ResponseEntity<List<CarType>> retrieveCarType(@PathVariable String searchKey, @PathVariable String statusStr) {
		//Validation
		if(searchKey == null) searchKey = "";
		else searchKey = searchKey.toLowerCase().trim();
		
		Integer status =  Constants.strToInt(statusStr);
		
		List<CarType> carType = carTypeService.findByCombinedQuery(searchKey, status);
		return ResponseEntity.ok(carType);
	}
	
	@PostMapping("/carType")
	public ResponseEntity<CarType> createCarType(@RequestBody CarType carType){
		try {
			if(carTypeService.findById(carType.getCarTypeId()) != null) 
				return ResponseEntity.badRequest().header("message", "Car Type with such ID already exists").build();
				
			CarType savedCarType = carTypeService.add(carType);
			return ResponseEntity.status(HttpStatus.CREATED).body(savedCarType);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).header("message", "Failed to add new Car Type").build();
		}
	}
	
	@PutMapping("/carType")
	public ResponseEntity<CarType> updateCarType(@RequestBody CarType carType){
		if(carTypeService.findById(carType.getCarTypeId()) == null)
			return ResponseEntity.notFound().header("message", "No Car Type found for such ID").build();
		
		CarType updatedCarType = carTypeService.update(carType);
		if(updatedCarType != null)
			return ResponseEntity.ok(updatedCarType);
		else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	@DeleteMapping("/carType/{id}")
	public ResponseEntity<Void> deleteCarType(@PathVariable int id){
		try{
			if(carTypeService.findById(id) == null) 
				return ResponseEntity.notFound().header("message", "No Car Type found for such ID. Deletion failed").build();
			
			carTypeService.delete(id);
			return ResponseEntity.noContent().header("message", "Car Type deleted successfully").build();
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).header("message", "Car Type deletion failed").build();
		}
	}
}

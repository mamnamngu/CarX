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

import com.swd.carx.entity.schoolManagement.Team;
import com.swd.carx.entity.tournamentManagement.Car;
import com.swd.carx.entity.tournamentManagement.CarType;
import com.swd.carx.service.schoolManagement.TeamService;
import com.swd.carx.service.tournamentManagement.CarService;
import com.swd.carx.service.tournamentManagement.CarTypeService;
import com.swd.carx.utilities.Constants;

@RestController
public class CarController {

	@Autowired
	private CarService carService;
	
	@Autowired
	private CarTypeService carTypeService;
	
	@Autowired
	private TeamService teamService;
	
	@GetMapping("/cars")
	public ResponseEntity<List<Car>> retrieveAllCars(){
		return ResponseEntity.ok(carService.findAll());
    }
	
	@GetMapping("/car/{id}")
	public ResponseEntity<Car> retrieveCar(@PathVariable long id) {
		Car car = carService.findById(id);
		if(car != null) {
			return ResponseEntity.status(HttpStatus.OK).body(car);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//Combined Query
	@GetMapping("team/{teamId}/carType/{carTypeId}/car/searchKey/{searchKey}/status/{status}")
	public ResponseEntity<List<Car>> retrieveCar(@PathVariable Long teamId, @PathVariable Integer carTypeId, @PathVariable String searchKey, @PathVariable Integer status) {
		//Validation
		if(searchKey == null) searchKey = "";
		else searchKey = searchKey.toLowerCase().trim();
		
		if(status == null) status = Constants.DEFAULT_STATUS;
		
		List<Car> car = carService.findByCombinedQuery(teamId, carTypeId, searchKey, status);
		return ResponseEntity.ok(car);
	}
	
	@PostMapping("team/{teamId}/carType/{carTypeId}/car")
	public ResponseEntity<Car> createCar(@PathVariable Long teamId, @PathVariable Integer carTypeId, @RequestBody Car car){
		try {
			//Check existence
			if(carService.findById(car.getCarId()) != null) 
				return ResponseEntity.badRequest().header("message", "Car with such ID already exists").build();
				
			Team team = teamService.findById(teamId);
			if(team == null)
				return ResponseEntity.notFound().header("message", "No Team found with such ID").build();
			
			CarType carType = carTypeService.findById(carTypeId);
			if(carType == null)
				return ResponseEntity.notFound().header("message", "No Car Type found with such ID").build();
			
			//Set foreign keys
			car.setTeam(team);
			car.setCarType(carType);
			
			Car savedCar = carService.add(car);
			return ResponseEntity.status(HttpStatus.CREATED).body(savedCar);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).header("message", "Failed to add new car").build();
		}
	}
	
	@PutMapping("team/{teamId}/carType/{carTypeId}/car")
	public ResponseEntity<Car> updateCar(@PathVariable Long teamId, @PathVariable Integer carTypeId, @RequestBody Car car){
		//Check existence
		if(carService.findById(car.getCarId()) == null)
			return ResponseEntity.notFound().header("message", "No Car found for such ID").build();
		
		Team team = teamService.findById(teamId);
		if(team == null)
			return ResponseEntity.notFound().header("message", "No Team found with such ID").build();
		
		CarType carType = carTypeService.findById(carTypeId);
		if(carType == null)
			return ResponseEntity.notFound().header("message", "No Car Type found with such ID").build();
		
		//Set foreign keys
		car.setTeam(team);
		car.setCarType(carType);
		
		Car updatedCar = carService.update(car);
		if(updatedCar != null)
			return ResponseEntity.ok(updatedCar);
		else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	@DeleteMapping("/car/{id}")
	public ResponseEntity<Void> deleteCar(@PathVariable long id){
		try{
			if(carService.findById(id) == null) 
				return ResponseEntity.notFound().header("message", "No Car found for such ID. Deletion failed").build();
			
			carService.delete(id);
			return ResponseEntity.noContent().header("message", "car deleted successfully").build();
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).header("message", "car deletion failed").build();
		}
	}
}

package com.carx.service.tournamentManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.carx.entity.tournamentManagement.Car;
import com.carx.repository.tournamentManagement.CarRepository;
import com.carx.utilities.Constants;


@Service
public class CarService {

	@Autowired
	private CarRepository carRepo;
	
	public List<Car> findAll(){
		return carRepo.findAll();
	}
	
	public Car findById(long id) {
		Car car = carRepo.findByCarId(id);
		return car;
	}
	
	//Admin filter
	public List<Car> findByCombinedQuery(Long teamId, Integer carTypeId, String searchKey, Integer status) {
		if(searchKey != null) searchKey = searchKey.toLowerCase();
		if(status == null) status = Constants.DEFAULT_STATUS;
		return carRepo.findByCombinedQuery(teamId, carTypeId, searchKey, searchKey, status);
	}
	
	//ADD
	public Car add(Car car) {
		return carRepo.save(car);
	}
	
	//DELETE - DEACTIVATE
	public boolean delete(long id) {
		Car car = findById(id);
		if(car == null) return false;
		car.setStatus(Constants.DELETED_STATUS);
		update(car);
		return car.getStatus() == Constants.DELETED_STATUS;
	}
		
	//UPDATE
	public Car update(Car newCar) {
		return add(newCar);
	}		
	
}
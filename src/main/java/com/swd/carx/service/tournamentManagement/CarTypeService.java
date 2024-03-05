package com.swd.carx.service.tournamentManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swd.carx.entity.tournamentManagement.CarType;
import com.swd.carx.repository.tournamentManagement.CarTypeRepository;
import com.swd.carx.utilities.Constants;


@Service
public class CarTypeService {

	@Autowired
	private CarTypeRepository carTypeRepo;
	
	public List<CarType> findAll(){
		return carTypeRepo.findAll();
	}
	
	public CarType findById(int id) {
		CarType carType = carTypeRepo.findByCarTypeId(id);
		return carType;
	}
	
	//Admin filter
	public List<CarType> findByCombinedQuery(String searchKey, Integer status) {
		if(searchKey == null) searchKey = "";
		else searchKey = searchKey.toLowerCase();
		if(status == null) status = Constants.DEFAULT_STATUS;
		return carTypeRepo.findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCaseAndStatus(searchKey, searchKey, status);
	}
	
	//ADD
	public CarType add(CarType carType) {
		return carTypeRepo.save(carType);
	}
	
	//DELETE - DEACTIVATE
	public boolean delete(int id) {
		CarType carType = findById(id);
		if(carType == null) return false;
		carType.setStatus(Constants.DELETED_STATUS);
		update(carType);
		return carType.getStatus() == Constants.DELETED_STATUS;
	}
		
	//UPDATE
	public CarType update(CarType newCarType) {
		return add(newCarType);
	}		
	
}
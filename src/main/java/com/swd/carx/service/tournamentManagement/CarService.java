package com.swd.carx.service.tournamentManagement;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swd.carx.entity.schoolManagement.Team;
import com.swd.carx.entity.tournamentManagement.Car;
import com.swd.carx.entity.tournamentManagement.CarType;
import com.swd.carx.repository.tournamentManagement.CarRepository;
import com.swd.carx.utilities.Constants;
import com.swd.carx.view.CarDTO;


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
//		if(status == null) status = Constants.DEFAULT_STATUS;
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
	
	//DISPLAY
	public List<CarDTO> display(List<Car> ls){
		List<CarDTO> list = new ArrayList<CarDTO>();
		
		for(Car x: ls) {
			CarDTO y = new CarDTO();
			y.setCarId(x.getCarId());
			y.setCarName(x.getCarName());
			y.setDescription(x.getDescription());
			y.setCreateDate(x.getCreateDate());
			y.setStatus(x.getStatus());
			y.setStatusTxt(Constants.STATUSES.get(x.getStatus()));
			
			//Team
			Team team = x.getTeam();
			y.setTeamId(team.getTeamId());
			y.setTeamName(team.getTeamName());
			y.setAvatar(team.getAvatar());
			
			//Car Type
			CarType carType = x.getCarType();
			y.setCarTypeId(carType.getCarTypeId());
			y.setName(carType.getName());
			
			list.add(y);
		}
		return list;
	}
	
}
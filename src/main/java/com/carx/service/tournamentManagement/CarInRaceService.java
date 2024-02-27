package com.carx.service.tournamentManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.carx.entity.tournamentManagement.CarInRace;
import com.carx.repository.tournamentManagement.CarInRaceRepository;
import com.carx.utilities.Constants;


@Service
public class CarInRaceService {

	@Autowired
	private CarInRaceRepository carInRaceRepo;
	
	public List<CarInRace> findAll(){
		return carInRaceRepo.findAll();
	}
	
	public CarInRace findById(long id) {
		CarInRace carInRace = carInRaceRepo.findByCarRaceId(id);
		return carInRace;
	}
	
	//Admin filter
	public List<CarInRace> findByCombinedQuery(Long teamId, Long raceId, Integer lower, Integer upper, Integer status) {
		if(lower == null) lower = Constants.SCORE_MIN;
		if(upper == null) upper = Constants.SCORE_MAX;
		if(status == null) status = Constants.DEFAULT_STATUS;
		return carInRaceRepo.findByTeamIdAndRaceIdAndScoreIntervalAndStatus(teamId, raceId, lower, upper, status);
	}
	
	//ADD
	public CarInRace add(CarInRace carInRace) {
		return carInRaceRepo.save(carInRace);
	}
	
	//DELETE - DEACTIVATE
	public boolean delete(long id) {
		CarInRace carInRace = findById(id);
		if(carInRace == null) return false;
		carInRace.setStatus(Constants.DELETED_STATUS);
		update(carInRace);
		return carInRace.getStatus() == Constants.DELETED_STATUS;
	}
		
	//UPDATE
	public CarInRace update(CarInRace newCarInRace) {
		return add(newCarInRace);
	}		
}
package com.swd.carx.service.tournamentManagement;

import java.util.List;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swd.carx.entity.schoolManagement.Team;
import com.swd.carx.entity.tournamentManagement.CarInRace;
import com.swd.carx.entity.tournamentManagement.Race;
import com.swd.carx.repository.tournamentManagement.CarInRaceRepository;
import com.swd.carx.utilities.Constants;
import com.swd.carx.view.CarInRaceDTO;


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
//		if(status == null) status = Constants.DEFAULT_STATUS;
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
	
	//DISPLAY
	public List<CarInRaceDTO> display(List<CarInRace> ls){
		List<CarInRaceDTO> list = new ArrayList<CarInRaceDTO>();
		for(CarInRace x: ls) {
			CarInRaceDTO y = new CarInRaceDTO();
			y.setCarRaceId(x.getCarRaceId());
			y.setStartTime(x.getStartTime());
			y.setEndTime(x.getEndTime());
			y.setBonus(x.getBonus());
			y.setPenalty(x.getPenalty());
			y.setScore(x.getScore());
			y.setRacePosition(x.getRacePosition());
			y.setStatus(x.getStatus());
			y.setStatusTxt(Constants.STATUSES.get(x.getStatus()));
			
			Team team = x.getTeam();
			y.setTeamId(team.getTeamId());
			y.setTeamName(team.getTeamName());
			y.setAvatar(team.getAvatar());
			
			Race race = x.getRace();
			y.setRaceId(race.getRaceId());
			
			list.add(y);
		}
		return list;
	}
}
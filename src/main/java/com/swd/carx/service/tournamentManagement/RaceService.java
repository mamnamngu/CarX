package com.swd.carx.service.tournamentManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swd.carx.entity.tournamentManagement.Race;
import com.swd.carx.repository.tournamentManagement.RaceRepository;
import com.swd.carx.utilities.Constants;


@Service
public class RaceService {

	@Autowired
	private RaceRepository raceRepo;
	
	public List<Race> findAll(){
		return raceRepo.findAll();
	}
	
	public Race findById(long id) {
		Race race = raceRepo.findByRaceId(id);
		return race;
	}
	
	//Admin filter
	public List<Race> findByCombinedQuery(Long roundId, Integer umpireId, Integer mapId, Integer status) {
		if(status == null) status = Constants.DEFAULT_STATUS;
		return raceRepo.findByCombinedQuery(roundId, umpireId, mapId, status);
	}
	
	//ADD
	public Race add(Race race) {
		return raceRepo.save(race);
	}
	
	//DELETE - DEACTIVATE
	public boolean delete(long id) {
		Race race = findById(id);
		if(race == null) return false;
		race.setStatus(Constants.DELETED_STATUS);
		update(race);
		return race.getStatus() == Constants.DELETED_STATUS;
	}
		
	//UPDATE
	public Race update(Race newRace) {
		return add(newRace);
	}		
	
}

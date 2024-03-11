package com.swd.carx.service.tournamentManagement;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swd.carx.entity.tournamentManagement.Map;
import com.swd.carx.entity.tournamentManagement.Race;
import com.swd.carx.entity.tournamentManagement.Round;
import com.swd.carx.entity.tournamentManagement.Umpire;
import com.swd.carx.repository.tournamentManagement.RaceRepository;
import com.swd.carx.utilities.Constants;
import com.swd.carx.view.RaceDTO;


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
//		if(status == null) status = Constants.DEFAULT_STATUS;
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
	
	//DISPLAY
	public List<RaceDTO> display(List<Race> ls){
		List<RaceDTO> list = new ArrayList<RaceDTO>();
		
		for(Race x: ls) {
			RaceDTO y = new RaceDTO();
			y.setRaceId(x.getRaceId());
			y.setStartTime(x.getStartTime());
			y.setEndTime(x.getEndTime());
			y.setNote(x.getNote());
			y.setStatus(x.getStatus());
			y.setStatusTxt(Constants.STATUSES.get(x.getStatus()));
			
			//Round
			Round round = x.getRound();
			y.setRoundId(round.getRoundId());
			y.setRoundNote(round.getNote());
			
			//Umpire
			Umpire umpire = x.getUmpire();
			y.setUmpireId(umpire.getUmpireId());
			y.setName(umpire.getName());
			
			//Map
			Map map = x.getMap();
			y.setMapId(map.getMapId());
			y.setMapName(map.getMapName());
			
			list.add(y);;
		}
		return list;
	}
}

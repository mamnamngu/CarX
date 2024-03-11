package com.swd.carx.service.tournamentManagement;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swd.carx.entity.tournamentManagement.Round;
import com.swd.carx.entity.tournamentManagement.Tournament;
import com.swd.carx.repository.tournamentManagement.RoundRepository;
import com.swd.carx.utilities.Constants;
import com.swd.carx.view.RoundDTO;


@Service
public class RoundService {

	@Autowired
	private RoundRepository roundRepo;
	
	public List<Round> findAll(){
		return roundRepo.findAll();
	}
	
	public Round findById(long id) {
		Round round = roundRepo.findByRoundId(id);
		return round;
	}
	
	//Guest Display
	public List<Round> findByTournamentIdDisplay(Long tournamentId){
		if(tournamentId == null) return null;
		return roundRepo.findByTournamentTournamentIdAndStatusNot(tournamentId, Constants.DELETED_STATUS);
	}
	
	//Admin filter
	public List<Round> findByCombinedQuery(Long tournamentId, Integer status) {
//		if(status == null) status = Constants.DEFAULT_STATUS;
		return roundRepo.findByTournamentTournamentIdAndStatus(tournamentId, status);
	}
	
	//ADD
	public Round add(Round round) {
		return roundRepo.save(round);
	}
	
	//DELETE - DEACTIVATE
	public boolean delete(long id) {
		Round round = findById(id);
		if(round == null) return false;
		round.setStatus(Constants.DELETED_STATUS);
		update(round);
		return round.getStatus() == Constants.DELETED_STATUS;
	}
		
	//UPDATE
	public Round update(Round newRound) {
		return add(newRound);
	}	
	
	//DISPLAY
	public List<RoundDTO> display(List<Round> ls){
		List<RoundDTO> list = new ArrayList<RoundDTO>();
		
		for(Round x: ls) {
			RoundDTO y = new RoundDTO();
			y.setRoundId(x.getRoundId());
			y.setStartTime(x.getStartTime());
			y.setEndTime(x.getEndTime());
			y.setNote(x.getNote());
			y.setStatus(x.getStatus());
			y.setStatusTxt(Constants.STATUSES.get(x.getStatus()));
			
			//Tournament
			Tournament tournament = x.getTournament();
			y.setTournamentId(tournament.getTournamentId());
			y.setTournamentName(tournament.getTournamentName());
			
			list.add(y);
		}
		return list;
	}
	
}

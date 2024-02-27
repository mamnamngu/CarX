package com.carx.service.tournamentManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.carx.entity.tournamentManagement.Round;
import com.carx.repository.tournamentManagement.RoundRepository;
import com.carx.utilities.Constants;


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
		if(status == null) status = Constants.DEFAULT_STATUS;
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
	
}

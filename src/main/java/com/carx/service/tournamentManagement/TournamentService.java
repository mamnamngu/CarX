package com.carx.service.tournamentManagement;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.carx.entity.tournamentManagement.Tournament;
import com.carx.repository.tournamentManagement.TournamentRepository;
import com.carx.utilities.Constants;


@Service
public class TournamentService {

	@Autowired
	private TournamentRepository tournamentRepo;
	
	public List<Tournament> findAll(){
		return tournamentRepo.findAll();
	}
	
	public Tournament findById(long id) {
		Tournament tournament = tournamentRepo.findByTournamentId(id);
		return tournament;
	}
	
	//Admin filter
	public List<Tournament> findByCombinedQuery(String tournamentName, Integer yearId, Integer locationId, Date lower, Date upper, Integer status) {
		if(tournamentName != null) tournamentName = tournamentName.toLowerCase();
		if(lower == null) lower = Constants.START_DATE;
		if(upper == null) upper = Constants.currentDate();
		if(status == null) status = Constants.DEFAULT_STATUS;
		return tournamentRepo.findTournament(tournamentName, yearId, locationId, lower, upper, status);
	}
	
	//ADD
	public Tournament add(Tournament tournament) {
		return tournamentRepo.save(tournament);
	}
	
	//DELETE - DEACTIVATE
	public boolean delete(long id) {
		Tournament tournament = findById(id);
		if(tournament == null) return false;
		tournament.setStatus(Constants.DELETED_STATUS);
		update(tournament);
		return tournament.getStatus() == Constants.DELETED_STATUS;
	}
		
	//UPDATE
	public Tournament update(Tournament newTournament) {
		return add(newTournament);
	}		
	
}
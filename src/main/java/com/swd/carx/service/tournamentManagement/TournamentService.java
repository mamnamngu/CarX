package com.swd.carx.service.tournamentManagement;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swd.carx.entity.tournamentManagement.Location;
import com.swd.carx.entity.tournamentManagement.SchoolYear;
import com.swd.carx.entity.tournamentManagement.Tournament;
import com.swd.carx.repository.tournamentManagement.TournamentRepository;
import com.swd.carx.utilities.Constants;
import com.swd.carx.view.TournamentDTO;


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
//		if(status == null) status = Constants.DEFAULT_STATUS;
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
	
	//DISPLAY
	public List<TournamentDTO> display(List<Tournament> ls){
		List<TournamentDTO> list = new ArrayList<TournamentDTO>();
		for(Tournament x: ls) {
			TournamentDTO y = new TournamentDTO();
			y.setTournamentId(x.getTournamentId());
			y.setTournamentName(x.getTournamentName());
			y.setDate(x.getDate());
			y.setStatus(x.getStatus());
			y.setStatusTxt(Constants.STATUSES.get(x.getStatus()));
			
			//School Year
			SchoolYear year = x.getSchoolYear();
			y.setYearId(year.getYearId());
			y.setYearNo(year.getYearNo());
			
			//Location
			Location location = x.getLocation();
			y.setLocationId(location.getLocationId());
			y.setLocationName(location.getLocationName());
			
			list.add(y);
		}
		return list;
	}
}
package com.swd.carx.service.schoolManagement;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swd.carx.entity.schoolManagement.School;
import com.swd.carx.entity.schoolManagement.SchoolTour;
import com.swd.carx.entity.schoolManagement.Team;
import com.swd.carx.entity.tournamentManagement.Tournament;
import com.swd.carx.repository.schoolManagement.TeamRepository;
import com.swd.carx.utilities.Constants;
import com.swd.carx.view.TeamDTO;


@Service
public class TeamService {

	@Autowired
	private TeamRepository teamRepo;
	
	public List<Team> findAll(){
		return teamRepo.findAll();
	}
	
	public Team findById(long id) {
		Team team = teamRepo.findByTeamId(id);
		return team;
	}
	
	//Display
	public List<Team> findBySchoolTourIdDisplay(Long schoolTourId){
		if(schoolTourId == null) return null;
		return teamRepo.findBySchoolTourSchoolTourIdAndStatusNot(schoolTourId, Constants.DELETED_STATUS);
	}
	
	//Combined Query
	public List<Team> findByCombinedQuery(String teamName, Long schoolTourId, Integer status) {
		if(teamName != null) teamName = teamName.toLowerCase();
//		if(status == null) status = Constants.DEFAULT_STATUS;
		return teamRepo.findByTeamNameAndSchoolTourIdAndStatus(teamName, schoolTourId, status);
	}
	
	//ADD
	public Team add(Team team) {
		return teamRepo.save(team);
	}
	
	//DELETE - DEACTIVATE
	public boolean delete(long id) {
		Team team = findById(id);
		if(team == null) return false;
		team.setStatus(Constants.DELETED_STATUS);
		update(team);
		return team.getStatus() == Constants.DELETED_STATUS;
	}
		
	//UPDATE
	public Team update(Team newTeam) {
		return add(newTeam);
	}
	
	//DISPLAY
	public List<TeamDTO> display(List<Team> ls){
		List<TeamDTO> list = new ArrayList<TeamDTO>();
		
		for(Team x: ls) {
			TeamDTO y = new TeamDTO();
			y.setTeamId(x.getTeamId());
			y.setTeamName(x.getTeamName());
			y.setAvatar(x.getAvatar());
			y.setDescription(x.getDescription());
			y.setStatus(x.getStatus());
			y.setStatusTxt(Constants.STATUSES.get(x.getStatus()));
			
			//School Tour
			SchoolTour schoolTour = x.getSchoolTour();
			y.setSchooTourId(schoolTour.getSchoolTourId());
			
			//School
			School school = schoolTour.getSchool();
			y.setSchoolId(school.getSchoolId());
			y.setSchoolName(school.getSchoolName());
			
			//Tournament
			Tournament tournament = schoolTour.getTournament();
			y.setTournamentId(tournament.getTournamentId());
			y.setTournamentName(tournament.getTournamentName());
		
			list.add(y);
		}
		return list;
	}
}
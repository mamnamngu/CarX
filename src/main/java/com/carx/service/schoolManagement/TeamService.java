package com.carx.service.schoolManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.carx.entity.schoolManagement.Team;
import com.carx.repository.schoolManagement.TeamRepository;
import com.carx.utilities.Constants;


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
		return teamRepo.findBySchoolTourSchoolTourIdAnStatusNot(schoolTourId, Constants.DELETED_STATUS);
	}
	
	//Combined Query
	public List<Team> findByCombinedQuery(String teamName, Long schoolTourId, Integer status) {
		if(teamName != null) teamName = teamName.toLowerCase();
		if(status == null) status = Constants.DEFAULT_STATUS;
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
}
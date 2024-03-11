package com.swd.carx.controller.schoolManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.swd.carx.entity.schoolManagement.SchoolTour;
import com.swd.carx.entity.schoolManagement.Team;
import com.swd.carx.service.schoolManagement.SchoolTourService;
import com.swd.carx.service.schoolManagement.TeamService;
import com.swd.carx.utilities.Constants;

@RestController
public class TeamController {

	@Autowired	
	private TeamService teamService;
	
	@Autowired
	private SchoolTourService schoolTourService;
	
	@GetMapping("/teams")
	public ResponseEntity<List<Team>> retrieveAllTeams(){
		return ResponseEntity.ok(teamService.findAll());
    }
	
	@GetMapping("/team/{id}")
	public ResponseEntity<Team> retrieveTeam(@PathVariable long id) {
		Team team = teamService.findById(id);
		if(team != null) {
			return ResponseEntity.status(HttpStatus.OK).body(team);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//Display for Guests
	@GetMapping("schoolTour/{schoolTourId}/teams")
	public ResponseEntity<List<Team>> findByTournamentIdForDisplay(@PathVariable long schoolTourId){
		SchoolTour schoolTour = schoolTourService.findById(schoolTourId);
		if(schoolTour != null) {
			List<Team> ls = teamService.findBySchoolTourIdDisplay(schoolTourId);
			return ResponseEntity.ok(ls);
		}
		else return ResponseEntity.notFound().header("message", "No School Tour found for such ID").build();
    }
	
	//Combined Query
	@GetMapping("schoolTour/{schoolTourIdStr}/team/teamName/{teamName}/status/{statusStr}")
	public ResponseEntity<List<Team>> retrieveTeam(@PathVariable String schoolTourIdStr, @PathVariable String teamName, @PathVariable String statusStr) {
		//Validation
		if(teamName == null) teamName = "";
		else teamName = teamName.toLowerCase().trim();
		
		Long schoolTourId = Constants.strToLong(schoolTourIdStr);
		Integer status =  Constants.strToInt(statusStr);
		
		List<Team> team = teamService.findByCombinedQuery(teamName, schoolTourId, status);
		return ResponseEntity.ok(team);
	}
	
	@PostMapping("schoolTour/{schoolTourId}/team")
	public ResponseEntity<Team> createTeam(@PathVariable Long schoolTourId, @RequestBody Team team){
		try {
			//Check existence
			if(teamService.findById(team.getTeamId()) != null) 
				return ResponseEntity.badRequest().header("message", "Team with such ID already exists").build();
				
			SchoolTour schoolTour = schoolTourService.findById(schoolTourId);
			if(schoolTour == null)
				return ResponseEntity.notFound().header("message", "No School Tour found with such ID").build();
			
			//Set foreign keys
			team.setSchoolTour(schoolTour);
			
			Team savedTeam = teamService.add(team);
			return ResponseEntity.status(HttpStatus.CREATED).body(savedTeam);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).header("message", "Failed to add new team").build();
		}
	}
	
	@PutMapping("schoolTour/{schoolTourId}/team")
	public ResponseEntity<Team> updateTeam(@PathVariable Long schoolTourId, @RequestBody Team team){
		//Check existence
		if(teamService.findById(team.getTeamId()) == null)
			return ResponseEntity.notFound().header("message", "No Team found for such ID").build();
		
		SchoolTour schoolTour = schoolTourService.findById(schoolTourId);
		if(schoolTour == null)
			return ResponseEntity.notFound().header("message", "No School Tour found with such ID").build();
		
		//Set foreign keys
		team.setSchoolTour(schoolTour);
		
		Team updatedTeam = teamService.update(team);
		if(updatedTeam != null)
			return ResponseEntity.ok(updatedTeam);
		else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	@DeleteMapping("/team/{id}")
	public ResponseEntity<Void> deleteTeam(@PathVariable long id){
		try{
			if(teamService.findById(id) == null) 
				return ResponseEntity.notFound().header("message", "No Team found for such ID. Deletion failed").build();
			
			teamService.delete(id);
			return ResponseEntity.noContent().header("message", "team deleted successfully").build();
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).header("message", "team deletion failed").build();
		}
	}
		
}

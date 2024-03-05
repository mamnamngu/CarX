package com.swd.carx.controller.tournamentManagement;

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

import com.swd.carx.entity.tournamentManagement.Round;
import com.swd.carx.entity.tournamentManagement.Tournament;
import com.swd.carx.service.tournamentManagement.RoundService;
import com.swd.carx.service.tournamentManagement.TournamentService;
import com.swd.carx.utilities.Constants;

@RestController
public class RoundController {
	
	@Autowired
	private RoundService roundService;
		
	@Autowired
	private TournamentService tournamentService;
	
	@GetMapping("/rounds")
	public ResponseEntity<List<Round>> retrieveAllRounds(){
		return ResponseEntity.ok(roundService.findAll());
    }
	
	@GetMapping("/round/{id}")
	public ResponseEntity<Round> retrieveRound(@PathVariable long id) {
		Round round = roundService.findById(id);
		if(round != null) {
			return ResponseEntity.status(HttpStatus.OK).body(round);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//Display for Guests
	@GetMapping("tournament/{tournamentId}/rounds")
	public ResponseEntity<List<Round>> findByTournamentIdForDisplay(@PathVariable long tournamentId){
		Tournament tournament = tournamentService.findById(tournamentId);
		if(tournament != null) {
			List<Round> ls = roundService.findByTournamentIdDisplay(tournamentId);
			return ResponseEntity.ok(ls);
		}
		else return ResponseEntity.notFound().header("message", "No Tournament found for such ID").build();
    }
	
	//Combined Query
	@GetMapping("tournament/{tournamentId}/round/status/{status}")
	public ResponseEntity<List<Round>> retrieveRound(@PathVariable Long tournamentId, @PathVariable Integer status) {
		//Validation
		if(status == null) status = Constants.DEFAULT_STATUS;
		
		List<Round> round = roundService.findByCombinedQuery(tournamentId, status);
		return ResponseEntity.ok(round);
	}
	
	@PostMapping("tournament/{tournamentId}/round")
	public ResponseEntity<Round> createRound(@PathVariable Long tournamentId, @RequestBody Round round){
		try {
			//Check existence
			if(roundService.findById(round.getRoundId()) != null) 
				return ResponseEntity.badRequest().header("message", "Round with such ID already exists").build();
				
			Tournament tournament = tournamentService.findById(tournamentId);
			if(tournament == null)
				return ResponseEntity.notFound().header("message", "No Tournament found with such ID").build();
			
			//Set foreign keys
			round.setTournament(tournament);
			
			Round savedRound = roundService.add(round);
			return ResponseEntity.status(HttpStatus.CREATED).body(savedRound);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).header("message", "Failed to add new round").build();
		}
	}
	
	@PutMapping("tournament/{tournamentId}/round")
	public ResponseEntity<Round> updateRound(@PathVariable Long tournamentId, @RequestBody Round round){
		//Check existence
		if(roundService.findById(round.getRoundId()) == null)
			return ResponseEntity.notFound().header("message", "No Round found for such ID").build();
		
		Tournament tournament = tournamentService.findById(tournamentId);
		if(tournament == null)
			return ResponseEntity.notFound().header("message", "No Tournament found with such ID").build();
		
		//Set foreign keys
		round.setTournament(tournament);
		
		Round updatedRound = roundService.update(round);
		if(updatedRound != null)
			return ResponseEntity.ok(updatedRound);
		else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	@DeleteMapping("/round/{id}")
	public ResponseEntity<Void> deleteRound(@PathVariable long id){
		try{
			if(roundService.findById(id) == null) 
				return ResponseEntity.notFound().header("message", "No Round found for such ID. Deletion failed").build();
			
			roundService.delete(id);
			return ResponseEntity.noContent().header("message", "round deleted successfully").build();
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).header("message", "round deletion failed").build();
		}
	}
}

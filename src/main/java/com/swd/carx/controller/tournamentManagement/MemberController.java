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

import com.swd.carx.entity.schoolManagement.Student;
import com.swd.carx.entity.schoolManagement.Team;
import com.swd.carx.entity.tournamentManagement.Member;
import com.swd.carx.entity.tournamentManagement.Tournament;
import com.swd.carx.service.schoolManagement.StudentService;
import com.swd.carx.service.schoolManagement.TeamService;
import com.swd.carx.service.tournamentManagement.MemberService;
import com.swd.carx.service.tournamentManagement.TournamentService;
import com.swd.carx.utilities.Constants;
import com.swd.carx.view.MemberDTO;

@RestController
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private StudentService studentService;
		
	@Autowired
	private TeamService teamService;

	@Autowired
	private TournamentService tournamentService;
	
	@GetMapping("/members")
	public ResponseEntity<List<MemberDTO>> retrieveAllMembers(){
		return ResponseEntity.ok(memberService.display(memberService.findAll()));
    }
	
	@GetMapping("/member/{id}")
	public ResponseEntity<Member> retrieveMember(@PathVariable long id) {
		Member member = memberService.findById(id);
		if(member != null) {
			return ResponseEntity.status(HttpStatus.OK).body(member);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//Combined Query
	@GetMapping("student/{studentIdStr}/team/{teamIdStr}/tournament/{tournamentIdStr}/school/{schoolIdStr}/member/status/{statusStr}")
	public ResponseEntity<List<MemberDTO>> retrieveMember(@PathVariable String studentIdStr, @PathVariable String teamIdStr, @PathVariable String tournamentIdStr, @PathVariable String schoolIdStr, @PathVariable String statusStr) {
		//Validation
		Long studentId = Constants.strToLong(studentIdStr);
		Long teamId = Constants.strToLong(teamIdStr);
		Long tournamentId = Constants.strToLong(tournamentIdStr);
		Integer schoolId = Constants.strToInt(schoolIdStr);
		Integer status =  Constants.strToInt(statusStr);
		
		List<Member> member = memberService.findByCombinedQuery(studentId, teamId, tournamentId, schoolId, status);
		return ResponseEntity.ok(memberService.display(member));
	}
	
	@PostMapping("student/{studentId}/team/{teamId}/tournament/{tournamentId}/member")
	public ResponseEntity<Member> createMember(@PathVariable Long studentId, @PathVariable Long teamId, @PathVariable Long tournamentId, @RequestBody Member member){
		try {
			//Check existence
			if(memberService.findById(member.getMemberId()) != null) 
				return ResponseEntity.badRequest().header("message", "Member with such ID already exists").build();
				
			Student student = studentService.findById(studentId);
			if(student == null) 
				return ResponseEntity.notFound().header("message", "No Student found with such ID").build();

			Team team = teamService.findById(teamId);
			if(team == null) 
				return ResponseEntity.notFound().header("message", "No Team found with such ID").build();

			Tournament tournament = tournamentService.findById(tournamentId);
			if(tournament == null)
				return ResponseEntity.notFound().header("message", "No Tournament found with such ID").build();
			
			//Set foreign keys
			member.setStudent(student);
			member.setTeam(team);
			member.setTournament(tournament);
			
			Member savedMember = memberService.add(member);
			return ResponseEntity.status(HttpStatus.CREATED).body(savedMember);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).header("message", "Failed to add new member").build();
		}
	}
	
	@PutMapping("student/{studentId}/team/{teamId}/tournament/{tournamentId}/member")
	public ResponseEntity<Member> updateMember(@PathVariable Long studentId, @PathVariable Long teamId, @PathVariable Long tournamentId, @RequestBody Member member){
		//Check existence
		if(memberService.findById(member.getMemberId()) == null)
			return ResponseEntity.notFound().header("message", "No Member found for such ID").build();
		
		Student student = studentService.findById(studentId);
		if(student == null) 
			return ResponseEntity.notFound().header("message", "No Student found with such ID").build();

		Team team = teamService.findById(teamId);
		if(team == null) 
			return ResponseEntity.notFound().header("message", "No Team found with such ID").build();

		Tournament tournament = tournamentService.findById(tournamentId);
		if(tournament == null)
			return ResponseEntity.notFound().header("message", "No Tournament found with such ID").build();
		
		//Set foreign keys
		member.setStudent(student);
		member.setTeam(team);
		member.setTournament(tournament);
		
		Member updatedMember = memberService.update(member);
		if(updatedMember != null)
			return ResponseEntity.ok(updatedMember);
		else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	@DeleteMapping("/member/{id}")
	public ResponseEntity<Void> deleteMember(@PathVariable long id){
		try{
			if(memberService.findById(id) == null) 
				return ResponseEntity.notFound().header("message", "No Member found for such ID. Deletion failed").build();
			
			memberService.delete(id);
			return ResponseEntity.noContent().header("message", "member deleted successfully").build();
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).header("message", "member deletion failed").build();
		}
	}
}

package com.swd.carx.service.tournamentManagement;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swd.carx.entity.schoolManagement.Student;
import com.swd.carx.entity.schoolManagement.Team;
import com.swd.carx.entity.tournamentManagement.Member;
import com.swd.carx.entity.tournamentManagement.Tournament;
import com.swd.carx.repository.tournamentManagement.MemberRepository;
import com.swd.carx.utilities.Constants;
import com.swd.carx.view.MemberDTO;


@Service
public class MemberService {

	@Autowired
	private MemberRepository memberRepo;
	
	public List<Member> findAll(){
		return memberRepo.findAll();
	}
	
	public Member findById(long id) {
		Member member = memberRepo.findByMemberId(id);
		return member;
	}
	
	//Admin filter
	public List<Member> findByCombinedQuery(Long studentId, Long teamId, Long tournamentId, Integer schoolId, Integer status) {
//		if(status == null) status = Constants.DEFAULT_STATUS;
		return memberRepo.findByStudentIdAndTournamentIdAndStatus(studentId, teamId, tournamentId, schoolId, status);
	}
	
	//ADD
	public Member add(Member member) {
		return memberRepo.save(member);
	}
	
	//DELETE - DEACTIVATE
	public boolean delete(long id) {
		Member member = findById(id);
		if(member == null) return false;
		member.setStatus(Constants.DELETED_STATUS);
		update(member);
		return member.getStatus() == Constants.DELETED_STATUS;
	}
		
	//UPDATE
	public Member update(Member newMember) {
		return add(newMember);
	}		
	
	//DISPLAY
	public List<MemberDTO> display(List<Member> ls){
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		
		for(Member x: ls) {
			MemberDTO y = new MemberDTO();
			y.setMemberId(x.getMemberId());
			y.setNote(x.getNote());
			y.setStatus(x.getStatus());
			y.setStatusTxt(Constants.STATUSES.get(x.getStatus()));
			
			//Student
			Student student = x.getStudent();
			y.setStudentId(student.getStudentId());
			y.setName(student.getName());
			
			//Team
			Team team = x.getTeam();
			y.setTeamId(team.getTeamId());
			y.setTeamName(team.getTeamName());
			y.setAvatar(team.getAvatar());
			
			//Tournament
			Tournament tournament = x.getTournament();
			y.setTournamentId(tournament.getTournamentId());
			y.setTournamentName(tournament.getTournamentName());
			
			list.add(y);
		}
		return list;
	}
}

package com.swd.carx.service.tournamentManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swd.carx.entity.tournamentManagement.Member;
import com.swd.carx.repository.tournamentManagement.MemberRepository;
import com.swd.carx.utilities.Constants;


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
	public List<Member> findByCombinedQuery(Long studentId, Long teamId, Long tournamentId, Integer status) {
		if(status == null) status = Constants.DEFAULT_STATUS;
		return memberRepo.findByStudentIdAndTournamentIdAndStatus(studentId, teamId, tournamentId, status);
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
	
}

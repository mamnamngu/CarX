package com.carx.service.tournamentManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carx.entity.tournamentManagement.Member;
import com.carx.repository.tournamentManagement.MemberRepository;


@Service
public class MemberService {

	@Autowired
	private MemberRepository memberRepo;
}

package com.carx.service.schoolManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carx.entity.schoolManagement.Team;
import com.carx.repository.schoolManagement.TeamRepository;


@Service
public class TeamService {

	@Autowired
	private TeamRepository teamRepo;
}
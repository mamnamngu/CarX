package com.carx.service.tournamentManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carx.entity.tournamentManagement.Race;
import com.carx.repository.tournamentManagement.RaceRepository;


@Service
public class RaceService {

	@Autowired
	private RaceRepository raceRepo;
}

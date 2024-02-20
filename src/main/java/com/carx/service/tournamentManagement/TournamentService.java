package com.carx.service.tournamentManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carx.entity.tournamentManagement.Tournament;
import com.carx.repository.tournamentManagement.TournamentRepository;


@Service
public class TournamentService {

	@Autowired
	private TournamentRepository tournamentRepo;
}
package com.carx.service.tournamentManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carx.entity.tournamentManagement.Round;
import com.carx.repository.tournamentManagement.RoundRepository;


@Service
public class RoundService {

	@Autowired
	private RoundRepository roundRepo;
}

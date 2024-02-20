package com.carx.service.tournamentManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carx.entity.tournamentManagement.CarInRace;
import com.carx.repository.tournamentManagement.CarInRaceRepository;


@Service
public class CarInRaceService {

	@Autowired
	private CarInRaceRepository carInRaceRepo;
}
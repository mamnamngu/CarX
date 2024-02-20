package com.carx.service.tournamentManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carx.entity.tournamentManagement.Location;
import com.carx.repository.tournamentManagement.LocationRepository;


@Service
public class LocationService {

	@Autowired
	private LocationRepository locationRepo;
}


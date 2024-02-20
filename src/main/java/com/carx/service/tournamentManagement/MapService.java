package com.carx.service.tournamentManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carx.entity.tournamentManagement.Map;
import com.carx.repository.tournamentManagement.MapRepository;


@Service
public class MapService {

	@Autowired
	private MapRepository mapRepo;
}

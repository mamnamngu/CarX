package com.carx.service.tournamentManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carx.entity.tournamentManagement.MapType;
import com.carx.repository.tournamentManagement.MapTypeRepository;


@Service
public class MapTypeService {

	@Autowired
	private MapTypeRepository mapTypeRepo;
}
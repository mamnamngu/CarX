package com.carx.service.tournamentManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carx.entity.tournamentManagement.CarType;
import com.carx.repository.tournamentManagement.CarTypeRepository;


@Service
public class CarTypeService {

	@Autowired
	private CarTypeRepository carTypeRepo;
}
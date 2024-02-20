package com.carx.service.tournamentManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carx.entity.tournamentManagement.SchoolYear;
import com.carx.repository.tournamentManagement.SchoolYearRepository;


@Service
public class SchoolYearService {

	@Autowired
	private SchoolYearRepository schoolYearRepo;
}

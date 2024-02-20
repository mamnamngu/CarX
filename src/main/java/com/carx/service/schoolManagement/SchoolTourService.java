package com.carx.service.schoolManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carx.entity.schoolManagement.SchoolTour;
import com.carx.repository.schoolManagement.SchoolTourRepository;


@Service
public class SchoolTourService {

	@Autowired
	private SchoolTourRepository schoolTourRepo;
}
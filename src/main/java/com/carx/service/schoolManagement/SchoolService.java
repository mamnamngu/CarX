package com.carx.service.schoolManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carx.entity.schoolManagement.School;
import com.carx.repository.schoolManagement.SchoolRepository;


@Service
public class SchoolService {

	@Autowired
	private SchoolRepository schoolRepo;
}
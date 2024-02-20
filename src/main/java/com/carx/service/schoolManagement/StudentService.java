package com.carx.service.schoolManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carx.entity.schoolManagement.Student;
import com.carx.repository.schoolManagement.StudentRepository;


@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepo;
}

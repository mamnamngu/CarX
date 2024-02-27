package com.carx.service.schoolManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.carx.entity.schoolManagement.Student;
import com.carx.repository.schoolManagement.StudentRepository;
import com.carx.utilities.Constants;


@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepo;
	
	public List<Student> findAll(){
		return studentRepo.findAll();
	}
	
	public Student findById(long id) {
		Student student = studentRepo.findByStudentId(id);
		return student;
	}
	
	//Admin + School Assistant
	public List<Student> findByCombinedQuery(String name, Integer schoolId, Integer status){
		if(name != null) name = name.toLowerCase();
		if(status == null) status = Constants.DEFAULT_STATUS;
		return studentRepo.findByNameAndSchoolIdAndStatus(name, schoolId, status);
	}
	
	//ADD
	public Student add(Student student) {
		return studentRepo.save(student);
	}
	
	//DELETE - DEACTIVATE
	public boolean delete(long id) {
		Student student = findById(id);
		if(student == null) return false;
		student.setStatus(Constants.DELETED_STATUS);
		update(student);
		return student.getStatus() == Constants.DELETED_STATUS;
	}
		
	//UPDATE
	public Student update(Student newStudent) {
		return add(newStudent);
	}		
}

package com.swd.carx.service.schoolManagement;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swd.carx.entity.schoolManagement.School;
import com.swd.carx.entity.schoolManagement.Student;
import com.swd.carx.repository.schoolManagement.StudentRepository;
import com.swd.carx.utilities.Constants;
import com.swd.carx.view.StudentDTO;


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
//		if(status == null) status = Constants.DEFAULT_STATUS;
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
	
	//DISPLAY
	public List<StudentDTO> display(List<Student> ls){
		List<StudentDTO>list = new ArrayList<StudentDTO>();
		
		for(Student x: ls) {
			StudentDTO y = new StudentDTO();
			y.setStudentId(x.getStudentId());
			y.setName(x.getName());
			y.setDOB(x.getDOB());
			y.setGender(x.isGender());
			y.setPhone(x.getPhone());
			y.setEmail(x.getEmail());
			y.setNote(x.getNote());
			y.setStatus(x.getStatus());
			y.setStatusTxt(Constants.STATUSES.get(x.getStatus()));
			
			//School
			School school = x.getSchool();
			y.setSchoolId(school.getSchoolId());
			y.setSchoolName(school.getSchoolName());
			
			list.add(y);
		}
		return list;
	}
}

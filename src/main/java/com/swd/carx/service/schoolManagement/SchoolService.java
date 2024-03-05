package com.swd.carx.service.schoolManagement;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swd.carx.entity.schoolManagement.School;
import com.swd.carx.repository.schoolManagement.SchoolRepository;
import com.swd.carx.utilities.Constants;


@Service
public class SchoolService {

	@Autowired
	private SchoolRepository schoolRepo;
	
	public List<School> findAll(){
		return schoolRepo.findAll();
	}
	
	public School findById(int id) {
		School school = schoolRepo.findBySchoolId(id);
		return school;
	}
	
	//Admin filter
	public List<School> findByCombinedQuery(String schoolName,  Date startDate, Date endDate, Integer status) {
		if(schoolName == null) schoolName = "";
		else schoolName = schoolName.toLowerCase();
		if(startDate == null) startDate = Constants.START_DATE;
		if(endDate == null) endDate = Constants.currentDate();
		if(status == null) status = Constants.DEFAULT_STATUS;
		return schoolRepo.findBySchoolNameContainingIgnoreCaseAndCreateDateBetweenAndStatus(schoolName, startDate, endDate, status);
	}
	
	//ADD
	public School add(School school) {
		return schoolRepo.save(school);
	}
	
	//DELETE - DEACTIVATE
	public boolean delete(int id) {
		School school = findById(id);
		if(school == null) return false;
		school.setStatus(Constants.DELETED_STATUS);
		update(school);
		return school.getStatus() == Constants.DELETED_STATUS;
	}
		
	//UPDATE
	public School update(School newSchool) {
		return add(newSchool);
	}		
}
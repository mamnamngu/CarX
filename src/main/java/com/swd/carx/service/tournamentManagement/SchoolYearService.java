package com.swd.carx.service.tournamentManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swd.carx.entity.tournamentManagement.SchoolYear;
import com.swd.carx.repository.tournamentManagement.SchoolYearRepository;
import com.swd.carx.utilities.Constants;


@Service
public class SchoolYearService {

	@Autowired
	private SchoolYearRepository schoolYearRepo;
	
	public List<SchoolYear> findAll(){
		return schoolYearRepo.findAll();
	}
	
	public SchoolYear findById(int id) {
		SchoolYear schoolYear = schoolYearRepo.findByYearId(id);
		return schoolYear;
	}
	
	//Guest Display
	public List<SchoolYear> findByStatusDisplay(){
		return schoolYearRepo.findByStatusNot(Constants.DELETED_STATUS);
	}
	
	//Admin filter
	public List<SchoolYear> findByCombinedQuery(String searchKey, Integer status) {
		if(searchKey == null) searchKey = "";
		else searchKey = searchKey.toLowerCase();
		if(status == null) status = Constants.DEFAULT_STATUS;
		return schoolYearRepo.findByDescriptionContainingIgnoreCaseAndStatus(searchKey, status);
	}
	
	//ADD
	public SchoolYear add(SchoolYear schoolYear) {
		return schoolYearRepo.save(schoolYear);
	}
	
	//DELETE - DEACTIVATE
	public boolean delete(int id) {
		SchoolYear schoolYear = findById(id);
		if(schoolYear == null) return false;
		schoolYear.setStatus(Constants.DELETED_STATUS);
		update(schoolYear);
		return schoolYear.getStatus() == Constants.DELETED_STATUS;
	}
		
	//UPDATE
	public SchoolYear update(SchoolYear newSchoolYear) {
		return add(newSchoolYear);
	}		
	
}

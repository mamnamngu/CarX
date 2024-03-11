package com.swd.carx.service.schoolManagement;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swd.carx.entity.schoolManagement.School;
import com.swd.carx.entity.schoolManagement.SchoolTour;
import com.swd.carx.entity.tournamentManagement.Tournament;
import com.swd.carx.repository.schoolManagement.SchoolTourRepository;
import com.swd.carx.utilities.Constants;
import com.swd.carx.view.SchoolTourDTO;


@Service
public class SchoolTourService {

	@Autowired
	private SchoolTourRepository schoolTourRepo;
	
	public List<SchoolTour> findAll(){
		return schoolTourRepo.findAll();
	}
	
	public SchoolTour findById(long id) {
		SchoolTour schoolTour = schoolTourRepo.findBySchoolTourId(id);
		return schoolTour;
	}
	
	//Display
	public List<SchoolTour> findByTournamentIdForDisplay(Long tournamentId) {
		if(tournamentId == null) return null;
		return schoolTourRepo.findByTournamentTournamentIdAndStatusNot(tournamentId, Constants.DELETED_STATUS);
	}
	
	//Display
	public List<SchoolTour> findBySchoolIdForDisplay(Integer schoolId) {
		if(schoolId == null) return null;
		return schoolTourRepo.findBySchoolSchoolIdAndStatusNot(schoolId, Constants.DELETED_STATUS);
	}
	
	//Admin filter
	public List<SchoolTour> findByCombinedQuery(Long tournamentId, Integer schoolId, Integer status) {
//		if(status == null) status = Constants.DEFAULT_STATUS;
		return schoolTourRepo.findByCombinedQuery(schoolId, tournamentId, status);
	}
	
	//ADD
	public SchoolTour add(SchoolTour schoolTour) {
		return schoolTourRepo.save(schoolTour);
	}
	
	//DELETE - DEACTIVATE
	public boolean delete(long id) {
		SchoolTour schoolTour = findById(id);
		if(schoolTour == null) return false;
		schoolTour.setStatus(Constants.DELETED_STATUS);
		update(schoolTour);
		return schoolTour.getStatus() == Constants.DELETED_STATUS;
	}
		
	//UPDATE
	public SchoolTour update(SchoolTour newSchoolTour) {
		return add(newSchoolTour);
	}	
	
	//DISPLAY
	public List<SchoolTourDTO> display(List<SchoolTour> ls){
		List<SchoolTourDTO> list = new ArrayList<SchoolTourDTO>();
		
		for(SchoolTour x: ls) {
			SchoolTourDTO y = new SchoolTourDTO();
			y.setSchoolTourId(x.getSchoolTourId());
			y.setNote(x.getNote());
			y.setStatus(x.getStatus());
			y.setStatusTxt(Constants.STATUSES.get(x.getStatus()));
			
			//Tournament
			Tournament tournament = x.getTournament();
			y.setTournamentId(tournament.getTournamentId());
			y.setTournamentName(tournament.getTournamentName());
			
			//School
			School school = x.getSchool();
			y.setSchoolId(school.getSchoolId());
			y.setSchoolName(school.getSchoolName());
			
			list.add(y);			
		}
		return list;
	}
	
}
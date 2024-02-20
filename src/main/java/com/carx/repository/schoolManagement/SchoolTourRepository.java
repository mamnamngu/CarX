package com.carx.repository.schoolManagement;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.carx.entity.schoolManagement.SchoolTour;

@Repository
public interface SchoolTourRepository extends JpaRepository<SchoolTour, Long>, JpaSpecificationExecutor<SchoolTour>{
	
	public SchoolTour findBySchoolTourId(long schoolTourId);
	
	//Status is not deleted
	public List<SchoolTour> findByTournamentTournamentIdAndStatusNot(long tournamentId, int status);
	
	public List<SchoolTour> findBySchoolSchoolIdIdAndStatusNot(long schoolId, int status);
	
	//Combined
	public List<SchoolTour> findByTournamentTournamentIdAndSchoolSchoolIdStatusNot(long tournamentId, long schoolId, int status);
}

package com.carx.repository.tournamentManagement;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.carx.entity.tournamentManagement.SchoolYear;

@Repository
public interface SchoolYearRepository extends JpaRepository<SchoolYear, Integer>, JpaSpecificationExecutor<SchoolYear>{
	
	public SchoolYear findByYearId(int yearId);
	
	//Guests
	public List<SchoolYear> findByStatusNot(int status);
	
	//Admin
	public List<SchoolYear> findByDescriptionContainingIgnoreCaseAndStatus(String description, int status);

}
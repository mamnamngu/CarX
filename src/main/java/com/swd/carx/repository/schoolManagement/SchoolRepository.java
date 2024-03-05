package com.swd.carx.repository.schoolManagement;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.swd.carx.entity.schoolManagement.School;

@Repository
public interface SchoolRepository extends JpaRepository<School, Integer>, JpaSpecificationExecutor<School>{
	
	public School findBySchoolId(int schoolId);
	
	//Combined filter
	public List<School> findBySchoolNameContainingIgnoreCaseAndCreateDateBetweenAndStatus(String schoolName, Date startDate, Date endDate, int status);

}
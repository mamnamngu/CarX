package com.swd.carx.repository.tournamentManagement;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.swd.carx.entity.tournamentManagement.SchoolYear;

@Repository
public interface SchoolYearRepository extends JpaRepository<SchoolYear, Integer>, JpaSpecificationExecutor<SchoolYear>{
	
	public SchoolYear findByYearId(int yearId);
	
	//Guests
	public List<SchoolYear> findByStatusNot(int status);
	
	//Admin
	@Query("SELECT e FROM SchoolYear e WHERE " +
	           "(:description IS NULL OR LOWER(e.description) LIKE LOWER(CONCAT('%', :description, '%'))) AND " +
	           "(:status IS NULL OR e.status = :status)")
	public List<SchoolYear> findByDescriptionContainingIgnoreCaseAndStatus(@Param("description") String description, @Param("status") Integer status);

}
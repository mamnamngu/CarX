package com.swd.carx.repository.schoolManagement;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.swd.carx.entity.schoolManagement.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long>, JpaSpecificationExecutor<Team>{
	
	public Team findByTeamId(long teamId);
	
	//Guest
	public List<Team> findBySchoolTourSchoolTourIdAndStatusNot(long schoolTourId, int status);
	
	//ADMIN + School Assistant
	//Combined query
	@Query("SELECT e FROM Team e WHERE " +
           "(:teamName IS NULL OR LOWER(e.teamName) LIKE LOWER(CONCAT('%', :teamName, '%'))) AND " +
           "(:schoolTourId IS NULL OR e.schoolTour.schoolTourId = :schoolTourId) AND " +
           "(:status IS NULL OR e.status = :status)")
	public List<Team> findByTeamNameAndSchoolTourIdAndStatus(@Param("teamName") String teamName, @Param("schoolTourId") Long schoolTourId, @Param("status") Integer status);

}
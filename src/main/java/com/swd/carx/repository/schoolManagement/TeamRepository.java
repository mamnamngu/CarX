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
           "(:teamName IS NULL OR (LOWER(e.teamName) LIKE LOWER(CONCAT('%', :teamName, '%')) OR LOWER(e.description) LIKE LOWER(CONCAT('%', :teamName, '%')))) AND " +
           "(:schoolId IS NULL OR e.schoolTour.school.schoolId = :schoolId) AND " +
           "(:tournamentId IS NULL OR e.schoolTour.tournament.tournamentId = :tournamentId) AND " +
           "(:status IS NULL OR e.status = :status)")
	public List<Team> findByTeamNameAndSchoolTourIdAndStatus(@Param("teamName") String teamName, @Param("schoolId") Integer schoolId, @Param("tournamentId") Long tournamentId, @Param("status") Integer status);

}

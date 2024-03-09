package com.swd.carx.repository.tournamentManagement;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.swd.carx.entity.tournamentManagement.Tournament;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament, Long>, JpaSpecificationExecutor<Tournament>{
	
	public Tournament findByTournamentId(long tournamentId);
	
	//Combined query
	@Query("SELECT e FROM Tournament e WHERE " +
           "(:tournamentName IS NULL OR LOWER(e.tournamentName) LIKE LOWER(CONCAT('%', :tournamentName, '%'))) AND " +     
           "(:yearId IS NULL OR e.schoolYear.yearId = :yearId) AND " +
           "(:locationId IS NULL OR e.location.locationId = :locationId) AND " +
           "(e.date BETWEEN :lower AND :upper) AND " +
           "(:status IS NULL OR e.status = :status)")
	public List<Tournament> findTournament(@Param("tournamentName") String tournamentName, @Param("yearId") Integer yearId, @Param("locationId") Integer locationId, @Param("lower") Date lower, @Param("upper") Date upper, @Param("status") Integer status);
}

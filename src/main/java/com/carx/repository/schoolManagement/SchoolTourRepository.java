package com.carx.repository.schoolManagement;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.carx.entity.schoolManagement.SchoolTour;

@Repository
public interface SchoolTourRepository extends JpaRepository<SchoolTour, Long>, JpaSpecificationExecutor<SchoolTour>{
	
	//Display transactional records without viewing the deleted items
	
	public SchoolTour findBySchoolTourId(long schoolTourId);
	
	//Status is not deleted
	public List<SchoolTour> findByTournamentTournamentIdAndStatusNot(Long tournamentId, int status);
	
	public List<SchoolTour> findBySchoolSchoolIdAndStatusNot(Integer schoolId, int status);
	
	//Combined query
	@Query("SELECT e FROM SchoolTour e WHERE " +
           "(:schoolId IS NULL OR e.schoolId :schoolId) AND " +
           "(:tournamentId IS NULL OR e.tournamentId = :tournamentId) AND " +
           "(:status IS NULL OR e.status = :status)")
	public List<SchoolTour> findBySchoolIdAndTournamentId(@Param("schoolId") Integer schoolId, @Param("tournamentId") Long tournamentId, @Param("status") Integer status);

}

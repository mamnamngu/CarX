package com.carx.repository.tournamentManagement;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.carx.entity.schoolManagement.Student;
import com.carx.entity.tournamentManagement.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long>, JpaSpecificationExecutor<Car>{
	
	public Car findByCarId(long carId);
	
	//Combined query
	@Query("SELECT e FROM CarInRace e WHERE " +
	           "(:teamId IS NULL OR e.teamId = :teamId) AND " +
	           "(:raceId IS NULL OR e.raceId = :raceId) AND " +
	           "e.score BETWEEN :lower AND :upper AND " +
	           "(:status IS NULL OR e.status = :status)")
	public List<Student> findByNameAndSchoolIdAndStatus(@Param("teamId") String teamId, @Param("lower") int lower, @Param("upper") int upper, @Param("status") int status);
}

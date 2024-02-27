package com.carx.repository.tournamentManagement;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.carx.entity.tournamentManagement.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long>, JpaSpecificationExecutor<Car>{
	
	public Car findByCarId(long carId);
	
	//Combined query
	@Query("SELECT e FROM Car e WHERE " +
           "(:teamId IS NULL OR e.teamId = :teamId) AND " +
           "(:carTypeId IS NULL OR e.carTypeId = :carTypeId) AND " +
           "((:carName IS NULL OR LOWER(e.carName) LIKE '%:carName%') OR " +
           "(:description IS NULL OR LOWER(e.description) LIKE '%:description%')) AND " +
           "(:status IS NULL OR e.status = :status)")
	public List<Car> findByCombinedQuery(@Param("teamId") Long teamId, @Param("carTypeId") Integer carTypeId, @Param("carName") String carName, @Param("description") String description, @Param("status") Integer status);

}

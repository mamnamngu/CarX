package com.swd.carx.repository.tournamentManagement;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.swd.carx.entity.tournamentManagement.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer>, JpaSpecificationExecutor<Location>{
	
	public Location findByLocationId(int locationId);
	
	//Admin
	@Query("SELECT e FROM Location e WHERE " +
	           "(:description IS NULL OR LOWER(e.description) LIKE LOWER(CONCAT('%', :description, '%'))) AND " +
	           "(:status IS NULL OR e.status = :status)")
	public List<Location> findByLocationNameContainingIgnoreCaseOrDescriptionContainingIgnoreCaseAndStatus(@Param("description") String description, @Param("status") Integer status);

}

package com.swd.carx.repository.tournamentManagement;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.swd.carx.entity.tournamentManagement.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer>, JpaSpecificationExecutor<Location>{
	
	public Location findByLocationId(int locationId);
	
	//Admin
	public List<Location> findByLocationNameContainingIgnoreCaseOrDescriptionContainingIgnoreCaseAndStatus(String locationName, String description, int status);

}

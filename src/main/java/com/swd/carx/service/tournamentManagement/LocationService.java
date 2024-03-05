package com.swd.carx.service.tournamentManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swd.carx.entity.tournamentManagement.Location;
import com.swd.carx.repository.tournamentManagement.LocationRepository;
import com.swd.carx.utilities.Constants;


@Service
public class LocationService {

	@Autowired
	private LocationRepository locationRepo;
	
	public List<Location> findAll(){
		return locationRepo.findAll();
	}
	
	public Location findById(int id) {
		Location location = locationRepo.findByLocationId(id);
		return location;
	}
	
	//Admin filter
	public List<Location> findByCombinedQuery(String searchKey, Integer status) {
		if(searchKey == null) searchKey = "";
		else searchKey = searchKey.toLowerCase();
		if(status == null) status = Constants.DEFAULT_STATUS;
		return locationRepo.findByLocationNameContainingIgnoreCaseOrDescriptionContainingIgnoreCaseAndStatus(searchKey, searchKey, status);
	}
	
	//ADD
	public Location add(Location location) {
		return locationRepo.save(location);
	}
	
	//DELETE - DEACTIVATE
	public boolean delete(int id) {
		Location location = findById(id);
		if(location == null) return false;
		location.setStatus(Constants.DELETED_STATUS);
		update(location);
		return location.getStatus() == Constants.DELETED_STATUS;
	}
		
	//UPDATE
	public Location update(Location newLocation) {
		return add(newLocation);
	}		
	
}


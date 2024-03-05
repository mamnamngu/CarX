package com.swd.carx.service.tournamentManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swd.carx.entity.tournamentManagement.MapImage;
import com.swd.carx.repository.tournamentManagement.MapImageRepository;

@Service
public class MapImageService {

	@Autowired
	private MapImageRepository mapImageRepo;
	
	public List<MapImage> findAll(){
		return mapImageRepo.findAll();
	}
	
	public MapImage findById(long id) {
		MapImage mapImage = mapImageRepo.findByMapImageId(id);
		return mapImage;
	}
	
	//Admin filter + Display
	public List<MapImage> findByMapId(Integer mapId) {
		if(mapId == null) return null;
		return mapImageRepo.findByMapMapId(mapId);
	}
	
	//ADD
	public MapImage add(MapImage mapImage) {
		return mapImageRepo.save(mapImage);
	}
	
	//DELETE - DEACTIVATE
	public boolean delete(long id) {
		MapImage mapImage = findById(id);
		if(mapImage == null) return false;
		mapImageRepo.delete(mapImage);
		return true;
	}
		
	//UPDATE
	public MapImage update(MapImage newMapImage) {
		return add(newMapImage);
	}		
}

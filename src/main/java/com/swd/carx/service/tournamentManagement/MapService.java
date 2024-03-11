package com.swd.carx.service.tournamentManagement;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swd.carx.entity.tournamentManagement.Map;
import com.swd.carx.entity.tournamentManagement.MapType;
import com.swd.carx.repository.tournamentManagement.MapRepository;
import com.swd.carx.utilities.Constants;
import com.swd.carx.view.MapDTO;


@Service
public class MapService {

	@Autowired
	private MapRepository mapRepo;
	
	public List<Map> findAll(){
		return mapRepo.findAll();
	}
	
	public Map findById(int id) {
		Map map = mapRepo.findByMapId(id);
		return map;
	}
	
	//Guest Display
	public List<Map> findByMapTypeIdDisplay(Integer mapTypeId){
		if(mapTypeId == null) return null;
		return mapRepo.findByMapTypeMapTypeIdAndStatusNot(mapTypeId, Constants.DELETED_STATUS);
	}
	
	//Admin filter
	public List<Map> findByCombinedQuery(Integer mapTypeId, String searchKey, Integer status) {
		if(searchKey == null) searchKey = "";
		else searchKey = searchKey.toLowerCase();
//		if(status == null) status = Constants.DEFAULT_STATUS;
		return mapRepo.findByCombinedQuery(mapTypeId, searchKey, searchKey, status);
	}
	
	//ADD
	public Map add(Map map) {
		return mapRepo.save(map);
	}
	
	//DELETE - DEACTIVATE
	public boolean delete(int id) {
		Map map = findById(id);
		if(map == null) return false;
		map.setStatus(Constants.DELETED_STATUS);
		update(map);
		return map.getStatus() == Constants.DELETED_STATUS;
	}
		
	//UPDATE
	public Map update(Map newMap) {
		return add(newMap);
	}		
	
	//DISPLAY
	public List<MapDTO> display(List<Map> ls){
		List<MapDTO> list = new ArrayList<MapDTO>();
		
		for(Map x: ls) {
			MapDTO y = new MapDTO();
			y.setMapId(x.getMapId());
			y.setMapName(x.getMapName());
			y.setDescription(x.getDescription());
			y.setStatus(x.getStatus());
			y.setStatusTxt(Constants.STATUSES.get(x.getStatus()));
			
			//Map Type
			MapType mapType = x.getMapType();
			y.setMapTypeId(mapType.getMapTypeId());
			y.setTypeName(mapType.getTypeName());
			
			list.add(y);
		}
		return list;
	}
	
}

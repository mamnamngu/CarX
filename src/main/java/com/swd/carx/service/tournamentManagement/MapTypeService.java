package com.swd.carx.service.tournamentManagement;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swd.carx.entity.tournamentManagement.MapType;
import com.swd.carx.entity.tournamentManagement.Tournament;
import com.swd.carx.repository.tournamentManagement.MapTypeRepository;
import com.swd.carx.utilities.Constants;
import com.swd.carx.view.MapTypeDTO;


@Service
public class MapTypeService {

	@Autowired
	private MapTypeRepository mapTypeRepo;
	
	public List<MapType> findAll(){
		return mapTypeRepo.findAll();
	}
	
	public MapType findById(int id) {
		MapType mapType = mapTypeRepo.findByMapTypeId(id);
		return mapType;
	}
	
	//Guest Display
	public List<MapType> findByTournamentIdDisplay(Long tournamentId){
		if(tournamentId == null) return null;
		return mapTypeRepo.findByTournamentTournamentIdAndStatusNot(tournamentId, Constants.DELETED_STATUS);
	}
	
	//Admin filter
	public List<MapType> findByCombinedQuery(Long tournamentId, String searchKey, Integer status) {
		if(tournamentId == null) tournamentId = Constants.DEFAULT_TOURNAMENTID;
		
		if(searchKey == null) searchKey = "";
		else searchKey = searchKey.toLowerCase();
		
//		if(status == null) status = Constants.DEFAULT_STATUS;
		return mapTypeRepo.findByCombinedQuery(tournamentId, searchKey, searchKey, status);
	}
	
	//ADD
	public MapType add(MapType mapType) {
		return mapTypeRepo.save(mapType);
	}
	
	//DELETE - DEACTIVATE
	public boolean delete(int id) {
		MapType mapType = findById(id);
		if(mapType == null) return false;
		mapType.setStatus(Constants.DELETED_STATUS);
		update(mapType);
		return mapType.getStatus() == Constants.DELETED_STATUS;
	}
		
	//UPDATE
	public MapType update(MapType newMapType) {
		return add(newMapType);
	}	
	
	//DISPLAY
	public List<MapTypeDTO> display(List<MapType> ls){
		List<MapTypeDTO> list = new ArrayList<MapTypeDTO>();
		
		for(MapType x: ls) {
			MapTypeDTO y = new MapTypeDTO();
			y.setMapTypeId(x.getMapTypeId());
			y.setTypeName(x.getTypeName());
			y.setDescription(x.getDescription());
			y.setStatus(x.getStatus());
			y.setStatusTxt(Constants.STATUSES.get(x.getStatus()));
			
			//Tournament
			Tournament tournament = x.getTournament();
			y.setTournamentId(tournament.getTournamentId());
			y.setTournamentName(tournament.getTournamentName());
			
			list.add(y);
		}
		return list;
	}
}
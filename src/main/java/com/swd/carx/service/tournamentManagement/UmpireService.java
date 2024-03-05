package com.swd.carx.service.tournamentManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swd.carx.entity.tournamentManagement.Umpire;
import com.swd.carx.repository.tournamentManagement.UmpireRepository;
import com.swd.carx.utilities.Constants;


@Service
public class UmpireService {

	@Autowired
	private UmpireRepository umpireRepo;
	
	public List<Umpire> findAll(){
		return umpireRepo.findAll();
	}
	
	public Umpire findById(int id) {
		Umpire umpire = umpireRepo.findByUmpireId(id);
		return umpire;
	}
	
	//Admin filter
	public List<Umpire> findByCombinedQuery(String searchKey, Integer status) {
		if(searchKey == null) searchKey = "";
		else searchKey = searchKey.toLowerCase();
		if(status == null) status = Constants.DEFAULT_STATUS;
		return umpireRepo.findByNameContainingIgnoreCaseAndStatus(searchKey, status);
	}
	
	//ADD
	public Umpire add(Umpire umpire) {
		return umpireRepo.save(umpire);
	}
	
	//DELETE - DEACTIVATE
	public boolean delete(int id) {
		Umpire umpire = findById(id);
		if(umpire == null) return false;
		umpire.setStatus(Constants.DELETED_STATUS);
		update(umpire);
		return umpire.getStatus() == Constants.DELETED_STATUS;
	}
		
	//UPDATE
	public Umpire update(Umpire newUmpire) {
		return add(newUmpire);
	}		
	
}

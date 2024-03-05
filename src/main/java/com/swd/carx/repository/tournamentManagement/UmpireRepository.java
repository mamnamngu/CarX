package com.swd.carx.repository.tournamentManagement;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.swd.carx.entity.tournamentManagement.Umpire;

@Repository
public interface UmpireRepository extends JpaRepository<Umpire, Integer>, JpaSpecificationExecutor<Umpire>{
	
	public Umpire findByUmpireId(int umpireId);
	
	//Admin
	public List<Umpire> findByNameContainingIgnoreCaseAndStatus(String name, int status);

}
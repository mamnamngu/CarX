package com.carx.repository.tournamentManagement;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.carx.entity.tournamentManagement.Umpire;

@Repository
public interface UmpireRepository extends JpaRepository<Umpire, Integer>, JpaSpecificationExecutor<Umpire>{
	
	public Umpire findByUmpireId(int umpireId);
	
	public List<Umpire> findByNameContainingIgnoreCaseAndStatus(String name, int status);
}
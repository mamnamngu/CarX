package com.carx.repository.tournamentManagement;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.carx.entity.tournamentManagement.Map;

@Repository
public interface MapRepository extends JpaRepository<Map, Integer>, JpaSpecificationExecutor<Map>{
	
	public Map findByMapId(int mapId);
	
	public List<Map> findByMapNameContainingIgnoreCaseAndDescriptionContainingIgnoreCaseAndStatus(String mapName, String description, int status);
}

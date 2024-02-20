package com.carx.repository.tournamentManagement;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.carx.entity.tournamentManagement.MapType;

@Repository
public interface MapTypeRepository extends JpaRepository<MapType, Integer>, JpaSpecificationExecutor<MapType>{
	
	public MapType findByMapTypeId(int mapTypeId);
	
	public List<MapType> findByTournamentTournamentIdAndTypeNameContainingIgnoreCaseAndDescriptionContainingIgnoreCaseAndStatus(long tournamentId, String typeName, String description, int status);
	
}

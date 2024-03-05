package com.swd.carx.repository.tournamentManagement;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.swd.carx.entity.tournamentManagement.MapType;

@Repository
public interface MapTypeRepository extends JpaRepository<MapType, Integer>, JpaSpecificationExecutor<MapType>{
	
	public MapType findByMapTypeId(int mapTypeId);
	
	//Guest
	public List<MapType> findByTournamentTournamentIdAndStatusNot(long tournamentId, int status);
	
	//Admin
	@Query("SELECT e FROM MapType e WHERE " +
           "(:tournamentId IS NULL OR e.tournament.tournamentId = :tournamentId) AND " +
           "((:typeName IS NULL OR LOWER(e.typeName) LIKE '%:typeName%') OR " +
           "(:description IS NULL OR LOWER(e.description) LIKE '%:description%')) AND " +
           "(:status IS NULL OR e.status = :status)")
	public List<MapType> findByCombinedQuery(@Param("tournamentId") Long tournamentId, @Param("typeName") String typeName, @Param("description") String description, @Param("status") Integer status);
	
}

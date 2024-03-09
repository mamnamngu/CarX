package com.swd.carx.repository.tournamentManagement;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.swd.carx.entity.tournamentManagement.Map;

@Repository
public interface MapRepository extends JpaRepository<Map, Integer>, JpaSpecificationExecutor<Map>{
	
	public Map findByMapId(int mapId);
	
	//Guest
	public List<Map> findByMapTypeMapTypeIdAndStatusNot(int mapTypeId, int status);
	
	//Admin
	//Combined query
	@Query("SELECT e FROM Map e WHERE " +
           "(:mapTypeId IS NULL OR e.mapType.mapTypeId = :mapTypeId) AND " +
           "((:mapName IS NULL OR LOWER(e.mapName) LIKE LOWER(CONCAT('%', :mapName, '%'))) OR " +
           "(:description IS NULL OR LOWER(e.description) LIKE LOWER(CONCAT('%', :description, '%')))) AND " +
           "(:status IS NULL OR e.status = :status)")
	public List<Map> findByCombinedQuery(@Param("mapTypeId") Integer mapTypeId, @Param("mapName") String mapName, @Param("description") String description, @Param("status") Integer status);

}

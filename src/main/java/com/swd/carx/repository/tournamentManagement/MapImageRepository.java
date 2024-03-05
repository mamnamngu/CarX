package com.swd.carx.repository.tournamentManagement;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.swd.carx.entity.tournamentManagement.MapImage;

@Repository
public interface MapImageRepository extends JpaRepository<MapImage, Long>, JpaSpecificationExecutor<MapImage>{
	
	public MapImage findByMapImageId(long mapImageId);
	
	public List<MapImage> findByMapMapId(int mapId);

}

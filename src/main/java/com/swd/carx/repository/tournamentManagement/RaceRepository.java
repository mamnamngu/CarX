package com.swd.carx.repository.tournamentManagement;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.swd.carx.entity.tournamentManagement.Race;

@Repository
public interface RaceRepository extends JpaRepository<Race, Long>, JpaSpecificationExecutor<Race>{
	
	public Race findByRaceId(long raceId);
	
	//Combined query
	@Query("SELECT e FROM Race e WHERE " +
           "(:roundId IS NULL OR e.round.roundId = :roundId) AND " +
           "(:umpireId IS NULL OR e.umpire.umpireId = :umpireId) AND " +
           "(:mapId IS NULL OR e.map.mapId = :mapId) AND " +
           "(:status IS NULL OR e.status = :status)")
	public List<Race> findByCombinedQuery(@Param("roundId") Long roundId, @Param("umpireId") Integer umpireId, @Param("mapId") Integer mapId, @Param("status") Integer status);

}

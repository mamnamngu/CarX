package com.carx.repository.tournamentManagement;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.carx.entity.tournamentManagement.CarInRace;

@Repository
public interface CarInRaceRepository extends JpaRepository<CarInRace, Long>, JpaSpecificationExecutor<CarInRace>{
	
	public CarInRace findByCarRaceId(long carRaceId);
	
	//Combined query
	@Query("SELECT e FROM CarInRace e WHERE " +
           "(:teamId IS NULL OR e.teamId = :teamId) AND " +
           "(:raceId IS NULL OR e.raceId = :raceId) AND " +
           "(e.score BETWEEN :lower AND :upper) AND " +
           "(:status IS NULL OR e.status = :status)")
	public List<CarInRace> findByTeamIdAndRaceIdAndScoreIntervalAndStatus(@Param("teamId") Long teamId, @Param("raceId") Long raceId, @Param("lower") int lower, @Param("upper") int upper, @Param("status") Integer status);

}

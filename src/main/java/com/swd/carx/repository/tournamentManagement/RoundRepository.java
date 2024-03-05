package com.swd.carx.repository.tournamentManagement;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.swd.carx.entity.tournamentManagement.Round;

@Repository
public interface RoundRepository extends JpaRepository<Round, Long>, JpaSpecificationExecutor<Round>{
	
	public Round findByRoundId(long roundId);
	
	//Guest
	public List<Round> findByTournamentTournamentIdAndStatusNot(long tournamentId, int status);

	//Admin
	@Query("SELECT e FROM Round e WHERE " +
           "(:tournamentId IS NULL OR e.tournament.tournamentId = :tournamentId) AND " +
           "(:status IS NULL OR e.status = :status)")
	public List<Round> findByTournamentTournamentIdAndStatus(@Param("tournamentId") Long tournamentId, @Param("status") Integer status);

}
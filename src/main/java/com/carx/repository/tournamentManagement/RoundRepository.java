package com.carx.repository.tournamentManagement;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.carx.entity.tournamentManagement.Round;

@Repository
public interface RoundRepository extends JpaRepository<Round, Long>, JpaSpecificationExecutor<Round>{
	
	public Round findByRoundId(long roundId);
	
	public List<Round> findByTournamentTournamentIdAndStatusNot(long tournamentId, int status);

	//Admin
	public List<Round> findByTournamentTournamentIdAndStatus(long tournamentId, int status);
}
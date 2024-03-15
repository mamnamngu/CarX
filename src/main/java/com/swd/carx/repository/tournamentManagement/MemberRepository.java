package com.swd.carx.repository.tournamentManagement;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.swd.carx.entity.tournamentManagement.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>, JpaSpecificationExecutor<Member>{
	
	public Member findByMemberId(long memberId);
	
	//Combined query
	@Query("SELECT e FROM Member e WHERE " +
           "(:studentId IS NULL OR e.student.studentId = :studentId) AND " +
           "(:teamId IS NULL OR e.team.teamId = :teamId) AND " +
           "(:tournamentId IS NULL OR e.tournament.tournamentId = :tournamentId) AND " +
           "(:schoolId IS NULL OR e.team.schoolTour.school.schoolId = :schoolId) AND " +
           "(:status IS NULL OR e.status = :status)")
	public List<Member> findByStudentIdAndTournamentIdAndStatus(@Param("studentId") Long studentId, @Param("teamId") Long teamId, @Param("tournamentId") Long tournamentId, @Param("schoolId") Integer schoolId, @Param("status") Integer status);

}

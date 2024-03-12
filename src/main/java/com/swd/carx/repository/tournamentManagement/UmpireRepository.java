package com.swd.carx.repository.tournamentManagement;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.swd.carx.entity.tournamentManagement.Umpire;

@Repository
public interface UmpireRepository extends JpaRepository<Umpire, Integer>, JpaSpecificationExecutor<Umpire>{
	
	public Umpire findByUmpireId(int umpireId);
	
	//Admin
	@Query("SELECT e FROM Umpire e WHERE " +
	           "(:name IS NULL OR LOWER(e.name) LIKE LOWER(CONCAT('%', :name, '%'))) AND " +
	           "(:status IS NULL OR e.status = :status)")
	public List<Umpire> findByNameContainingIgnoreCaseAndStatus(@Param("name") String name, @Param("status") Integer status);

}
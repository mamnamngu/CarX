package com.swd.carx.repository.tournamentManagement;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.swd.carx.entity.tournamentManagement.CarType;

@Repository
public interface CarTypeRepository extends JpaRepository<CarType, Integer>, JpaSpecificationExecutor<CarType>{
	
	public CarType findByCarTypeId(int carTypeId);
	
	//Admin
	@Query("SELECT e FROM CarType e WHERE " +
	           "(:description IS NULL OR LOWER(e.description) LIKE LOWER(CONCAT('%', :description, '%')) OR LOWER(e.name) LIKE LOWER(CONCAT('%', :description, '%'))) AND " +
	           "(:status IS NULL OR e.status = :status)")
	public List<CarType> findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCaseAndStatus(@Param("description") String description, @Param("status") Integer status);

}

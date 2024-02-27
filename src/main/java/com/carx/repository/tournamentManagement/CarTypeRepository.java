package com.carx.repository.tournamentManagement;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.carx.entity.tournamentManagement.CarType;

@Repository
public interface CarTypeRepository extends JpaRepository<CarType, Integer>, JpaSpecificationExecutor<CarType>{
	
	public CarType findByCarTypeId(int carTypeId);
	
	//Admin
	public List<CarType> findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCaseAndStatus(String name, String description, int status);

}

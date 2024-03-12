package com.swd.carx.repository.schoolManagement;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.swd.carx.entity.schoolManagement.Assistant;

public interface AssistantRepository extends JpaRepository<Assistant, Integer>, JpaSpecificationExecutor<Assistant>{

	public Assistant findByAssistantId(int assistantId);
	
	//Combined Query
	@Query("SELECT e FROM Assistant e WHERE " +
	           "(:name IS NULL OR LOWER(e.name) LIKE LOWER(CONCAT('%', :name, '%'))) AND " +
	           "(:schoolId IS NULL OR e.school.schoolId = :schoolId) AND " +
	           "(:status IS NULL OR e.status = :status)")
	public List<Assistant> findByCombinedQuery(@Param("name") String name, @Param("schoolId") Integer schoolId, @Param("status") Integer status);
}

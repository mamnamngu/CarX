package com.swd.carx.repository.authentication;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.swd.carx.entity.authentication.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>, JpaSpecificationExecutor<Role>{
	
	public Role findByRoleId(int roleId);
	
	//Combined Query
	@Query("SELECT e FROM Role e WHERE " +
	           "(:name IS NULL OR LOWER(e.name) LIKE LOWER(CONCAT('%', :name, '%'))) AND " +
	           "(:status IS NULL OR e.status = :status)")
	public List<Role> findByNameContainingIgnoreCaseAndStatus(@Param("name") String name, @Param("status") Integer status);

}

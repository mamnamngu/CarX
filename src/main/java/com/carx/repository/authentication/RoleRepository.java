package com.carx.repository.authentication;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.carx.entity.authentication.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>, JpaSpecificationExecutor<Role>{
	
	public Role findByRoleId(int roleId);
	
	//Combined Query
	public List<Role> findByNameContainingIgnoreCaseAndStatus(String name, Integer status);
}

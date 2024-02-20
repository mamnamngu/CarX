package com.carx.service.authentication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carx.entity.authentication.Role;
import com.carx.repository.authentication.RoleRepository;
import com.carx.utilities.Constants;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepo;
	
	public List<Role> findAll(){
		return roleRepo.findAll();
	}
	
	
	public Role findById(int id) {
		Role role = roleRepo.findByRoleId(id);
		return role;
	}
	
	//Admin filter
	public List<Role> findByCombinedQuery(String name, Integer status) {
		if(name == null) name = "";
		if(status == null) status = 0;
		return roleRepo.findByNameContainingIgnoreCaseAndStatus(name, status);
	}
	
	//ADD
	public Role add(Role role) {
		return roleRepo.save(role);
	}
	
	//DELETE - DEACTIVATE
	public boolean delete(int id) {
		Role role = findById(id);
		if(role == null) return false;
		role.setStatus(Constants.DELETED_STATUS);
		update(role);
		return role.getStatus() == Constants.DELETED_STATUS;
	}
		
	//UPDATE
	public Role update(Role newRole) {
		return add(newRole);
	}		
	
}
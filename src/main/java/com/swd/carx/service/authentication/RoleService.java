package com.swd.carx.service.authentication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swd.carx.entity.authentication.Role;
import com.swd.carx.repository.authentication.RoleRepository;
import com.swd.carx.utilities.Constants;

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
		else name = name.toLowerCase();
		
//		if(status == null) status = Constants.DEFAULT_STATUS;
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
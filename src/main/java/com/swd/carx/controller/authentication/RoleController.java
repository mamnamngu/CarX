package com.swd.carx.controller.authentication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.swd.carx.entity.authentication.Role;
import com.swd.carx.service.authentication.RoleService;
import com.swd.carx.utilities.Constants;

@RestController
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping("/roles")
	public ResponseEntity<List<Role>> retrieveAllRoles(){
		return ResponseEntity.ok(roleService.findAll());
    }
	
	@GetMapping("/role/{id}")
	public ResponseEntity<Role> retrieveRole(@PathVariable int id) {
		Role role = roleService.findById(id);
		if(role != null) {
			return ResponseEntity.status(HttpStatus.OK).body(role);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//Combined Query
	@GetMapping("/role/name/{name}/status/{statusStr}")
	public ResponseEntity<List<Role>> retrieveRole(@PathVariable String name, @PathVariable String statusStr) {
		//Validation
		if(name == null) name = "";
		else name = name.toLowerCase().trim();
		
		Integer status =  Constants.strToInt(statusStr);
		
		List<Role> role = roleService.findByCombinedQuery(name, status);
		return ResponseEntity.ok(role);
	}
	
	@PostMapping("/role")
	public ResponseEntity<Role> createRole(@RequestBody Role role){
		try {
			if(roleService.findById(role.getRoleId()) != null) 
				return ResponseEntity.badRequest().header("message", "Role with such ID already exists").build();
				
			Role savedRole = roleService.add(role);
			return ResponseEntity.status(HttpStatus.CREATED).body(savedRole);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).header("message", "Failed to add new role").build();
		}
	}
	
	@PutMapping("/role")
	public ResponseEntity<Role> updateRole(@RequestBody Role role){
		if(roleService.findById(role.getRoleId()) == null)
			return ResponseEntity.notFound().header("message", "No Role found for such ID").build();
		
		Role updatedRole = roleService.update(role);
		if(updatedRole != null)
			return ResponseEntity.ok(updatedRole);
		else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	@DeleteMapping("/role/{id}")
	public ResponseEntity<Void> deleteRole(@PathVariable int id){
		try{
			if(roleService.findById(id) == null) 
				return ResponseEntity.notFound().header("message", "No Role found for such ID. Deletion failed").build();
			
			roleService.delete(id);
			return ResponseEntity.noContent().header("message", "role deleted successfully").build();
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).header("message", "role deletion failed").build();
		}
	}
}

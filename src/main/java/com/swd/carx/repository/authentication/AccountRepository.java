package com.swd.carx.repository.authentication;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.swd.carx.entity.authentication.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>, JpaSpecificationExecutor<Account>{
	
	public Account findByAccountId(long accountId);
	
	//Forgot password
	public Account findByUsernameAndStatusNot(String username, int status);
	
	//Authentication
	public Account findByUsernameAndPasswordAndStatusNot(String username, String password, int status);
	
	//ADMIN
	public List<Account> findByRoleRoleIdAndStatus(Integer roleId, Integer status);
	
}

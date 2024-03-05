package com.swd.carx.service.authentication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swd.carx.entity.authentication.Account;
import com.swd.carx.repository.authentication.AccountRepository;
import com.swd.carx.utilities.Constants;


@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepo;
	
	public List<Account> findAll(){
		return accountRepo.findAll();
	}
	
	public Account findById(long id) {
		Account account = accountRepo.findByAccountId(id);
		return account;
	}
	
	//Authentication
	public Account authenticate(String username, String password) {
		return accountRepo.findByUsernameAndPasswordAndStatusNot(username, password, Constants.DELETED_STATUS);
	}
	
	//Forgot password
	public Account findByUserName(String username) {
		return accountRepo.findByUsernameAndStatusNot(username, Constants.DELETED_STATUS);
	}
	
	//Admin filter
	public List<Account> findByCombinedQuery(Integer roleId, Integer status) {
		if(roleId == null) roleId = Constants.DEFAULT_ROLE;
		if(status == null) status = Constants.DEFAULT_STATUS;
		return accountRepo.findByRoleRoleIdAndStatus(roleId, status);
	}
	
	//ADD
	public Account add(Account account) {
		//Check if username exists
		if(findByUserName(account.getUsername()) != null) return null;
		
		//Validate password
		if(account.getUsername().length() < Constants.USERNAME_MIN_LENGTH || account.getPassword().length() < Constants.PASSWORD_MIN_LENGTH) return null;
		
		return accountRepo.save(account);
	}
	
	//DELETE - DEACTIVATE
	public boolean delete(long id) {
		Account account = findById(id);
		if(account == null) return false;
		account.setStatus(Constants.DEFAULT_STATUS);
		update(account);
		return account.getStatus() == Constants.DEFAULT_STATUS;
	}
		
	//UPDATE
	public Account update(Account newAccount) {
		//Check if username exists
		if(findByUserName(newAccount.getUsername()) != null) return null;
		
		//Validate password
		if(newAccount.getUsername().length() < Constants.USERNAME_MIN_LENGTH || newAccount.getPassword().length() < Constants.PASSWORD_MIN_LENGTH) return null;
		
		return add(newAccount);
	}		
}

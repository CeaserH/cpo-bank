package com.cpo.bank.service;

import java.util.List;
import java.util.Optional;

import javax.security.auth.login.AccountException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpo.bank.model.Account;
import com.cpo.bank.repository.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
	AccountRepository accountRepository;

	
	//All Accounts
	public List<Account> getAllAccounts(){
		return (List<Account>) accountRepository.findAll();
	}
	
	//Specific Account
	public Account getAccountById(long accountID) throws AccountException {
		Optional<Account> account = accountRepository.findById(accountID);
		if(account.isPresent()) {
			return account.get();
		}
		
//		** removed else add exception for account number not found
		throw new AccountException("Account not found for account number: " + accountID);
	}
	
	//update customer name
	public boolean updateName(long id, String name) throws AccountException {
		if(accountRepository.save(id).equals(id) && accountRepository.save(name).equals(name)) {
			return true;
		}
		throw new AccountException("No such account exists in db.");
	}
	
	//update customer contact
	
	public boolean updateContact(long id, String contact) throws AccountException {
		if(accountRepository.save(id).equals(id) && accountRepository.save(contact).equals(contact)) {
			return true;
		}
		throw new AccountException("No such account exists in db.");
	}
	
	
	//update customer address 
	
	public boolean updateAddress(long id, String address) throws AccountException {
		if(accountRepository.save(id).equals(id) && accountRepository.save(address).equals(address)) {
			return true;
		}
		throw new AccountException("No such account exists in db.");
	}
	
	//Create Account
	public Account createAccount(Account account) {
		return accountRepository.save(account);
	}
	
	//Update Account
	public void updateAccount(Account account) {
		accountRepository.save(account);
	}

	//Delete Account
	public void deleteById(long id) {
		accountRepository.deleteById(id);
	}

}

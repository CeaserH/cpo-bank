package com.cpo.bank.service;

import java.util.List;
import java.util.ArrayList;
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
	
//	update customer name
	
	public void updateName(Long accountID, String name) throws AccountException {
//		if(accountRepository.findById(accountID) != null) {
		Account tempAcc = accountRepository.findById(accountID).get();
		tempAcc.setCustomerName(name);
		accountRepository.save(tempAcc);
//		}
//		throw new AccountException("No such acocunt exists in db.");
	}
//	
//	//update customer contact
	
	public void updateContact(long id, String contact) throws AccountException {
//		if(accountRepository.findById(id) != null) {
			Account tempAcc = accountRepository.findById(id).get();
			tempAcc.setCustomerContact(contact);
			accountRepository.save(tempAcc);
//		}
//		throw new AccountException("No such account exists in db.");
	}
//	
//	
//	//update customer address 
//	
	public void updateAddress(long id, String address) throws AccountException {
//		if(accountRepository.findById(id) != null) {
			Account tempAcc = accountRepository.findById(id).get();
			tempAcc.setCustomerAddress(address);
			accountRepository.save(tempAcc);
//		}
//		throw new AccountException("No such account exists in db.");
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
	
	//set status closed
	
	public void deleteById(long accountID) {
		accountRepository.deleteById((long) accountID);
	}



}

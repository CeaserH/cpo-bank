package com.cpo.bank.service;

import java.util.List;
import java.util.Optional;

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
	public Account getAccountById(long id) {
		Optional<Account> account = accountRepository.findById(id);
		if(account.isPresent()) {
			return account.get();
		}
		else {
			return null;
		}
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

package com.cpo.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpo.bank.model.Account;
import com.cpo.bank.repository.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
	AccountRepository accountRepository;
	
	public void createAccount(Account account) {
		accountRepository.save(account);
	}

}

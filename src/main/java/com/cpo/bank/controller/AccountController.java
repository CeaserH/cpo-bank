package com.cpo.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cpo.bank.model.Account;
import com.cpo.bank.service.AccountService;

@RestController
public class AccountController {

	@Autowired
	AccountService accountService;
	
	//Create an account
	@PostMapping("/account/create")
	private long createAccount(@RequestBody Account account) {
		accountService.createAccount(account);
		return account.getAccountID();
	}
	
}

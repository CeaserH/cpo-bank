package com.cpo.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cpo.bank.model.Account;
import com.cpo.bank.service.AccountService;

@RestController
public class AccountController {

	@Autowired
	AccountService accountService;
	
	//get All Accounts
	@GetMapping("/allAccounts")
	private List<Account> getAllAccounts(){
		return accountService.getAllAccounts();
	}
	
	// get Account by ID
	@GetMapping("/account/{accountID}")
	private Account getAccount(@PathVariable("accountID") int accountID) {
		return accountService.getAccountById(accountID);
	}
	
	//add Account
	@PostMapping("/account")
	private Account saveAccount(@RequestBody Account account) {
		accountService.createAccount(account);
		return account;
	}
	
	//update Account
	@PutMapping("/account")
	private Account update(@RequestBody Account account) {
		accountService.updateAccount(account);
		return account;
	}
	
	//Delete Account
	@DeleteMapping("/account/{accountID}")
	private void deleteAccount(@PathVariable("accountID") int accountID) {
		accountService.deleteById(accountID);
	}
}

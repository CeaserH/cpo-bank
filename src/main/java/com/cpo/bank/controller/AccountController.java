package com.cpo.bank.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cpo.bank.model.Account;
import com.cpo.bank.service.AccountService;

@RestController
public class AccountController {

	@Autowired
	AccountService accountService;

	//get All Accounts
	@GetMapping("/accounts/all")
	private List<Account> getAllAccounts(){
		return accountService.getAllAccounts();
	}
	
	// get Account by ID
	@GetMapping("/accounts/id/{accountID}")
	private Account getAccount(@PathVariable("accountID")long accountID) {
		return accountService.getAccountById(accountID);
	}
	
	//Account Creation
	@PostMapping("/accounts/create")
	private void createAccount(@RequestBody Map<String, Object> request) {
		//accountService.createAccount(account);
	}
	
	//Update Customer Name
	@PutMapping("/accounts/update/name")
	private void updateCustomerName(@RequestBody Map<String, Object> request) {
		
	}
	
	//Update Customer Contact
	@PutMapping("/accounts/update/contact")
	private void updateCustomerContact(@RequestBody Map<String, Object> request) {
		
	}
	
	//Update Customer Address
	@PutMapping("/accounts/update/address")
	private void updateCustomerAddress(@RequestBody Map<String, Object> request) {
		
	}
	
	//Delete Account
	@DeleteMapping("/accounts/delete/{accountID}")
	private void deleteAccount(@PathVariable("accountID") int accountID) {
		accountService.deleteById(accountID);
	}
	
}

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
	@PutMapping("/accounts/id/{accountID}/name/{customerName}")
	private void updateCustomerName(@PathVariable("accountID") long accountID, @PathVariable("customerName") String customerName) {
		
	}
	
	//Update Customer Contact
	@PutMapping("/accounts/id/{accountID}/contact/{customerContact}")
	private void updateCustomerContact(@PathVariable("accountID") long accountID, @PathVariable("customerContact") String customerContact) {
		
	}
	
	//Update Customer Address
	@PutMapping("/accounts/update/address")
	private void updateCustomerContact(@RequestBody Map<String, Object> request) {
		
	}
	
	//Delete Account
	@DeleteMapping("/accounts/delete/{accountID}")
	private void deleteAccount(@PathVariable("accountID") int accountID) {
		accountService.deleteById(accountID);
	}
	
}

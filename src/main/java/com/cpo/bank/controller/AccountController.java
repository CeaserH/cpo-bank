package com.cpo.bank.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.security.auth.login.AccountException;

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
	private Account getAccount(@PathVariable("accountID")long accountID) throws AccountException {
		return accountService.getAccountById(accountID);
	}
	
	//Account Creation
	@PostMapping("/accounts/create")
	private void createAccount(@RequestBody Map<String, Object> request) {
		/*
			REQUEST STRUCTURE:
			{
				AddressLine1
				AddressLine2
				City
				State
				Country
				ZipCode
				CustomerName
				CustomerContact
				CustomerSSN
				CustomerDOB
				CustomerGender
				AccountType
				Balance
				Interest
				BranchID?
			}
		 */
		
		String address = "";
		address += request.get("AddressLine1") + " ";
		address += request.get("AddressLine2") + " ";
		address += request.get("City") + ", ";
		address += request.get("State") +  " ";
		address += request.get("ZipCode") + " ";
		address += request.get("Country");
		
		Account account = new Account();
		
		//Address
		account.setCustomerAddress(address);
		
		//Customer
		account.setCustomerName((String)request.get("CustomerName"));
		account.setCustomerContact((String)request.get("CustomerContact"));
		//account.setCustomerSSN((String)request.get("CustomerSSN"));
		account.setCustomerDOB((Date)request.get("CustomerDOB"));
		account.setCustomerGender((String)request.get("CustomerGender"));
		
		//Account
		account.setAccountType((String)request.get("AccountType"));
		account.setAccountStatus("Open");
		//account.setAccountBalance(request.get("Balance"));
		//account.setAccountInterest(request.get("Interest"));
		
		accountService.createAccount(account);
		
	}
	
	//Update Customer Name
	@PutMapping("/accounts/update/name")
	private void updateCustomerName(@RequestBody Map<String, Object> request) throws AccountException {
		/*
		REQUEST STRUCTURE:
		{
			AccountID
			CustomerNewName
		}
		 */
		
		long id = Long.valueOf((String)request.get("AccountID"));
		String name = (String)request.get("CustomerNewName");
		
		accountService.updateName(id, name);
		
	}
	
	//Update Customer Contact
	@PutMapping("/accounts/update/contact")
	private void updateCustomerContact(@RequestBody Map<String, Object> request) throws AccountException {
		/*
		REQUEST STRUCTURE:
		{
			AccountID
			CustomerNewContact
		}
		 */
		
		long id = Long.valueOf((String)request.get("AccountID"));
		String contact = (String)request.get("CustomerNewContact");
		
		accountService.updateContact(id, contact);
		
	}
	
	//Update Customer Address
	@PutMapping("/accounts/update/address")
	private void updateCustomerAddress(@RequestBody Map<String, Object> request) throws AccountException {
		/*
		REQUEST STRUCTURE:
		{
			AccountID
			AddressLine1
			AddressLine2
			City
			State
			Country
			ZipCode
		}
		 */
		
		long id = Long.valueOf((String)request.get("AccountID"));
		
		String address = "";
		address += request.get("AddressLine1") + " ";
		address += request.get("AddressLine2") + " ";
		address += request.get("City") + ", ";
		address += request.get("State") +  " ";
		address += request.get("ZipCode") + " ";
		address += request.get("Country");

		accountService.updateAddress(id, address);
		
	}
	
	//Delete Account
	@DeleteMapping("/accounts/delete/{accountID}")
	private void deleteAccount(@PathVariable("accountID") int accountID) {
		accountService.deleteById(accountID);
	}
	
}

package com.cpo.bank.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cpo.bank.model.Check;
import com.cpo.bank.model.Transaction;
import com.cpo.bank.service.TransactionService;

@RestController
public class TransactionController {

	@Autowired
	TransactionService transactionService;
	
	//get All Accounts
	@GetMapping("/transactions/all")
	private List<Transaction> getAllTransactions(){
		return transactionService.getAllTransactions();
	}
	
	// get Transaction by ID
	@GetMapping("/transactions/id/{transactionID}")
	private Transaction getTransaction(@PathVariable("transactionID") int transactionID) {
		return transactionService.getTransactionById(transactionID);
	}
	
	@PostMapping("/transactions/slip/credit")
	private void slipCredit(@RequestBody Map<String, Object> request) {
		/*
			REQUEST FORMAT
			{
				AccountID
				Amount
			}
		 */
		
		double amount = Double.valueOf((String)request.get("Amount"));
		Long accountID = Long.valueOf((String)request.get("AccountID"));
		
		transactionService.slipCredit(accountID, amount);
		
	}
	
	@PostMapping("/transactions/slip/debit")
	private void slipDebit(@RequestBody Map<String, Object> request) {
		/*
			REQUEST FORMAT
			{
				AccountID
				Amount
			}
		 */
		
		double amount = Double.valueOf((String)request.get("Amount"));
		Long accountID = Long.valueOf((String)request.get("AccountID"));
		
		transactionService.slipDebit(accountID, amount);
		
	}
	
	@PostMapping("/transactions/check/credit")
	private void checkCredit(@RequestBody Map<String, Object> request) {
		/*
			REQUEST FORMAT
			{
				PayeeAccountNumber
				BeneficiaryAccountNumber
				Amount
				CheckNumber
				BankNumber
				IFSC
				IssueDate
			}
		 */
		
		Check check = new Check();
		
		//need to set values in check
		
		transactionService.checkCredit(check);
		
	}
	
	@PostMapping("/transactions/check/debit") 
	private void checkDebit(@RequestBody Map<String, Object> request) {
		/*
			REQUEST FORMAT
			{
				AccountNumber (Beneficiary)
				Amount
				CheckNumber
				BankNumber
				IFSC
				IssueDate
			}
		 */
		
		Check check = new Check();
		
		//need to set values in check
		
		transactionService.checkDebit(check);
	
	}
	
}

package com.cpo.bank.controller;

import java.util.Date;
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
				PayeeAccountNumber			: String (Long)
				BeneficiaryAccountNumber	: String (Long)
				Amount						: String (Double)
				CheckNumber					: String (Integer)
				BankName					: String
				IFSC						: String
				IssueDate					: String (Long)
			}
		 */
		
		Check check = new Check();
		
		check.setPayeeAccountID(Long.valueOf((String)request.get("PayeeAccountNumber")));
		check.setBeneficiaryAccountID(Long.valueOf((String)request.get("BeneficiaryAccountNumber")));
		check.setAmount(Double.valueOf((String)request.get("Amount")));
		check.setCheckNumber(Integer.valueOf((String)request.get("CheckNumber")));
		check.setBankName((String)request.get("BankName"));
		check.setIfsc((String)request.get("IFSC"));
		check.setIssueDate(new Date(Long.valueOf((String)request.get("IssueDate"))));
		
		transactionService.checkCredit(check);
		
	}
	
	@PostMapping("/transactions/check/debit") 
	private void checkDebit(@RequestBody Map<String, Object> request) {
		/*
			REQUEST FORMAT
			{
				AccountNumber (Beneficiary)	: String (Long)
				Amount						: String (Double)
				CheckNumber					: String (Integer)
				BankNumber					: String
				IFSC						: String
				IssueDate					: String (Long)
			}
		 */
		
		Check check = new Check();
		
		check.setBeneficiaryAccountID(Long.valueOf((String)request.get("AccountNumber")));
		check.setAmount(Double.valueOf((String)request.get("Amount")));
		check.setCheckNumber(Integer.valueOf((String)request.get("CheckNumber")));
		check.setBankName((String)request.get("BankName"));
		check.setIfsc((String)request.get("IFSC"));
		check.setIssueDate(new Date(Long.valueOf((String)request.get("IssueDate"))));
		
		transactionService.checkDebit(check);
	
	}
	
}

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
		
	}
	
	@PostMapping("/transactions/slip/debit")
	private void slipDebit(@RequestBody Map<String, Object> request) {
		
	}
	
	@PostMapping("/transactions/check/credit")
	private void checkCredit(@RequestBody Map<String, Object> request) {
		
	}
	
	@PostMapping("/transactions/check/debit") 
	private void checkDebit(@RequestBody Map<String, Object> request) {
		
	}
	
}

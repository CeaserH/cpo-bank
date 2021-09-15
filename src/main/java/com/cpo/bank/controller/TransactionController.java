package com.cpo.bank.controller;

import java.util.List;

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
	@GetMapping("/allEmployees")
	private List<Transaction> getAllLoans(){
		return transactionService.getAllTransactions();
	}
	
	// get Transaction by ID
	@GetMapping("/transaction/{transactionID}")
	private Transaction getLoan(@PathVariable("transactionID") int transactionID) {
		return transactionService.getTransactionById(transactionID);
	}
	
	//add Transaction
	@PostMapping("/transaction")
	private Transaction saveLoan(@RequestBody Transaction transaction) {
		transactionService.createTransaction(transaction);
		return transaction;
	}
	
	//update Transaction
	@PutMapping("/transaction")
	private Transaction update(@RequestBody Transaction transaction) {
		transactionService.updateTransaction(transaction);
		return transaction;
	}
	
	//Delete Transaction
	@DeleteMapping("/transaction/{transactionID}")
	private void deleteLoan(@PathVariable("transactionID") int transactionID) {
		transactionService.deleteById(transactionID);
	}
	
}

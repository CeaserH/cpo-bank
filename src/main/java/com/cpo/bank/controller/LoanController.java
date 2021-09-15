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

import com.cpo.bank.model.Loan;
import com.cpo.bank.service.LoanService;

public class LoanController {

	@Autowired
	LoanService loanService;
	
	//get All Loans
	@GetMapping("/loans/all")
	private List<Loan> getAllLoans(){
		return loanService.getAllLoans();
	}
	
	// get Loan by ID
	@GetMapping("/loans/id/{loanID}")
	private Loan getLoan(@PathVariable("loanID") int loanID) {
		return loanService.getLoanById(loanID);
	}
	
	//Loan Request (create loan)
	@PostMapping("/loans/request")
	private void requestLoan(@RequestBody Map<String, Object> request) {
		
	}
	
	
	//Loan Disbursal
	@PutMapping("/loans/disbursal")
	private void disburseLoan(@RequestBody Map<String, Object> request) {
		
	}
	
}

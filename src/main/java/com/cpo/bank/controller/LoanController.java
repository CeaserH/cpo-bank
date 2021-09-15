package com.cpo.bank.controller;

import java.util.List;

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
	
	//get All Accounts
	@GetMapping("/allEmployees")
	private List<Loan> getAllLoans(){
		return loanService.getAllLoans();
	}
	
	// get Loan by ID
	@GetMapping("/loan/{loanID}")
	private Loan getLoan(@PathVariable("loanID") int loanID) {
		return loanService.getLoanById(loanID);
	}
	
	//add Loan
	@PostMapping("/loan")
	private Loan saveLoan(@RequestBody Loan loan) {
		loanService.createLoan(loan);
		return loan;
	}
	
	//update Loan
	@PutMapping("/loan")
	private Loan update(@RequestBody Loan loan) {
		loanService.updateLoan(loan);
		return loan;
	}
	
	//Delete Loan
	@DeleteMapping("/loan/{loanID}")
	private void deleteLoan(@PathVariable("loanID") int loanID) {
		loanService.deleteById(loanID);
	}
	
}

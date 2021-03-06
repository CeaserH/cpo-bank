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
		
		/*
			REQUEST FORMAT
			{
				AccountID
				Amount
				Tenure
				CreditScore
				RateOfInterest
				LoanStatus
				LoanType
			}
		 */
		
		Loan loan = new Loan();
		
		loan.setAccountID(Long.valueOf((String)request.get("AccountID")));
		loan.setAmount(Double.valueOf((String)request.get("Amount")));
		loan.setTenure(Integer.valueOf((String)request.get("Tenure")));
		loan.setCreditScore(Integer.valueOf((String)request.get("CreditScore")));
		loan.setRateOfInterest(Integer.valueOf((String)request.get("RateOfInteres")));
		loan.setLoanStatus((String)request.get("LoanStatus"));
		loan.setLoanType((String)request.get("LoanType"));
		
		loanService.createLoan(loan);
		
	}
	
	
	//Loan Disbursal
	@PutMapping("/loans/disbursal")
	private void disburseLoan(@RequestBody Map<String, Object> request) {
		
		/*
			REQUEST FORMAT
			{
				LoanID
				Action
			}
		 */
		
		Long loanID = Long.valueOf((String)request.get("LoanID"));
		String action = (String) request.get("Action");
		
		loanService.disburse(loanID, action);
		
	}
	
}

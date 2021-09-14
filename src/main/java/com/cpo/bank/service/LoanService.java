package com.cpo.bank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpo.bank.model.Loan;
import com.cpo.bank.repository.LoanRepository;

@Service
public class LoanService {
	
	@Autowired
	LoanRepository loanRepository;
	
	//All Checks
	public List<Loan> getAllLoans(){
		return (List<Loan>) loanRepository.findAll();
	}
	
	//Specific Loan
	public Loan getLoanById(int id) {
		Optional<Loan> loan = loanRepository.findById(id);
		if(loan.isPresent()) {
			return loan.get();
		}
		else {
			return null;
		}
	}
	
	//Create Loan
	public Loan createLoan(Loan loan) {
		return loanRepository.save(loan);
	}
	
	//Update Loan
	public void updateLoan(Loan loan, int loanID) {
		loanRepository.save(loan);
	}

	//Delete Loan
	public void deleteById(int id) {
		loanRepository.deleteById(id);
	}

}

package com.cpo.bank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpo.bank.model.Transaction;
import com.cpo.bank.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	TransactionRepository transactionRepository;
	
	//All Checks
	public List<Transaction> getAllTransactions(){
		return (List<Transaction>) transactionRepository.findAll();
	}
	
	//Specific Transaction
	public Transaction getTransactionById(int id) {
		Optional<Transaction> transaction = transactionRepository.findById(id);
		if(transaction.isPresent()) {
			return transaction.get();
		}
		else {
			return null;
		}
	}
	
	//Create Transaction
	public Transaction createTransaction(Transaction transaction) {
		return transactionRepository.save(transaction);
	}
	
	//Update Transaction
	public void updateTransaction(Transaction transaction) {
		transactionRepository.save(transaction);
	}

	//Delete Transaction
	public void deleteById(int id) {
		transactionRepository.deleteById(id);
	}
	
}

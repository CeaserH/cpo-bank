package com.cpo.bank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpo.bank.model.Account;
import com.cpo.bank.model.Check;
import com.cpo.bank.model.Transaction;
import com.cpo.bank.repository.AccountRepository;
import com.cpo.bank.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	TransactionRepository transactionRepository;
	@Autowired
	AccountRepository accountRepository;
	
	//Credit Via Slip
	public void slipCredit(long id, double amount) {
		
		Transaction transact = new Transaction();
		
		transact.setTransactionMethod("Slip");
		transact.setTransactionType("Credit");
		transact.setAmount(amount);
		
		Account account = accountRepository.findById(id).get();
		transact.setAccount(account);
		account.setAccountBalance(account.getAccountBalance() + amount);
		
		transactionRepository.save(transact);
		
	}
	
	//Debit Via Slip
	public void slipDebit(long id, double amount) {
		
Transaction transact = new Transaction();
		
		transact.setTransactionMethod("Slip");
		transact.setTransactionType("Debit");
		transact.setAmount(amount);
		
		Account account = accountRepository.findById(id).get();
		transact.setAccount(account);
		account.setAccountBalance(account.getAccountBalance() - amount);
		
		transactionRepository.save(transact);
		
	}
	
	//Credit Via Check
	public void checkCredit(Check check) {
		
	}
	
	//Debit Via Check
	public void checkDebit(Check check) {
		
	}
	
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

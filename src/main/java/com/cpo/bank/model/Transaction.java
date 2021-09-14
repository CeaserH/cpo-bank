package com.cpo.bank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Transaction {

	@Id
	@Column
	private long transactionID;
	
	//Debit or Credit
	private String transactionType;
	
	//Slip or Check
	private String transactionMethod;
	
	private double amount;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="accountID", nullable=false)
	private Account account;
	
	public Transaction() {
		
	}
	

	public Transaction(long transactionID, String transactionType, String transactionMethod, double amount,
			Account account) {
		super();
		this.transactionID = transactionID;
		this.transactionType = transactionType;
		this.transactionMethod = transactionMethod;
		this.amount = amount;
		this.account = account;
	}

	public long getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(long transactionID) {
		this.transactionID = transactionID;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getTransactionMethod() {
		return transactionMethod;
	}

	public void setTransactionMethod(String transactionMethod) {
		this.transactionMethod = transactionMethod;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	
	
}

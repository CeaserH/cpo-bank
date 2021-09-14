package com.cpo.bank.model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table
public class Account {
	
	//AccountInfo
	@Id
	@Column
	private long accountID;
	@Column
	private double balance;
	@Column
	private String accountStatus;
	
	//AccountID is foreign key
	@OneToMany(mappedBy="account")
	private Set<Transaction> transactions;
	
	@OneToMany(mappedBy="account")
	private Set<Loan> loans;
	
	//CustomerInfo
	@Column
	private String customerName;
	@Column
	private String customerContact;
	@Column
	private String customerAddress;
	@Column
	private int customerSSN;
	@Column
	private String customerDOB; //change to date type
	@Column
	private String customerGender;
	

	
	public long getAccountID() {
		return accountID;
	}
	public void setAccountID(long accountID) {
		this.accountID = accountID;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	
	
	
	public Set<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerContact() {
		return customerContact;
	}
	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public int getCustomerSSN() {
		return customerSSN;
	}
	public void setCustomerSSN(int customerSSN) {
		this.customerSSN = customerSSN;
	}
	public String getCustomerDOB() {
		return customerDOB;
	}
	public void setCustomerDOB(String customerDOB) {
		this.customerDOB = customerDOB;
	}
	public String getCustomerGender() {
		return customerGender;
	}
	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}

}

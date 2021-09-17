package com.cpo.bank.model;


import java.util.Date;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name="account_table")
public class Account {
	
	//AccountInfo
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long accountID;
	@Column
	private double accountBalance;
	@Column
	private double accountInterest;
	@Column
	private String accountStatus;
	@Column
	private String accountType;
	
	
	//AccountID is foreign key
	//are these necessary? can they exist only in linked classes?
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
	private Date customerDOB; //change to date type
	@Column
	private String customerGender;
	

	////////////////////////////////////////////
	/// GETTERS AND SETTERS FOR ACCOUNT INFO ///
	////////////////////////////////////////////
	public long getAccountID() {
		return accountID;
	}
	public void setAccountID(long accountID) {
		this.accountID = accountID;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public double getAccountInterest() {
		return accountInterest;
	}
	public void setAccountInterest(double accountInterest) {
		this.accountInterest = accountInterest;
	}
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	
	/////////////////////////////////////////
	/// GETTERS AND SETTERS FOR RELATIONS ///
	/////////////////////////////////////////
	public Set<Loan> getLoans() {
		return loans;
	}
	public void setLoans(Set<Loan> loans) {
		this.loans = loans;
	}
	public Set<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	
	/////////////////////////////////////////////
	/// GETTERS AND SETTERS FOR CUSTOMER INFO ///
	/////////////////////////////////////////////
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
	public Date getCustomerDOB() {
		return customerDOB;
	}
	public void setCustomerDOB(Date customerDOB) {
		this.customerDOB = customerDOB;
	}
	public String getCustomerGender() {
		return customerGender;
	}
	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}


}

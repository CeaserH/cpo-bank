package com.cpo.bank.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Account {
	
	@Id
	@Column
	private long accountID;
	@Column
	private double balance;
	@Column
	private String accountStatus;
	
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
	
	@OneToMany(mappedBy="check", fetch = FetchType.LAZY)
	private List<Check> checks;
	
	@OneToMany(mappedBy="slip", fetch=FetchType.LAZY)
	private List<Slip> slips;
	
	
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
	public List<Check> getChecks() {
		return checks;
	}
	public void setChecks(List<Check> checks) {
		this.checks = checks;
	}
	public List<Slip> getSlips() {
		return slips;
	}
	public void setSlips(List<Slip> slips) {
		this.slips = slips;
	}
	
	

}

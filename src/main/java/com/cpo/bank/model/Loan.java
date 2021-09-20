package com.cpo.bank.model;

import javax.persistence.*;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name="loan_table")
public class Loan {
	
	//LoanInfo
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long loanID;
	@Column
	private long accountID;
	@Column
	private double amount;
	@Column
	private int tenure;
	@Column
	private int creditScore;
	@Column
	private int rateOfInterest;
	@Column
	private String loanStatus;
	@Column
	private String loanType;
	
	/*
	//Foreign Key
	@ManyToOne
	@JoinColumn(name="accountID", nullable=false)
	private Account account;
	*/
	
	public Loan() {}

	public long getLoanID() {
		return loanID;
	}
	public void setLoanID(long loanID) {
		this.loanID = loanID;
	}
	/*
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	*/
	public long getAccountID() {
		return accountID;
	}
	public void setAccountID(long accountID) {
		this.accountID = accountID;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getTenure() {
		return tenure;
	}
	public void setTenure(int tenure) {
		this.tenure = tenure;
	}
	public int getCreditScore() {
		return creditScore;
	}
	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}
	public int getRateOfInterest() {
		return rateOfInterest;
	}
	public void setRateOfInterest(int rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}
	public String getLoanStatus() {
		return loanStatus;
	}
	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	
}

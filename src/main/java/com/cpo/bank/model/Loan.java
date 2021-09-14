package com.cpo.bank.model;

import javax.persistence.*;

import org.hibernate.validator.constraints.Range;

@Entity
@Table
public class Loan {
	
	@Id
	@Column
	private long loanID;
	
	@ManyToOne
	@JoinColumn(name="accountID", nullable=false)
	private Account account;
	
	@Column(nullable=false)
	@Range(min=1000, max=1000000)
	private double amount;
	
	@Column(nullable=false)
	@Range(min=12, max=240)
	private int tenure;
	
	@Column(nullable=false)
	@Range(min=100, max=999)
	private int creditScore;
	
	@Column(nullable=false)
	@Range(min=4, max=15)
	private int rateOfInterest;
	
	@Column(nullable=false)
	private String loanStatus;
	
	@Column(nullable=false)
	private String loanType;
	
	public Loan() {
		
	}

	public Loan(long loanID, Account account, @Range(min = 1000, max = 1000000) double amount,
			@Range(min = 12, max = 240) int tenure, @Range(min = 100, max = 999) int creditScore,
			@Range(min = 4, max = 15) int rateOfInterest, String loanStatus, String loanType) {
		super();
		this.loanID = loanID;
		this.account = account;
		this.amount = amount;
		this.tenure = tenure;
		this.creditScore = creditScore;
		this.rateOfInterest = rateOfInterest;
		this.loanStatus = loanStatus;
		this.loanType = loanType;
	}

	public long getLoanID() {
		return loanID;
	}

	public void setLoanID(long loanID) {
		this.loanID = loanID;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
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

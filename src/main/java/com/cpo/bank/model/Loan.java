package com.cpo.bank.model;

import javax.persistence.*;

@Entity
@Table
public class Loan {
	
	@Id
	@Column
	private long loanID;
	
	@ManyToOne
	@JoinColumn(name="accountID", nullable=false)
	private Account account;
	
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
	//needs more stuff

}

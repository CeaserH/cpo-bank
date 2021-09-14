package com.cpo.bank.model;

import javax.persistence.*;

@Entity
@Table
public class Transaction {

	@Id
	@Column
	private long transactionID;
	
	//Foreign Key
	@ManyToOne
	@JoinColumn(name="accountID", nullable=false)
	private Account account;
	
	@Column
	private String transactionType;
	@Column
	private double amount;
	
}

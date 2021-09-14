package com.cpo.bank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Range;

@Entity
@Table
public class Slip {
	
	@Column(nullable=false, length=4)
	private long transactionID;
	
	@Column(nullable=false)
	@Range(min=10, max=100000)
	private double amount;
	
	//Connect Slip to Transaction ID
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="transactionID")
	private Transaction transaction;
	
	public Slip() {
		
	}

	public Slip(long transactionID, double amount) {
		super();
		this.transactionID = transactionID;
		this.amount = amount;
	}

	public long getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(long transactionID) {
		this.transactionID = transactionID;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	

}

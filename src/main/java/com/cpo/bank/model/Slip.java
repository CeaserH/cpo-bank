package com.cpo.bank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name="slip_table")
public class Slip {
	
	@Id
	@Column
	private int id;
	
	@Column(nullable=false, length=4)
	private long transactionID;
	
	@Column(nullable=false)
	@Range(min=10, max=100000)
	private double amount;
	
	//Connect Slip to Transaction ID
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="transactionID", insertable=false, updatable=false)
	private Transaction transaction;
	
	public Slip() {
		
	}

	public Slip(int id, long transactionID, double amount) {
		super();
		this.id = id;
		this.transactionID = transactionID;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
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

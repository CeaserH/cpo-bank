package com.cpo.bank.model;

import javax.persistence.*;

@Entity
@Table(name="passbook_table")
public class Passbook {

	@Id
	@Column
	private int id;
	private long accountID;
	
	@ManyToOne
	@JoinColumn(name="transactionID", nullable=false)
	private Transaction transaction;
	
	
	public Passbook() {
		
	}


	public Passbook(int id, long accountID, Transaction transaction) {
		super();
		this.id = id;
		this.accountID = accountID;
		this.transaction = transaction;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public long getAccountID() {
		return accountID;
	}


	public void setAccountID(long accountID) {
		this.accountID = accountID;
	}


	public Transaction getTransaction() {
		return transaction;
	}


	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
	
	
	
}

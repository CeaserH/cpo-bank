package com.cpo.bank.model;

import javax.persistence.*;

@Entity
@Table(name="passbook_table")
public class Passbook {

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long passbookID;
	
	@OneToOne
	@JoinColumn(name="accountID", nullable=false)
	private Account account;
	
	@ManyToOne
	@JoinColumn(name="transactionID", nullable=false)
	private Transaction transaction; //I think this should be a set of transactions
	
	public Passbook() {}

	public long getPassbookID() {
		return passbookID;
	}
	public void setPassbookID(long passbookID) {
		this.passbookID = passbookID;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Transaction getTransaction() {
		return transaction;
	}
	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
	
}

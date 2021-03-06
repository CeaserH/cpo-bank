package com.cpo.bank.model;


import javax.persistence.*;


@Entity
@Table(name="transaction_table")
public class Transaction {

	//TransactionInfo
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long transactionID;
	@Column
	private String transactionType; //Debit or Credit
	@Column
	private String transactionMethod; //Slip or Check
	@Column
	private double amount;
	
	//Foreign Key
	@ManyToOne
	@JoinColumn(name="accountID", nullable=false)
	private Account account;
	
	///////////////
	/// METHODS ///
	///////////////
	
	public Transaction() {
		
	}
	

	public Transaction(long transactionID, String transactionType, String transactionMethod, double amount,
			Account account) {
		super();
		this.transactionID = transactionID;
		this.transactionType = transactionType;
		this.transactionMethod = transactionMethod;
		this.amount = amount;
		this.account = account;
	}

	public long getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(long transactionID) {
		this.transactionID = transactionID;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getTransactionMethod() {
		return transactionMethod;
	}

	public void setTransactionMethod(String transactionMethod) {
		this.transactionMethod = transactionMethod;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	
	
}

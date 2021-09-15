package com.cpo.bank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name="slip_table")
public class Slip {
	
	//SlipInfo
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long slipID;
	@Column
	private double amount;
	
	/* foreigh key???
	@Column(nullable=false, length=4)
	private long transactionID;
	*/

	//Connect Slip to Transaction ID
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="transactionID", insertable=false, updatable=false)
	private Transaction transaction;
	
	///////////////
	/// METHODS ///
	///////////////
	
	public Slip() {}

	public long getSlipID() {
		return slipID;
	}
	public void setSlipID(long slipID) {
		this.slipID = slipID;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Transaction getTransaction() {
		return transaction;
	}
	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

}

package com.cpo.bank.model;

import java.util.Date;

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
@Table(name="check_table")
public class Check {
	
	//CheckInfo
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long checkID;
	@Column
	private long payeeAccountID;
	@Column
	private long beneficiaryAccountID;
	@Column
	private double amount;
	@Column
	private int checkNumber;
	@Column
	private String bankName;
	@Column
	private String ifsc;
	@Column
	private Date issueDate;
	
	//Connect check to Payee Account Number
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="accountID", insertable=false, updatable=false)
	private Account payeeAccount;
	
	//Connect check to Beneficiary Account Number
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="accountID", insertable=false, updatable=false)
	private Account beneficiaryAccount;
	
	//Connect check to Transaction
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="transactionID", insertable=false, updatable=false)
	private Transaction checkTransaction;
	
	///////////////
	/// METHODS ///
	///////////////
	
	public Check() {}

	public long getCheckID() {
		return checkID;
	}
	public void setCheckID(long checkID) {
		this.checkID = checkID;
	}
	public Transaction getCheckTransaction() {
		return checkTransaction;
	}
	public void setCheckTransaction(Transaction checkTransaction) {
		this.checkTransaction = checkTransaction;
	}
	public long getPayeeAccountID() {
		return payeeAccountID;
	}
	public void setPayeeAccountID(long payeeAccountID) {
		this.payeeAccountID = payeeAccountID;
	}
	public long getBeneficiaryAccountID() {
		return beneficiaryAccountID;
	}
	public void setBeneficiaryAccountID(long beneficiaryAccountID) {
		this.beneficiaryAccountID = beneficiaryAccountID;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getCheckNumber() {
		return checkNumber;
	}
	public void setCheckNumber(int checkNumber) {
		this.checkNumber = checkNumber;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getIfsc() {
		return ifsc;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	public Account getPayeeAccount() {
		return payeeAccount;
	}
	public void setPayeeAccount(Account payeeAccount) {
		this.payeeAccount = payeeAccount;
	}
	public Account getBeneficiaryAccount() {
		return beneficiaryAccount;
	}
	public void setBeneficiaryAccount(Account beneficiaryAccount) {
		this.beneficiaryAccount = beneficiaryAccount;
	}
	
}

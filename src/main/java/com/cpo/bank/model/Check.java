package com.cpo.bank.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name="check_table")
public class Check {
	
	@Id
	@Column
	private int id;
	
	@Column(nullable=false, length=12)
	private long payeeAccountID;
	
	@Column(nullable=false, length=12)
	private long beneficiaryAccountID;
	
	@Column(nullable=false)
	@Range(min=10, max=100000)
	private double amount;
	
	@Column(nullable=false, unique=true, length=6)
	private int checkNumber;
	
	@Column(nullable=true)
	private String bankName;
	
	@Column(nullable=false, length=10)
	private String ifsc;
	
	@Column(nullable=false)
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
	
	
	public Check() {
		
	}

	public Check(int id, long payeeAccountID, long beneficiaryAccountID, double amount, int checkNumber, String bankName,
			String ifsc, Date issueDate) {
		super();
		this.id = id;
		this.payeeAccountID = payeeAccountID;
		this.beneficiaryAccountID = beneficiaryAccountID;
		this.amount = amount;
		this.checkNumber = checkNumber;
		this.bankName = bankName;
		this.ifsc = ifsc;
		this.issueDate = issueDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

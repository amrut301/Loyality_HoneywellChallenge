package com.loyality.dao.entities;


import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the transaction_type database table.
 * 
 */
@Entity
@Table(name="transaction_type")
@NamedQuery(name="TransactionType.findAll", query="SELECT t FROM TransactionType t")
public class TransactionType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="transaction_type_id")
	private int transactionTypeId;

	@Column(name="created_by")
	private String createdBy;

	@Column(name="modified_by")
	private String modifiedBy;

	private String status;

	@Column(name="transaction_type_name")
	private String transactionTypeName;

	@Column(name="transaction_type_val")
	private String transactionTypeVal;

	//bi-directional many-to-one association to Transaction
	@OneToMany(mappedBy="transactionType")
	private List<Transaction> transactions;

	public TransactionType() {
	}

	public int getTransactionTypeId() {
		return this.transactionTypeId;
	}

	public void setTransactionTypeId(int transactionTypeId) {
		this.transactionTypeId = transactionTypeId;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTransactionTypeName() {
		return this.transactionTypeName;
	}

	public void setTransactionTypeName(String transactionTypeName) {
		this.transactionTypeName = transactionTypeName;
	}

	public String getTransactionTypeVal() {
		return this.transactionTypeVal;
	}

	public void setTransactionTypeVal(String transactionTypeVal) {
		this.transactionTypeVal = transactionTypeVal;
	}

	public List<Transaction> getTransactions() {
		return this.transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public Transaction addTransaction(Transaction transaction) {
		getTransactions().add(transaction);
		transaction.setTransactionType(this);

		return transaction;
	}

	public Transaction removeTransaction(Transaction transaction) {
		getTransactions().remove(transaction);
		transaction.setTransactionType(null);

		return transaction;
	}

}
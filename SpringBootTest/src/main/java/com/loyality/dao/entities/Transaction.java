package com.loyality.dao.entities;


import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;


/**
 * The persistent class for the transaction database table.
 * 
 */
@Entity
@NamedQuery(name="Transaction.findAll", query="SELECT t FROM Transaction t")
public class Transaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="transaction_id")
	private int transactionId;

	@Column(name="created_by")
	private String createdBy;

	private String isRedeeming;

	@Column(name="points_left")
	private BigInteger pointsLeft;

	@Column(name="transaction_name")
	private String transactionName;

	//bi-directional many-to-one association to PersonTransaction
	@OneToMany(mappedBy="transaction")
	private List<PersonTransaction> personTransactions;

	//bi-directional many-to-one association to TransactionType
	@ManyToOne
	@JoinColumn(name="transaction_type_id")
	private TransactionType transactionType;

	public Transaction() {
	}

	public int getTransactionId() {
		return this.transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getIsRedeeming() {
		return this.isRedeeming;
	}

	public void setIsRedeeming(String isRedeeming) {
		this.isRedeeming = isRedeeming;
	}

	public BigInteger getPointsLeft() {
		return this.pointsLeft;
	}

	public void setPointsLeft(BigInteger pointsLeft) {
		this.pointsLeft = pointsLeft;
	}

	public String getTransactionName() {
		return this.transactionName;
	}

	public void setTransactionName(String transactionName) {
		this.transactionName = transactionName;
	}

	public List<PersonTransaction> getPersonTransactions() {
		return this.personTransactions;
	}

	public void setPersonTransactions(List<PersonTransaction> personTransactions) {
		this.personTransactions = personTransactions;
	}

	public PersonTransaction addPersonTransaction(PersonTransaction personTransaction) {
		getPersonTransactions().add(personTransaction);
		personTransaction.setTransaction(this);

		return personTransaction;
	}

	public PersonTransaction removePersonTransaction(PersonTransaction personTransaction) {
		getPersonTransactions().remove(personTransaction);
		personTransaction.setTransaction(null);

		return personTransaction;
	}

	public TransactionType getTransactionType() {
		return this.transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

}
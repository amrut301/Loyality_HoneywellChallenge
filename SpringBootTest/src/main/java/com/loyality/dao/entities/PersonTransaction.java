package com.loyality.dao.entities;


import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the person_transaction database table.
 * 
 */
@Entity
@Table(name="person_transaction")
@NamedQuery(name="PersonTransaction.findAll", query="SELECT p FROM PersonTransaction p")
public class PersonTransaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="person_transaction_id")
	private int personTransactionId;

	//bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name="person_id")
	private Person person;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;

	//bi-directional many-to-one association to Transaction
	@ManyToOne
	@JoinColumn(name="transaction_id")
	private Transaction transaction;

	public PersonTransaction() {
	}

	public int getPersonTransactionId() {
		return this.personTransactionId;
	}

	public void setPersonTransactionId(int personTransactionId) {
		this.personTransactionId = personTransactionId;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Transaction getTransaction() {
		return this.transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

}
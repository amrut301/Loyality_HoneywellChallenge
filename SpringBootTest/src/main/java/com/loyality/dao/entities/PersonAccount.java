package com.loyality.dao.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the person_account database table.
 * 
 */
@Entity
@Table(name="person_account")
@NamedQuery(name="PersonAccount.findAll", query="SELECT p FROM PersonAccount p")
public class PersonAccount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PERSON_ACCOUNT_MAPPING")
	private int personAccountMapping;

	@Column(name="CREATED_BY")
	private String createdBy;

	@Column(name="MODIFIED_BY")
	private String modifiedBy;

	private String status;

	//bi-directional many-to-one association to Account
	@ManyToOne
	@JoinColumn(name="ACCOUNT_ID")
	private Account account;

	//bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name="PERSON_ID")
	private Person person;

	public PersonAccount() {
	}

	public int getPersonAccountMapping() {
		return this.personAccountMapping;
	}

	public void setPersonAccountMapping(int personAccountMapping) {
		this.personAccountMapping = personAccountMapping;
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

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
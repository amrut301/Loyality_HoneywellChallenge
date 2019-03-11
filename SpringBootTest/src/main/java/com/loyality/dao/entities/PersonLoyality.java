package com.loyality.dao.entities;


import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the person_loyality database table.
 * 
 */
@Entity
@Table(name="person_loyality")
@NamedQuery(name="PersonLoyality.findAll", query="SELECT p FROM PersonLoyality p")
public class PersonLoyality implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="person_loyality_id")
	private int personLoyalityId;

	@Column(name="created_by")
	private String createdBy;

	@Column(name="modified_by")
	private String modifiedBy;

	private String status;

	//bi-directional many-to-one association to Loyality
	@ManyToOne
	@JoinColumn(name="loyality_id")
	private Loyality loyality;

	//bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name="person_id")
	private Person person;

	public PersonLoyality() {
	}

	public int getPersonLoyalityId() {
		return this.personLoyalityId;
	}

	public void setPersonLoyalityId(int personLoyalityId) {
		this.personLoyalityId = personLoyalityId;
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

	public Loyality getLoyality() {
		return this.loyality;
	}

	public void setLoyality(Loyality loyality) {
		this.loyality = loyality;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
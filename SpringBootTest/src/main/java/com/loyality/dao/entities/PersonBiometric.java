package com.loyality.dao.entities;


import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the person_biometric database table.
 * 
 */
@Entity
@Table(name="person_biometric")
@NamedQuery(name="PersonBiometric.findAll", query="SELECT p FROM PersonBiometric p")
public class PersonBiometric implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PEROSN_BIOMETRIC_ID")
	private int perosnBiometricId;

	@Column(name="CREATED_BY")
	private String createdBy;

	@Column(name="MODIFIED_BY")
	private String modifiedBy;

	private String status;

	//bi-directional many-to-one association to Biometric
	@ManyToOne
	@JoinColumn(name="BIOMETRIC_ID")
	private Biometric biometric;

	//bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name="PERSON_ID")
	private Person person;

	public PersonBiometric() {
	}

	public int getPerosnBiometricId() {
		return this.perosnBiometricId;
	}

	public void setPerosnBiometricId(int perosnBiometricId) {
		this.perosnBiometricId = perosnBiometricId;
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

	public Biometric getBiometric() {
		return this.biometric;
	}

	public void setBiometric(Biometric biometric) {
		this.biometric = biometric;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
package com.loyality.dao.entities;


import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the biometric database table.
 * 
 */
@Entity
@NamedQuery(name="Biometric.findAll", query="SELECT b FROM Biometric b")
public class Biometric implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="BIOMETRIC_ID")
	private int biometricId;

	@Column(name="BIOMETRIC_FILENAME")
	private String biometricFilename;

	@Column(name="CREATED_BY")
	private String createdBy;

	@Column(name="MODIFIED_BY")
	private String modifiedBy;

	private String status;

	@Lob
	private byte[] template;

	//bi-directional many-to-one association to BiometricType
	@ManyToOne
	@JoinColumn(name="BIOMETRIC_TYPE_ID")
	private BiometricType biometricType;

	//bi-directional many-to-one association to PersonBiometric
	@OneToMany(mappedBy="biometric")
	private List<PersonBiometric> personBiometrics;

	public Biometric() {
	}

	public int getBiometricId() {
		return this.biometricId;
	}

	public void setBiometricId(int biometricId) {
		this.biometricId = biometricId;
	}

	public String getBiometricFilename() {
		return this.biometricFilename;
	}

	public void setBiometricFilename(String biometricFilename) {
		this.biometricFilename = biometricFilename;
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

	public byte[] getTemplate() {
		return this.template;
	}

	public void setTemplate(byte[] template) {
		this.template = template;
	}

	public BiometricType getBiometricType() {
		return this.biometricType;
	}

	public void setBiometricType(BiometricType biometricType) {
		this.biometricType = biometricType;
	}

	public List<PersonBiometric> getPersonBiometrics() {
		return this.personBiometrics;
	}

	public void setPersonBiometrics(List<PersonBiometric> personBiometrics) {
		this.personBiometrics = personBiometrics;
	}

	public PersonBiometric addPersonBiometric(PersonBiometric personBiometric) {
		getPersonBiometrics().add(personBiometric);
		personBiometric.setBiometric(this);

		return personBiometric;
	}

	public PersonBiometric removePersonBiometric(PersonBiometric personBiometric) {
		getPersonBiometrics().remove(personBiometric);
		personBiometric.setBiometric(null);

		return personBiometric;
	}

}
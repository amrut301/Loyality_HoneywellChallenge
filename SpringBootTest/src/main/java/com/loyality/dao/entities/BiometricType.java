package com.loyality.dao.entities;


import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the biometric_type database table.
 * 
 */
@Entity
@Table(name="biometric_type")
@NamedQuery(name="BiometricType.findAll", query="SELECT b FROM BiometricType b")
public class BiometricType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="BIOMERTIC_TYPE_ID")
	private int biomerticTypeId;

	@Column(name="BIOMETRIC_TYPE_DESC")
	private String biometricTypeDesc;

	@Column(name="BIOMETRIC_TYPE_VAL")
	private String biometricTypeVal;

	@Column(name="CREATED_BY")
	private String createdBy;

	@Column(name="MODIFIED_BY")
	private String modifiedBy;

	//bi-directional many-to-one association to Biometric
	@OneToMany(mappedBy="biometricType")
	private List<Biometric> biometrics;

	public BiometricType() {
	}

	public int getBiomerticTypeId() {
		return this.biomerticTypeId;
	}

	public void setBiomerticTypeId(int biomerticTypeId) {
		this.biomerticTypeId = biomerticTypeId;
	}

	public String getBiometricTypeDesc() {
		return this.biometricTypeDesc;
	}

	public void setBiometricTypeDesc(String biometricTypeDesc) {
		this.biometricTypeDesc = biometricTypeDesc;
	}

	public String getBiometricTypeVal() {
		return this.biometricTypeVal;
	}

	public void setBiometricTypeVal(String biometricTypeVal) {
		this.biometricTypeVal = biometricTypeVal;
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

	public List<Biometric> getBiometrics() {
		return this.biometrics;
	}

	public void setBiometrics(List<Biometric> biometrics) {
		this.biometrics = biometrics;
	}

	public Biometric addBiometric(Biometric biometric) {
		getBiometrics().add(biometric);
		biometric.setBiometricType(this);

		return biometric;
	}

	public Biometric removeBiometric(Biometric biometric) {
		getBiometrics().remove(biometric);
		biometric.setBiometricType(null);

		return biometric;
	}

}
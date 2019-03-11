package com.loyality.bo;

import com.loyality.bo.constants.BiometricType;

public class BiometricBo extends BaseBo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer biometricId;

	private Integer personId;

	private String firstName;

	private String lastName;

	private String biometricLabel;

	private BiometricType biometricType;

	private String fileName;

	private byte[] fileContent;

	private String status;

	public Integer getBiometricId() {
		return biometricId;
	}

	public void setBiometricId(Integer biometricId) {
		this.biometricId = biometricId;
	}

	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBiometricLabel() {
		return biometricLabel;
	}

	public void setBiometricLabel(String biometricLabel) {
		this.biometricLabel = biometricLabel;
	}

	public BiometricType getBiometricType() {
		return biometricType;
	}

	public void setBiometricType(BiometricType biometricType) {
		this.biometricType = biometricType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getFileContent() {
		return fileContent;
	}

	public void setFileContent(byte[] fileContent) {
		this.fileContent = fileContent;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}

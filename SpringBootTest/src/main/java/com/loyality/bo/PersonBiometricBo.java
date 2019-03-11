package com.loyality.bo;

import java.util.List;

/**
 * @author amrut.malaji
 *
 *
 * This class could be name as ReviewBiometric
 */
public class PersonBiometricBo extends BaseBo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<BiometricBo> biometric;

	private PersonBo person;

	private String status;

	public List<BiometricBo> getBiometric() {
		return biometric;
	}

	public void setBiometric(List<BiometricBo> biometric) {
		this.biometric = biometric;
	}

	public PersonBo getPerson() {
		return person;
	}

	public void setPerson(PersonBo person) {
		this.person = person;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}

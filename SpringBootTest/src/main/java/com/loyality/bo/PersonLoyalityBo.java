package com.loyality.bo;

import java.util.List;

public class PersonLoyalityBo extends BaseBo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<PersonBo> persons;
	
	private LoyalityBo loyality;

	public List<PersonBo> getPersons() {
		return persons;
	}

	public void setPersons(List<PersonBo> persons) {
		this.persons = persons;
	}

	public LoyalityBo getLoyality() {
		return loyality;
	}

	public void setLoyality(LoyalityBo loyality) {
		this.loyality = loyality;
	}
	
	

}

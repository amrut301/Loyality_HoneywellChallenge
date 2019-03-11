package com.loyality.bo;

import com.loyality.bo.constants.LoyalityType;

public class LoyalityBo extends BaseBo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer loyalityId;

	private LoyalityType loyalityType;

	private String loyalityName;

	public Integer getLoyalityId() {
		return loyalityId;
	}

	public void setLoyalityId(Integer loyalityId) {
		this.loyalityId = loyalityId;
	}

	public LoyalityType getLoyalityType() {
		return loyalityType;
	}

	public void setLoyalityType(LoyalityType loyalityType) {
		this.loyalityType = loyalityType;
	}

	public String getLoyalityName() {
		return loyalityName;
	}

	public void setLoyalityName(String loyalityName) {
		this.loyalityName = loyalityName;
	}

}

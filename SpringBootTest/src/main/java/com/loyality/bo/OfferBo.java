package com.loyality.bo;

import com.loyality.bo.constants.DiscountType;

public class OfferBo extends BaseBo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer offerId;
	
	private DiscountType discountType;
	
	private String offerName;

	public Integer getOfferId() {
		return offerId;
	}

	public void setOfferId(Integer offerId) {
		this.offerId = offerId;
	}

	public DiscountType getDiscountType() {
		return discountType;
	}

	public void setDiscountType(DiscountType discountType) {
		this.discountType = discountType;
	}

	public String getOfferName() {
		return offerName;
	}

	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}
	

}

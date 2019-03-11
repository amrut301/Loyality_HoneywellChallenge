package com.loyality.bo.constants;

/**
 * @author amrut.malaji
 *
 */
public enum ProductType {
	OFFER_PRODUCT {
		int discountRate;
		public void setDiscountPrice(int rate) {
			this.discountRate = rate;
		}

		public int getDiscountPrice(int rate) {
			return discountRate;
		}
	},
	NEW_ARRIVAL;
	
	private int discountPrice;

	public int getDiscountPrice(int rate) {
		return discountPrice;
	}

	public void setDiscountPrice(int rate) {
		this.discountPrice = rate;
	}

	private ProductType() {
		discountPrice=5; // default
	}
}

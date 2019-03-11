package com.loyality.bo;

import java.util.List;

/**
 * @author amrut.malaji
 *
 *         Assuming multiple products can have one offer.
 *
 */
public class ProductOfferBo extends BaseBo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<ProductBo> products;

	private OfferBo offer;

	public List<ProductBo> getProducts() {
		return products;
	}

	public void setProducts(List<ProductBo> products) {
		this.products = products;
	}

	public OfferBo getOffer() {
		return offer;
	}

	public void setOffer(OfferBo offer) {
		this.offer = offer;
	}


}

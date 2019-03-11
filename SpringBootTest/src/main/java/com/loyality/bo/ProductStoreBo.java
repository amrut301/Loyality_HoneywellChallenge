package com.loyality.bo;

import java.util.List;
import java.util.Set;

public class ProductStoreBo extends BaseBo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ProductBo product;

	private Set<StoreBo> stores;

	public ProductBo getProduct() {
		return product;
	}

	public void setProduct(ProductBo product) {
		this.product = product;
	}

	public Set<StoreBo> getStores() {
		return stores;
	}

	public void setStores(Set<StoreBo> stores) {
		this.stores = stores;
	}

}

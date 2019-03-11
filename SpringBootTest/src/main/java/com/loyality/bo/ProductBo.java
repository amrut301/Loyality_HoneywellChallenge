package com.loyality.bo;

import com.loyality.bo.constants.ProductType;

public class ProductBo extends BaseBo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer productId;
	
	private Double productPrice;
	
	private String qrCode;
	
	private ProductType productType;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
	

}

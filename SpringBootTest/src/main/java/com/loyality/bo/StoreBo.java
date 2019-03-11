package com.loyality.bo;

import com.loyality.bo.constants.StoreType;

public class StoreBo extends BaseBo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer storeId;
	
	private String storeName;
	
	private StoreType storeType;
	
	private String address;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public StoreType getStoreType() {
		return storeType;
	}

	public void setStoreType(StoreType storeType) {
		this.storeType = storeType;
	}
	
}

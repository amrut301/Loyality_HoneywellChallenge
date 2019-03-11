package com.loyality.bo;

import java.util.Set;

/**
 * @author amrut.malaji
 *
 */
public class StoreLocationBo extends BaseBo {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Set<StoreBo> stores;
	
	private LocationBo locationBo;

	public Set<StoreBo> getStores() {
		return stores;
	}

	public void setStores(Set<StoreBo> stores) {
		this.stores = stores;
	}

	public LocationBo getLocationBo() {
		return locationBo;
	}

	public void setLocationBo(LocationBo locationBo) {
		this.locationBo = locationBo;
	}
}

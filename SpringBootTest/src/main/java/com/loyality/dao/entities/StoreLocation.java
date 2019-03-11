package com.loyality.dao.entities;


import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the store_location database table.
 * 
 */
@Entity
@Table(name="store_location")
@NamedQuery(name="StoreLocation.findAll", query="SELECT s FROM StoreLocation s")
public class StoreLocation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="store_location_id")
	private int storeLocationId;

	@Column(name="created_by")
	private String createdBy;

	@Column(name="modified_by")
	private String modifiedBy;

	private String status;

	//bi-directional many-to-one association to Location
	@ManyToOne
	@JoinColumn(name="location_id")
	private Location location;

	//bi-directional many-to-one association to Store
	@ManyToOne
	@JoinColumn(name="store_id")
	private Store store;

	public StoreLocation() {
	}

	public int getStoreLocationId() {
		return this.storeLocationId;
	}

	public void setStoreLocationId(int storeLocationId) {
		this.storeLocationId = storeLocationId;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Store getStore() {
		return this.store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

}
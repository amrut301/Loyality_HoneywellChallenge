package com.loyality.dao.entities;


import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the stores database table.
 * 
 */
@Entity
@Table(name="stores")
@NamedQuery(name="Store.findAll", query="SELECT s FROM Store s")
public class Store implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="store_id")
	private int storeId;

	@Column(name="create_by")
	private String createBy;

	@Column(name="modifiel_by")
	private String modifielBy;

	private String status;

	@Column(name="store_name")
	private String storeName;

	@Column(name="store_type_id")
	private int storeTypeId;

	//bi-directional many-to-one association to StoreLocation
	@OneToMany(mappedBy="store")
	private List<StoreLocation> storeLocations;

	//bi-directional many-to-one association to StoreOffer
	@OneToMany(mappedBy="store")
	private List<StoreOffer> storeOffers;

	public Store() {
	}

	public int getStoreId() {
		return this.storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getModifielBy() {
		return this.modifielBy;
	}

	public void setModifielBy(String modifielBy) {
		this.modifielBy = modifielBy;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStoreName() {
		return this.storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public int getStoreTypeId() {
		return this.storeTypeId;
	}

	public void setStoreTypeId(int storeTypeId) {
		this.storeTypeId = storeTypeId;
	}

	public List<StoreLocation> getStoreLocations() {
		return this.storeLocations;
	}

	public void setStoreLocations(List<StoreLocation> storeLocations) {
		this.storeLocations = storeLocations;
	}

	public StoreLocation addStoreLocation(StoreLocation storeLocation) {
		getStoreLocations().add(storeLocation);
		storeLocation.setStore(this);

		return storeLocation;
	}

	public StoreLocation removeStoreLocation(StoreLocation storeLocation) {
		getStoreLocations().remove(storeLocation);
		storeLocation.setStore(null);

		return storeLocation;
	}

	public List<StoreOffer> getStoreOffers() {
		return this.storeOffers;
	}

	public void setStoreOffers(List<StoreOffer> storeOffers) {
		this.storeOffers = storeOffers;
	}

	public StoreOffer addStoreOffer(StoreOffer storeOffer) {
		getStoreOffers().add(storeOffer);
		storeOffer.setStore(this);

		return storeOffer;
	}

	public StoreOffer removeStoreOffer(StoreOffer storeOffer) {
		getStoreOffers().remove(storeOffer);
		storeOffer.setStore(null);

		return storeOffer;
	}

}
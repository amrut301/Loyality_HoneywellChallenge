package com.loyality.dao.entities;


import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the store_offers database table.
 * 
 */
@Entity
@Table(name="store_offers")
@NamedQuery(name="StoreOffer.findAll", query="SELECT s FROM StoreOffer s")
public class StoreOffer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="store_offer_id")
	private int storeOfferId;

	@Column(name="create_by")
	private String createBy;

	@Column(name="modified_by")
	private String modifiedBy;

	private String status;

	//bi-directional many-to-one association to Offer
	@ManyToOne
	@JoinColumn(name="offer_id")
	private Offer offer;

	//bi-directional many-to-one association to Store
	@ManyToOne
	@JoinColumn(name="store_id")
	private Store store;

	public StoreOffer() {
	}

	public int getStoreOfferId() {
		return this.storeOfferId;
	}

	public void setStoreOfferId(int storeOfferId) {
		this.storeOfferId = storeOfferId;
	}

	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
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

	public Offer getOffer() {
		return this.offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	public Store getStore() {
		return this.store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

}
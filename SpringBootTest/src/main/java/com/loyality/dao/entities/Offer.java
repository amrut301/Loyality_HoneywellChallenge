package com.loyality.dao.entities;


import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the offers database table.
 * 
 */
@Entity
@Table(name="offers")
@NamedQuery(name="Offer.findAll", query="SELECT o FROM Offer o")
public class Offer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int offer_id;

	@Column(name="created_by")
	private String createdBy;

	@Column(name="modified_by")
	private String modifiedBy;

	@Column(name="offer_desc")
	private String offerDesc;

	@Column(name="offer_name")
	private String offerName;

	private String status;

	//bi-directional many-to-one association to DiscountType
	@ManyToOne
	@JoinColumn(name="discount_type")
	private DiscountType discountTypeBean;

	//bi-directional many-to-one association to StoreOffer
	@OneToMany(mappedBy="offer")
	private List<StoreOffer> storeOffers;

	public Offer() {
	}

	public int getOffer_id() {
		return this.offer_id;
	}

	public void setOffer_id(int offer_id) {
		this.offer_id = offer_id;
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

	public String getOfferDesc() {
		return this.offerDesc;
	}

	public void setOfferDesc(String offerDesc) {
		this.offerDesc = offerDesc;
	}

	public String getOfferName() {
		return this.offerName;
	}

	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public DiscountType getDiscountTypeBean() {
		return this.discountTypeBean;
	}

	public void setDiscountTypeBean(DiscountType discountTypeBean) {
		this.discountTypeBean = discountTypeBean;
	}

	public List<StoreOffer> getStoreOffers() {
		return this.storeOffers;
	}

	public void setStoreOffers(List<StoreOffer> storeOffers) {
		this.storeOffers = storeOffers;
	}

	public StoreOffer addStoreOffer(StoreOffer storeOffer) {
		getStoreOffers().add(storeOffer);
		storeOffer.setOffer(this);

		return storeOffer;
	}

	public StoreOffer removeStoreOffer(StoreOffer storeOffer) {
		getStoreOffers().remove(storeOffer);
		storeOffer.setOffer(null);

		return storeOffer;
	}

}
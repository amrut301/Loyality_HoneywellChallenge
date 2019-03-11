package com.loyality.dao.entities;


import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the discount_type database table.
 * 
 */
@Entity
@Table(name="discount_type")
@NamedQuery(name="DiscountType.findAll", query="SELECT d FROM DiscountType d")
public class DiscountType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="discount_type_id")
	private int discountTypeId;

	@Column(name="bonus_points")
	private int bonusPoints;

	@Column(name="created_by")
	private String createdBy;

	@Column(name="discount_type_desc")
	private String discountTypeDesc;

	@Column(name="discount_type_name")
	private String discountTypeName;

	@Column(name="modified_by")
	private String modifiedBy;

	private String status;

	//bi-directional many-to-one association to Offer
	@OneToMany(mappedBy="discountTypeBean")
	private List<Offer> offers;

	public DiscountType() {
	}

	public int getDiscountTypeId() {
		return this.discountTypeId;
	}

	public void setDiscountTypeId(int discountTypeId) {
		this.discountTypeId = discountTypeId;
	}

	public int getBonusPoints() {
		return this.bonusPoints;
	}

	public void setBonusPoints(int bonusPoints) {
		this.bonusPoints = bonusPoints;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getDiscountTypeDesc() {
		return this.discountTypeDesc;
	}

	public void setDiscountTypeDesc(String discountTypeDesc) {
		this.discountTypeDesc = discountTypeDesc;
	}

	public String getDiscountTypeName() {
		return this.discountTypeName;
	}

	public void setDiscountTypeName(String discountTypeName) {
		this.discountTypeName = discountTypeName;
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

	public List<Offer> getOffers() {
		return this.offers;
	}

	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}

	public Offer addOffer(Offer offer) {
		getOffers().add(offer);
		offer.setDiscountTypeBean(this);

		return offer;
	}

	public Offer removeOffer(Offer offer) {
		getOffers().remove(offer);
		offer.setDiscountTypeBean(null);

		return offer;
	}

}
package com.loyality.dao.entities;


import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the loyality_type database table.
 * 
 */
@Entity
@Table(name="loyality_type")
@NamedQuery(name="LoyalityType.findAll", query="SELECT l FROM LoyalityType l")
public class LoyalityType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="loyality_type_id")
	private int loyalityTypeId;

	@Column(name="create_by")
	private String createBy;

	@Column(name="loyality_type_desc")
	private String loyalityTypeDesc;

	@Column(name="loyality_type_value")
	private String loyalityTypeValue;

	@Column(name="modified_by")
	private String modifiedBy;

	private String status;

	public LoyalityType() {
	}

	public int getLoyalityTypeId() {
		return this.loyalityTypeId;
	}

	public void setLoyalityTypeId(int loyalityTypeId) {
		this.loyalityTypeId = loyalityTypeId;
	}

	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getLoyalityTypeDesc() {
		return this.loyalityTypeDesc;
	}

	public void setLoyalityTypeDesc(String loyalityTypeDesc) {
		this.loyalityTypeDesc = loyalityTypeDesc;
	}

	public String getLoyalityTypeValue() {
		return this.loyalityTypeValue;
	}

	public void setLoyalityTypeValue(String loyalityTypeValue) {
		this.loyalityTypeValue = loyalityTypeValue;
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

}
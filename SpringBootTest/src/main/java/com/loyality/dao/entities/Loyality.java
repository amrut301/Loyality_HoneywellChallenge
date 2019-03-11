package com.loyality.dao.entities;


import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the loyality database table.
 * 
 */
@Entity
@NamedQuery(name="Loyality.findAll", query="SELECT l FROM Loyality l")
public class Loyality implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="loyality_id")
	private int loyalityId;

	@Column(name="created_by")
	private String createdBy;

	@Column(name="loyality_name")
	private String loyalityName;

	@Column(name="modified_by")
	private String modifiedBy;

	private String status;

	//bi-directional many-to-one association to Loyality
	@ManyToOne
	@JoinColumn(name="loyality_type_id")
	private Loyality loyality;

	//bi-directional many-to-one association to Loyality
	@OneToMany(mappedBy="loyality")
	private List<Loyality> loyalities;

	//bi-directional many-to-one association to PersonLoyality
	@OneToMany(mappedBy="loyality")
	private List<PersonLoyality> personLoyalities;

	public Loyality() {
	}

	public int getLoyalityId() {
		return this.loyalityId;
	}

	public void setLoyalityId(int loyalityId) {
		this.loyalityId = loyalityId;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getLoyalityName() {
		return this.loyalityName;
	}

	public void setLoyalityName(String loyalityName) {
		this.loyalityName = loyalityName;
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

	public Loyality getLoyality() {
		return this.loyality;
	}

	public void setLoyality(Loyality loyality) {
		this.loyality = loyality;
	}

	public List<Loyality> getLoyalities() {
		return this.loyalities;
	}

	public void setLoyalities(List<Loyality> loyalities) {
		this.loyalities = loyalities;
	}

	public Loyality addLoyality(Loyality loyality) {
		getLoyalities().add(loyality);
		loyality.setLoyality(this);

		return loyality;
	}

	public Loyality removeLoyality(Loyality loyality) {
		getLoyalities().remove(loyality);
		loyality.setLoyality(null);

		return loyality;
	}

	public List<PersonLoyality> getPersonLoyalities() {
		return this.personLoyalities;
	}

	public void setPersonLoyalities(List<PersonLoyality> personLoyalities) {
		this.personLoyalities = personLoyalities;
	}

	public PersonLoyality addPersonLoyality(PersonLoyality personLoyality) {
		getPersonLoyalities().add(personLoyality);
		personLoyality.setLoyality(this);

		return personLoyality;
	}

	public PersonLoyality removePersonLoyality(PersonLoyality personLoyality) {
		getPersonLoyalities().remove(personLoyality);
		personLoyality.setLoyality(null);

		return personLoyality;
	}

}
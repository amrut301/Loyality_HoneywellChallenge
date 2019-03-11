package com.loyality.dao.entities;


import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the location database table.
 * 
 */
@Entity
@NamedQuery(name="Location.findAll", query="SELECT l FROM Location l")
public class Location implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="LOCATION_ID")
	private int locationId;

	@Column(name="CREATED_BY")
	private String createdBy;

	private double latitude;

	@Column(name="LOCATION_DESC")
	private String locationDesc;

	@Column(name="LOCATION_NAME")
	private String locationName;

	private double longitude;

	@Column(name="MODIFIED_BY")
	private String modifiedBy;

	private String status;

	//bi-directional many-to-one association to StoreLocation
	@OneToMany(mappedBy="location")
	private List<StoreLocation> storeLocations;

	public Location() {
	}

	public int getLocationId() {
		return this.locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public String getLocationDesc() {
		return this.locationDesc;
	}

	public void setLocationDesc(String locationDesc) {
		this.locationDesc = locationDesc;
	}

	public String getLocationName() {
		return this.locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
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

	public List<StoreLocation> getStoreLocations() {
		return this.storeLocations;
	}

	public void setStoreLocations(List<StoreLocation> storeLocations) {
		this.storeLocations = storeLocations;
	}

	public StoreLocation addStoreLocation(StoreLocation storeLocation) {
		getStoreLocations().add(storeLocation);
		storeLocation.setLocation(this);

		return storeLocation;
	}

	public StoreLocation removeStoreLocation(StoreLocation storeLocation) {
		getStoreLocations().remove(storeLocation);
		storeLocation.setLocation(null);

		return storeLocation;
	}

}
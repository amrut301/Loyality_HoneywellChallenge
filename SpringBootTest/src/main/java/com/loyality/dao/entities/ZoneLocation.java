package com.loyality.dao.entities;


import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the zone_location database table.
 * 
 */
@Entity
@Table(name="zone_location")
@NamedQuery(name="ZoneLocation.findAll", query="SELECT z FROM ZoneLocation z")
public class ZoneLocation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ZONE_LOCATION_ID")
	private int zoneLocationId;

	@Column(name="CREATED_BY")
	private String createdBy;

	@Column(name="LOCATION_ID")
	private int locationId;

	@Column(name="MODIFIED_BY")
	private String modifiedBy;

	@Column(name="ZONE_ID")
	private int zoneId;

	public ZoneLocation() {
	}

	public int getZoneLocationId() {
		return this.zoneLocationId;
	}

	public void setZoneLocationId(int zoneLocationId) {
		this.zoneLocationId = zoneLocationId;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public int getLocationId() {
		return this.locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public int getZoneId() {
		return this.zoneId;
	}

	public void setZoneId(int zoneId) {
		this.zoneId = zoneId;
	}

}
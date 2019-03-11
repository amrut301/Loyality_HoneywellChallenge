package com.loyality.dao.entities;


import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the zone database table.
 * 
 */
@Entity
@NamedQuery(name="Zone.findAll", query="SELECT z FROM Zone z")
public class Zone implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ZONE_ID")
	private int zoneId;

	@Column(name="CREATED_BY")
	private String createdBy;

	@Column(name="MODIFIED_BY")
	private String modifiedBy;

	private String status;

	@Column(name="ZONE_DESC")
	private String zoneDesc;

	@Column(name="ZONE_NAME")
	private String zoneName;

	public Zone() {
	}

	public int getZoneId() {
		return this.zoneId;
	}

	public void setZoneId(int zoneId) {
		this.zoneId = zoneId;
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

	public String getZoneDesc() {
		return this.zoneDesc;
	}

	public void setZoneDesc(String zoneDesc) {
		this.zoneDesc = zoneDesc;
	}

	public String getZoneName() {
		return this.zoneName;
	}

	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}

}
package com.loyality.bo;

public class ZoneBo extends BaseBo {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer zoneId;

	private String zoneName;

	private String zoneDescription;

	public Integer getZoneId() {
		return zoneId;
	}

	public void setZoneId(Integer zoneId) {
		this.zoneId = zoneId;
	}

	public String getZoneName() {
		return zoneName;
	}

	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}

	public String getZoneDescription() {
		return zoneDescription;
	}

	public void setZoneDescription(String zoneDescription) {
		this.zoneDescription = zoneDescription;
	}

}

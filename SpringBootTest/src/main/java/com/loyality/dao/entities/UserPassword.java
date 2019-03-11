package com.loyality.dao.entities;


import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the user_password database table.
 * 
 */
@Entity
@Table(name="user_password")
@NamedQuery(name="UserPassword.findAll", query="SELECT u FROM UserPassword u")
public class UserPassword implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="USER_ID")
	private String userId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_LOGIN_DATE")
	private Date lastLoginDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="MODIFIED_DATE")
	private Date modifiedDate;

	private String password;

	@Column(name="PREVIOUS_PASSWORD")
	private String previousPassword;

	@Column(name="RETRY_COUNT")
	private int retryCount;

	public UserPassword() {
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getLastLoginDate() {
		return this.lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public Date getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPreviousPassword() {
		return this.previousPassword;
	}

	public void setPreviousPassword(String previousPassword) {
		this.previousPassword = previousPassword;
	}

	public int getRetryCount() {
		return this.retryCount;
	}

	public void setRetryCount(int retryCount) {
		this.retryCount = retryCount;
	}

}
package com.loyality.bo;

import java.util.Date;
import java.util.List;

public class AccountBo extends BaseBo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int accountId;

	private String accountUserName;

	private String accountPassword;

	private String accountNumber;

	private Date accountExpiry;

	private List<PersonBo> persons;

	public AccountBo() {

	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountUserName() {
		return accountUserName;
	}

	public void setAccountUserName(String accountUserName) {
		this.accountUserName = accountUserName;
	}

	public String getAccountPassword() {
		return accountPassword;
	}

	public void setAccountPassword(String accountPassword) {
		this.accountPassword = accountPassword;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Date getAccountExpiry() {
		return accountExpiry;
	}

	public void setAccountExpiry(Date accountExpiry) {
		this.accountExpiry = accountExpiry;
	}

	public List<PersonBo> getPersons() {
		return persons;
	}

	public void setPersons(List<PersonBo> persons) {
		this.persons = persons;
	}

}

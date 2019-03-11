package com.loyality.bo;

import java.util.List;

public class PersonAccountBo extends BaseBo {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	private AccountBo accounts;

	public AccountBo getAccounts() {
		return accounts;
	}

	public void setAccounts(AccountBo accounts) {
		this.accounts = accounts;
	}

	public List<PersonBo> getPersons() {
		return persons;
	}

	public void setPersons(List<PersonBo> persons) {
		this.persons = persons;
	}

	private List<PersonBo> persons;

}

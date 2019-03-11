package com.loyality.dao.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the account database table.
 * 
 */
@Entity
@NamedQuery(name="Account.findAll", query="SELECT a FROM Account a")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ACCOUNT_ID")
	private int accountId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ACCOUNT_EXPIRY")
	private Date accountExpiry;

	@Column(name="ACCOUNT_NUMBER")
	private String accountNumber;

	@Column(name="ACCOUNT_PASSWORD")
	private String accountPassword;

	@Column(name="ACCOUNT_USER_NAME")
	private String accountUserName;

	@Column(name="CREATED_BY")
	private String createdBy;

	@Column(name="MODIFIED_BY")
	private String modifiedBy;

	//bi-directional many-to-one association to AccountShoppingCart
	@OneToMany(mappedBy="account")
	private List<AccountShoppingCart> accountShoppingCarts;

	//bi-directional many-to-one association to PersonAccount
	@OneToMany(mappedBy="account")
	private List<PersonAccount> personAccounts;

	public Account() {
	}

	public int getAccountId() {
		return this.accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public Date getAccountExpiry() {
		return this.accountExpiry;
	}

	public void setAccountExpiry(Date accountExpiry) {
		this.accountExpiry = accountExpiry;
	}

	public String getAccountNumber() {
		return this.accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountPassword() {
		return this.accountPassword;
	}

	public void setAccountPassword(String accountPassword) {
		this.accountPassword = accountPassword;
	}

	public String getAccountUserName() {
		return this.accountUserName;
	}

	public void setAccountUserName(String accountUserName) {
		this.accountUserName = accountUserName;
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

	public List<AccountShoppingCart> getAccountShoppingCarts() {
		return this.accountShoppingCarts;
	}

	public void setAccountShoppingCarts(List<AccountShoppingCart> accountShoppingCarts) {
		this.accountShoppingCarts = accountShoppingCarts;
	}

	public AccountShoppingCart addAccountShoppingCart(AccountShoppingCart accountShoppingCart) {
		getAccountShoppingCarts().add(accountShoppingCart);
		accountShoppingCart.setAccount(this);

		return accountShoppingCart;
	}

	public AccountShoppingCart removeAccountShoppingCart(AccountShoppingCart accountShoppingCart) {
		getAccountShoppingCarts().remove(accountShoppingCart);
		accountShoppingCart.setAccount(null);

		return accountShoppingCart;
	}

	public List<PersonAccount> getPersonAccounts() {
		return this.personAccounts;
	}

	public void setPersonAccounts(List<PersonAccount> personAccounts) {
		this.personAccounts = personAccounts;
	}

	public PersonAccount addPersonAccount(PersonAccount personAccount) {
		getPersonAccounts().add(personAccount);
		personAccount.setAccount(this);

		return personAccount;
	}

	public PersonAccount removePersonAccount(PersonAccount personAccount) {
		getPersonAccounts().remove(personAccount);
		personAccount.setAccount(null);

		return personAccount;
	}

}
package com.loyality.dao.entities;


import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the person database table.
 * 
 */
@Entity
@NamedQuery(name="Person.findAll", query="SELECT p FROM Person p")
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PERSON_ID")
	private int personId;

	@Column(name="CREATED_BY")
	private String createdBy;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_OF_BIRTH")
	private Date dateOfBirth;

	private String email;

	private String firstname;

	@Column(name="HAS_SHARED_MEDIA")
	private String hasSharedMedia;

	private String lastname;

	private String middlename;

	@Column(name="MODIFIED_BY")
	private String modifiedBy;

	@Column(name="PERSON_LOYALITY_CARD_NUMBER")
	private String personLoyalityCardNumber;

	private String status;

	//bi-directional many-to-one association to PersonAccount
	@OneToMany(mappedBy="person")
	private List<PersonAccount> personAccounts;

	//bi-directional many-to-one association to PersonBiometric
	@OneToMany(mappedBy="person")
	private List<PersonBiometric> personBiometrics;

	//bi-directional many-to-one association to PersonLoyality
	@OneToMany(mappedBy="person")
	private List<PersonLoyality> personLoyalities;

	//bi-directional many-to-one association to PersonTransaction
	@OneToMany(mappedBy="person")
	private List<PersonTransaction> personTransactions;

	public Person() {
	}

	public int getPersonId() {
		return this.personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getHasSharedMedia() {
		return this.hasSharedMedia;
	}

	public void setHasSharedMedia(String hasSharedMedia) {
		this.hasSharedMedia = hasSharedMedia;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMiddlename() {
		return this.middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getPersonLoyalityCardNumber() {
		return this.personLoyalityCardNumber;
	}

	public void setPersonLoyalityCardNumber(String personLoyalityCardNumber) {
		this.personLoyalityCardNumber = personLoyalityCardNumber;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<PersonAccount> getPersonAccounts() {
		return this.personAccounts;
	}

	public void setPersonAccounts(List<PersonAccount> personAccounts) {
		this.personAccounts = personAccounts;
	}

	public PersonAccount addPersonAccount(PersonAccount personAccount) {
		getPersonAccounts().add(personAccount);
		personAccount.setPerson(this);

		return personAccount;
	}

	public PersonAccount removePersonAccount(PersonAccount personAccount) {
		getPersonAccounts().remove(personAccount);
		personAccount.setPerson(null);

		return personAccount;
	}

	public List<PersonBiometric> getPersonBiometrics() {
		return this.personBiometrics;
	}

	public void setPersonBiometrics(List<PersonBiometric> personBiometrics) {
		this.personBiometrics = personBiometrics;
	}

	public PersonBiometric addPersonBiometric(PersonBiometric personBiometric) {
		getPersonBiometrics().add(personBiometric);
		personBiometric.setPerson(this);

		return personBiometric;
	}

	public PersonBiometric removePersonBiometric(PersonBiometric personBiometric) {
		getPersonBiometrics().remove(personBiometric);
		personBiometric.setPerson(null);

		return personBiometric;
	}

	public List<PersonLoyality> getPersonLoyalities() {
		return this.personLoyalities;
	}

	public void setPersonLoyalities(List<PersonLoyality> personLoyalities) {
		this.personLoyalities = personLoyalities;
	}

	public PersonLoyality addPersonLoyality(PersonLoyality personLoyality) {
		getPersonLoyalities().add(personLoyality);
		personLoyality.setPerson(this);

		return personLoyality;
	}

	public PersonLoyality removePersonLoyality(PersonLoyality personLoyality) {
		getPersonLoyalities().remove(personLoyality);
		personLoyality.setPerson(null);

		return personLoyality;
	}

	public List<PersonTransaction> getPersonTransactions() {
		return this.personTransactions;
	}

	public void setPersonTransactions(List<PersonTransaction> personTransactions) {
		this.personTransactions = personTransactions;
	}

	public PersonTransaction addPersonTransaction(PersonTransaction personTransaction) {
		getPersonTransactions().add(personTransaction);
		personTransaction.setPerson(this);

		return personTransaction;
	}

	public PersonTransaction removePersonTransaction(PersonTransaction personTransaction) {
		getPersonTransactions().remove(personTransaction);
		personTransaction.setPerson(null);

		return personTransaction;
	}

}
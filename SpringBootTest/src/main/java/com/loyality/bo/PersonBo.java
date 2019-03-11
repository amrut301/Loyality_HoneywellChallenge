package com.loyality.bo;

import java.util.Date;
import java.util.List;

public class PersonBo extends BaseBo {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	private Long personId;

	private String firstName;

	private String middleName;

	private String lastName;

	private String email;

	private Date dateOfBirth;

	// needs to be encrypted
	private String loyalityCardNumber;
	// add this column to table-remove has_shared
	private Boolean isReviewed;

	private List<byte[]> reviewPictures;

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public List<byte[]> getReviewPictures() {
		return reviewPictures;
	}

	public void setReviewPictures(List<byte[]> reviewPictures) {
		this.reviewPictures = reviewPictures;
	}

	public String getLoyalityCardNumber() {
		return loyalityCardNumber;
	}

	public void setLoyalityCardNumber(String loyalityCardNumber) {
		this.loyalityCardNumber = loyalityCardNumber;
	}

	public Boolean getIsReviewed() {
		return isReviewed;
	}

	public void setIsReviewed(Boolean isReviewed) {
		this.isReviewed = isReviewed;
	}

}

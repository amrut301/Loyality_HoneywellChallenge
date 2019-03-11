package com.loyality.dao.entities;


import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the category database table.
 * 
 */
@Entity
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="category_id")
	private int categoryId;

	@Column(name="category_esc")
	private int categoryEsc;

	@Column(name="category_name")
	private String categoryName;

	@Column(name="created_by")
	private String createdBy;

	@Column(name="modified_by")
	private String modifiedBy;

	private String status;

	//bi-directional many-to-one association to CategoryType
	@ManyToOne
	@JoinColumn(name="category_type_id")
	private CategoryType categoryType;

	public Category() {
	}

	public int getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getCategoryEsc() {
		return this.categoryEsc;
	}

	public void setCategoryEsc(int categoryEsc) {
		this.categoryEsc = categoryEsc;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
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

	public CategoryType getCategoryType() {
		return this.categoryType;
	}

	public void setCategoryType(CategoryType categoryType) {
		this.categoryType = categoryType;
	}

}
package com.loyality.dao.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the category_type database table.
 * 
 */
@Entity
@Table(name="category_type")
@NamedQuery(name="CategoryType.findAll", query="SELECT c FROM CategoryType c")
public class CategoryType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="category_type_id")
	private int categoryTypeId;

	@Column(name="category_name")
	private String categoryName;

	@Column(name="category_type_val")
	private String categoryTypeVal;

	@Column(name="created_by")
	private String createdBy;

	@Column(name="modified_by")
	private String modifiedBy;

	private String status;

	//bi-directional many-to-one association to Category
	@OneToMany(mappedBy="categoryType")
	private List<Category> categories;

	public CategoryType() {
	}

	public int getCategoryTypeId() {
		return this.categoryTypeId;
	}

	public void setCategoryTypeId(int categoryTypeId) {
		this.categoryTypeId = categoryTypeId;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryTypeVal() {
		return this.categoryTypeVal;
	}

	public void setCategoryTypeVal(String categoryTypeVal) {
		this.categoryTypeVal = categoryTypeVal;
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

	public List<Category> getCategories() {
		return this.categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public Category addCategory(Category category) {
		getCategories().add(category);
		category.setCategoryType(this);

		return category;
	}

	public Category removeCategory(Category category) {
		getCategories().remove(category);
		category.setCategoryType(null);

		return category;
	}

}
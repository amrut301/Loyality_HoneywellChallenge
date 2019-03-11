package com.loyality.bo;

import com.loyality.bo.constants.CategoryType;

public class CategoryBo extends BaseBo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer categoryId;

	private String categoryName;

	private CategoryType categoryType;

	private String categoryDesc;

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public CategoryType getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(CategoryType categoryType) {
		this.categoryType = categoryType;
	}

	public String getCategoryDesc() {
		return categoryDesc;
	}

	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}

}

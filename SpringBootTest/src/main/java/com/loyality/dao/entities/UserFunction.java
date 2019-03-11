package com.loyality.dao.entities;


import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user_function database table.
 * 
 */
@Entity
@Table(name="user_function")
@NamedQuery(name="UserFunction.findAll", query="SELECT u FROM UserFunction u")
public class UserFunction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="FUNCTION_ID")
	private String functionId;

	private String category;

	private String description;

	public UserFunction() {
	}

	public String getFunctionId() {
		return this.functionId;
	}

	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
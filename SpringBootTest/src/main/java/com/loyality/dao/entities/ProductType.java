package com.loyality.dao.entities;


import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the product_type database table.
 * 
 */
@Entity
@Table(name="product_type")
@NamedQuery(name="ProductType.findAll", query="SELECT p FROM ProductType p")
public class ProductType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="product_type_id")
	private int productTypeId;

	@Column(name="product_type_desc")
	private String productTypeDesc;

	@Column(name="product_type_name")
	private String productTypeName;

	@Column(name="product_type_val")
	private String productTypeVal;

	private String status;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="productType")
	private List<Product> products;

	public ProductType() {
	}

	public int getProductTypeId() {
		return this.productTypeId;
	}

	public void setProductTypeId(int productTypeId) {
		this.productTypeId = productTypeId;
	}

	public String getProductTypeDesc() {
		return this.productTypeDesc;
	}

	public void setProductTypeDesc(String productTypeDesc) {
		this.productTypeDesc = productTypeDesc;
	}

	public String getProductTypeName() {
		return this.productTypeName;
	}

	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}

	public String getProductTypeVal() {
		return this.productTypeVal;
	}

	public void setProductTypeVal(String productTypeVal) {
		this.productTypeVal = productTypeVal;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setProductType(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setProductType(null);

		return product;
	}

}
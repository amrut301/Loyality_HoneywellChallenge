package com.loyality.dao.entities;


import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="product_id")
	private int productId;

	@Column(name="product_desc")
	private int productDesc;

	@Temporal(TemporalType.DATE)
	@Column(name="product_expiry_dt")
	private Date productExpiryDt;

	@Temporal(TemporalType.DATE)
	@Column(name="product_mfr_dt")
	private Date productMfrDt;

	@Column(name="product_name")
	private int productName;

	@Column(name="product_price")
	private int productPrice;

	@Column(name="product_qr_code")
	private int productQrCode;

	//bi-directional many-to-one association to PersonTransaction
	@OneToMany(mappedBy="product")
	private List<PersonTransaction> personTransactions;

	//bi-directional many-to-one association to ProductType
	@ManyToOne
	@JoinColumn(name="product_type_id")
	private ProductType productType;

	public Product() {
	}

	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getProductDesc() {
		return this.productDesc;
	}

	public void setProductDesc(int productDesc) {
		this.productDesc = productDesc;
	}

	public Date getProductExpiryDt() {
		return this.productExpiryDt;
	}

	public void setProductExpiryDt(Date productExpiryDt) {
		this.productExpiryDt = productExpiryDt;
	}

	public Date getProductMfrDt() {
		return this.productMfrDt;
	}

	public void setProductMfrDt(Date productMfrDt) {
		this.productMfrDt = productMfrDt;
	}

	public int getProductName() {
		return this.productName;
	}

	public void setProductName(int productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return this.productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductQrCode() {
		return this.productQrCode;
	}

	public void setProductQrCode(int productQrCode) {
		this.productQrCode = productQrCode;
	}

	public List<PersonTransaction> getPersonTransactions() {
		return this.personTransactions;
	}

	public void setPersonTransactions(List<PersonTransaction> personTransactions) {
		this.personTransactions = personTransactions;
	}

	public PersonTransaction addPersonTransaction(PersonTransaction personTransaction) {
		getPersonTransactions().add(personTransaction);
		personTransaction.setProduct(this);

		return personTransaction;
	}

	public PersonTransaction removePersonTransaction(PersonTransaction personTransaction) {
		getPersonTransactions().remove(personTransaction);
		personTransaction.setProduct(null);

		return personTransaction;
	}

	public ProductType getProductType() {
		return this.productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

}
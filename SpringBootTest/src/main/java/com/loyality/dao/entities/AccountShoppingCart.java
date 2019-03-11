package com.loyality.dao.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the account_shopping_cart database table.
 * 
 */
@Entity
@Table(name="account_shopping_cart")
@NamedQuery(name="AccountShoppingCart.findAll", query="SELECT a FROM AccountShoppingCart a")
public class AccountShoppingCart implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="account_shopping_cart_id")
	private int accountShoppingCartId;

	private String status;

	//bi-directional many-to-one association to Account
	@ManyToOne
	@JoinColumn(name="account_id")
	private Account account;

	//bi-directional many-to-one association to ShoppingCart
	@ManyToOne
	@JoinColumn(name="cart_id")
	private ShoppingCart shoppingCart;

	public AccountShoppingCart() {
	}

	public int getAccountShoppingCartId() {
		return this.accountShoppingCartId;
	}

	public void setAccountShoppingCartId(int accountShoppingCartId) {
		this.accountShoppingCartId = accountShoppingCartId;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public ShoppingCart getShoppingCart() {
		return this.shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

}
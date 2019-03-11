package com.loyality.dao.entities;


import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the shopping_cart database table.
 * 
 */
@Entity
@Table(name="shopping_cart")
@NamedQuery(name="ShoppingCart.findAll", query="SELECT s FROM ShoppingCart s")
public class ShoppingCart implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cart_id")
	private int cartId;

	@Column(name="cart_name")
	private String cartName;

	@Column(name="clear_cart")
	private int clearCart;

	private String status;

	//bi-directional many-to-one association to AccountShoppingCart
	@OneToMany(mappedBy="shoppingCart")
	private List<AccountShoppingCart> accountShoppingCarts;

	public ShoppingCart() {
	}

	public int getCartId() {
		return this.cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public String getCartName() {
		return this.cartName;
	}

	public void setCartName(String cartName) {
		this.cartName = cartName;
	}

	public int getClearCart() {
		return this.clearCart;
	}

	public void setClearCart(int clearCart) {
		this.clearCart = clearCart;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<AccountShoppingCart> getAccountShoppingCarts() {
		return this.accountShoppingCarts;
	}

	public void setAccountShoppingCarts(List<AccountShoppingCart> accountShoppingCarts) {
		this.accountShoppingCarts = accountShoppingCarts;
	}

	public AccountShoppingCart addAccountShoppingCart(AccountShoppingCart accountShoppingCart) {
		getAccountShoppingCarts().add(accountShoppingCart);
		accountShoppingCart.setShoppingCart(this);

		return accountShoppingCart;
	}

	public AccountShoppingCart removeAccountShoppingCart(AccountShoppingCart accountShoppingCart) {
		getAccountShoppingCarts().remove(accountShoppingCart);
		accountShoppingCart.setShoppingCart(null);

		return accountShoppingCart;
	}

}
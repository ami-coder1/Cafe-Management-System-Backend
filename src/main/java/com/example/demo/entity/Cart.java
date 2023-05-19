package com.example.demo.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Cart")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_id")
	private int cartId;
	
	@Column(name = "quantity")
	private int quantity;
	
	@JsonIgnoreProperties({"handler","hibernateLazyIntitializer"})
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="userid")
	private User user;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="newid")
	private Product product;

	
	public Cart() {
		
	}
	public Cart(int cartId, int quantity, User user, Product product) {
		
		this.cartId = cartId;
		this.quantity = quantity;
		this.user = user;
		this.product = product;
	}


	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getUserId() {
		return user.getUserId();
	}
	
	public String getUserName() {
		return user.getUserName();
	}
	
	public int getProductId()
	{
		return this.product.getProductId();
	}
	
	public String getProductName() {
		return product.getProductName();
	}

	public int getProductPrice() {
		return product.getProductPrice();
	}

	public void setProduct(Product product) {
	this.product = product;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", user=" + user + ", product=" + product + "]";
	}
	
}

package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "Orders")
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "oid")
	private int orderId;
	
	@Column(name = "cart_id")
	private int cartId;
	
	@ManyToOne(targetEntity = Cart.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "cart_id", insertable = false, updatable = false)
	private Cart cart;

	public Orders() {
		
	}

	public Orders(int orderId, int cartId) {
		
		this.orderId = orderId;
		this.cartId = cartId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", cartId=" + cartId + ", cart=" + cart + "]";
	}
}

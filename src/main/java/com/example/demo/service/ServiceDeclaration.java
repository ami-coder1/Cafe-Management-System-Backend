package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Cart;
import com.example.demo.entity.Orders;
import com.example.demo.entity.Product;
import com.example.demo.entity.ProductCategory;
import com.example.demo.entity.User;

public interface ServiceDeclaration {

	//user
	public List<User> displayAllUser();
	public User insertUser(User user);
	public User updateUser(User user);
	public User searchByUserId(int uid);
	public List<User> searchByUserName(String userName);
	public void deleteUser(int uid);
	
	//product
	public List<Product> displayAllProduct();
	public void insertProduct(Product product);
	public void updateProduct(Product product);
	public void deleteProduct(int productId);
	public List<Product> searchByProductName(String productName);
	//public List<Product> searchByProductCategory(String productCategory);
	
	//product_category
	public List<ProductCategory> displayAllProductCategory();
	public void insertProductCategory(ProductCategory productCategory);
	//public void deleteProductCategory(int productCatId);
	public List<ProductCategory> searchByProductCategoryName(String productCatName);
	
	
	//cart
	public List<Cart> viewCart();
	public Cart addToCart(int userId, int newid, int quantity);
	public void deleteCart(int cartId);
	
	//orders
	public List<Orders> displayAllOrders();
	public Orders searchByOrderId(int orderId);
	
	
	public User fetchUserByEmailId(String email);
	public User fetchUserByEmailIdAndPassword(String userEmail, String userPassword);
	
}

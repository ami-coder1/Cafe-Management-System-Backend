package com.example.demo.service;

import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Cart;
import com.example.demo.entity.Orders;
import com.example.demo.entity.Product;
import com.example.demo.entity.ProductCategory;
import com.example.demo.entity.User;
import com.example.demo.persistence.CartRepository;
import com.example.demo.persistence.OrdersRepository;
import com.example.demo.persistence.ProductCategoryRepository;
import com.example.demo.persistence.ProductRepository;
import com.example.demo.persistence.UserRepository;

@Service
public class ServiceImplementation implements ServiceDeclaration {

	private UserRepository ur; 
	private ProductRepository pr;
	private ProductCategoryRepository pcr;
	private CartRepository cr;
	private OrdersRepository or;
	
	@Autowired
	public ServiceImplementation(UserRepository ur, ProductRepository pr, ProductCategoryRepository pcr,
			CartRepository cr, OrdersRepository or) {
		
		this.ur = ur;
		this.pr = pr;
		this.pcr = pcr;
		this.cr = cr;
		this.or = or;
	}

	@Override
	@Transactional
	public List<User> displayAllUser() {
		
		List<User> userList = ur.findAll(); 
		return userList;
	}

	@Override
	@Transactional
	public User insertUser(User user) {
       
		Encoder encoder = Base64.getEncoder();
		String originalpass=user.getUserPassword();
		String encodepassword=encoder.encodeToString(originalpass.getBytes());
		user.setUserPassword(encodepassword);
		return ur.save(user);
	}

	@Override
	@Transactional
	public User updateUser(User user) {
	
		return ur.save(user);
	}

	@Override
	@Transactional
	public User searchByUserId(int uid) {
	
		User user = ur.findById(uid).get();
		return user;
	}	

	@Override
	@Transactional
	public void deleteUser(int uid) {
		
		ur.deleteById(uid);
	}
	
	@Override
	@Transactional
	public List<User> searchByUserName(String userName) {
		
		List<User> userList = ur.findByUserName(userName);
		return userList;
	}

	//*****************************************************************************
	
	@Override
	@Transactional
	public List<Product> displayAllProduct() {
		
		List<Product> prodList = pr.findAll();
		return prodList;
	}

	@Override
	@Transactional
	public void insertProduct(Product product) {
		
		pr.save(product);
	}

	@Override
	@Transactional
	public void updateProduct(Product product) {
		
		pr.save(product);
	}

	@Override
	@Transactional
	public void deleteProduct(int productId) {
		
		pr.deleteById(productId);
	}

	@Override
	@Transactional
	public List<Product> searchByProductName(String productName) {
		
		List<Product> product = pr.findByProductName(productName);
		return product;
	}

	/*@Override
	@Transactional
	public List<Product> searchByProductCategory(String productCategory) {
		
		List<Product> productCategoryList = pr.findByProductCategory(productCategory);
		return productCategoryList;				
	}*/

	//*****************************************************************************
	
	@Override
	@Transactional
	public List<ProductCategory> displayAllProductCategory() {
		
		List<ProductCategory> prodCategoryList = pcr.findAll();
		return prodCategoryList;
	}

	@Override
	@Transactional
	public List<ProductCategory> searchByProductCategoryName(String productCatName) {
		
		List<ProductCategory> prodCategory = pcr.findByProductCatName(productCatName);
		return prodCategory;
	}
	
	@Override
	@Transactional
	public void insertProductCategory(ProductCategory productCategory) {
		
		pcr.save(productCategory);
	}

	/*@Override
	@Transactional
	public void deleteProductCategory(int productCatId) {
		
		pcr.deleteById(productCatId);
	}*/

	//*****************************************************************************
	
	@Override
	@Transactional
	public List<Cart> viewCart() {
		
		List<Cart> cartList = cr.findAll();
		return cartList;	
	}

	@Override
	@Transactional
	public Cart addToCart(int userid, int newid, int quantity) {
        
		User user = ur.findById(userid).orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));

        Product product = pr.findById(newid).orElseThrow(() -> new IllegalArgumentException("Invalid product ID"));

        Cart cart = new Cart();
        cart.setUser(user);
        cart.setProduct(product);
        cart.setQuantity(cart.getQuantity() + quantity);

        return cr.save(cart);
    }

	@Override
	@Transactional
	public void deleteCart(int cartId) {
		
		cr.deleteById(cartId);
	}

	//*****************************************************************************
	
	@Override
	@Transactional
	public List<Orders> displayAllOrders() {
		
		List<Orders> ordersList = or.findAll();
		return ordersList;
	}

	@Override
	@Transactional
	public Orders searchByOrderId(int orderId) {
	
		Orders orders = or.findById(orderId).get();
		return orders;
	}

	//*****************************************************************************
	
	@Override
	@Transactional
	public User fetchUserByEmailId(String userEmail) {
		
		return ur.findByUserEmail(userEmail);
	}
	
	@Override
	@Transactional
	public User fetchUserByEmailIdAndPassword(String userEmail, String userPassword) {
		
		return ur.findByUserEmailAndUserPassword(userEmail, userPassword);
	}
}

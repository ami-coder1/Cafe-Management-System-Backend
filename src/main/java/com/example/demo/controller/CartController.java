package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Cart;
import com.example.demo.service.ServiceImplementation;

@RestController
@RequestMapping("cart")
public class CartController {

	private ServiceImplementation si;

	@Autowired
	public CartController(ServiceImplementation si) {
		
		this.si = si;
	}
	
	@GetMapping("list")
	public List<Cart> displayAll()
	{
		return si.viewCart();
	}
	
	/*@PostMapping("list")
	public void cart(@RequestBody Cart cart) {
		
		cart.setCartId(0);
		si.addToCart(cart.getUser(), cart.getProduct());
	}*/
	
	@PostMapping("/user/{userid}/product/{newid}")
    public Cart addToCart(@PathVariable int userid, @PathVariable int newid, @RequestParam int quantity) {
        
		return si.addToCart(userid, newid,quantity);
    }

	@DeleteMapping("list/{cartId}")
	public void delete(@PathVariable("cartId") int cartId) {
		
		si.deleteCart(cartId);
	}
}

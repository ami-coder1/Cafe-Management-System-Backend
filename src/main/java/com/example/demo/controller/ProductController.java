package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ServiceImplementation;

@RestController
@RequestMapping("product")
public class ProductController {

	private ServiceImplementation si;

	@Autowired
	public ProductController(ServiceImplementation si) {
		
		this.si = si;
	}
	
	@GetMapping("list")
	public List<Product> displayAll()
	{
		return si.displayAllProduct();
	}
	
	@PostMapping("list")
	public void insert(@RequestBody Product product)
	{
		si.insertProduct(product);
	}
	
	@DeleteMapping("list/{productId}")
	public void delete(@PathVariable("productId") int productId)
	{
		si.deleteProduct(productId);
	}
	
	@PutMapping("list")
	public void update(@RequestBody Product product)
	{
		si.updateProduct(product);
	}
	
	@GetMapping("list1/{productName}")
	public List<Product> searchProductName(@PathVariable("productName") String productName)
	{
		return si.searchByProductName(productName);
	}
	
	/*@GetMapping("list2/{productCategory}")
	public List<Product> searchProductCategory(@PathVariable("productCategory") String productCategory) {
		
		return si.searchByProductCategory(productCategory);
	}*/
	
	
}

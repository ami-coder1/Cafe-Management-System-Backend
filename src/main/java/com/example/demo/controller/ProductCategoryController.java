package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ProductCategory;
import com.example.demo.service.ServiceImplementation;

@RestController
@RequestMapping("productcategory")
public class ProductCategoryController {

	private ServiceImplementation si;

	@Autowired
	public ProductCategoryController(ServiceImplementation si) {
		
		this.si = si;
	}

	@GetMapping("list")
	public List<ProductCategory> displayAll()
	{
		return si.displayAllProductCategory();
	}
	
	@PostMapping("list")
	public void insert(@RequestBody ProductCategory productCategory)
	{
		si.insertProductCategory(productCategory);
	}
	
	/*@DeleteMapping("list/{productCatId}")
	public void delete(@PathVariable("productCatId") int productCatId)
	{
		si.deleteProductCategory(productCatId);
	}*/
	
	@GetMapping("list1/{productCategoryName}")
	public List<ProductCategory> searchProductCategoryName(@PathVariable("productCategoryName") String productCategoryName) {
		
		return si.searchByProductCategoryName(productCategoryName);
	}
	
}

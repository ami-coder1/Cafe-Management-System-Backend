package com.example.demo.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	public List<Product> findByProductName(String productName);
	
	//public List<Product> findByProductCategory(String productCategory);
}

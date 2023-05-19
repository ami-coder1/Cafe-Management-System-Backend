package com.example.demo.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

	public List<ProductCategory> findByProductCatName(String productCatName);
}

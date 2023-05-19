package com.example.demo.entity;

import java.util.List;

import javax.persistence.*;

@Entity
@Table( name = "ProductCategory")
public class ProductCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_cat_id")
	private int productCatId;
	
	@Column(name = "product_cat_name")
	private String productCatName;
	
	@OneToMany(mappedBy = "productCategory")
	private List<Product> products;

	public ProductCategory() {
		
	}

	public ProductCategory(int productCatId, String productCatName) {
		
		this.productCatId = productCatId;
		this.productCatName = productCatName;
	}

	public int getProductCatId() {
		return productCatId;
	}

	public void setProductCatId(int productCatId) {
		this.productCatId = productCatId;
	}

	public String getProductCatName() {
		return productCatName;
	}

	public void setProductCatName(String productCatName) {
		this.productCatName = productCatName;
	}

	
	@Override
	public String toString() {
		return "ProductCategory [productCatId=" + productCatId + ", productCatName=" + productCatName + "]";
	}
	
}

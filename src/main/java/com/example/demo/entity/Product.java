package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "Product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private int productId;
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "product_price")
	private int productPrice;
	
	@Column(name = "product_desc")
	private String productDesc;
	
	@Lob
	@Column(name = "product_image")
	private byte[] productImage;
	
	@Column(name = "product_cat_id")
	private int productCatId;
	
	@ManyToOne(targetEntity = ProductCategory.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "product_cat_id", insertable = false, updatable = false)
	private ProductCategory productCategory;

	public Product() {
		
	}

	public Product(int productId, String productName, int productPrice, String productDesc, byte[] productImage, int productCatId) {
		
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDesc = productDesc;
		this.productImage = productImage;
		this.productCatId = productCatId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public byte[] getProductImage() {
		return productImage;
	}

	public void setProductImage(byte[] productImage) {
		this.productImage = productImage;
	}

	public int getProductCatId() {
		return productCatId;
	}

	public void setProductCatId(int productCatId) {
		this.productCatId = productCatId;
	}

	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productDesc=" + productDesc + ", productQuantity=" + productImage + ", productCategory=" + productCategory + "]";
	}
	
}

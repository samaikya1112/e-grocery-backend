package com.onlinegrocery.dto;

import com.onlinegrocery.enums.Category;

import lombok.Data;

@Data
public class ProductDto {
	
	private int productId;
	private String productName;
	private String description;
	private Category category;
	private String imageUrl;
	private double price;
	@Override
	public String toString() {
		return "ProductDto [productId=" + productId + ", productName=" + productName + ", description=" + description
				+ ", category=" + category + ", imageUrl=" + imageUrl + ", price=" + price + "]";
	}
	public ProductDto(int productId, String productName, String description, Category category, String imageUrl,
			double price) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.category = category;
		this.imageUrl = imageUrl;
		this.price = price;
	}
	public ProductDto() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	

}


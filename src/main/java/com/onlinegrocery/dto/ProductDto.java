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
	

}


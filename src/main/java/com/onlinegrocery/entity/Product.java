package com.onlinegrocery.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.onlinegrocery.enums.Category;

import lombok.Data;

@Data
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int productId;
	private String productName;
	private String description;
	private Category category;
	private String imageUrl;
	private double price;
	
	
	
}


package com.onlinegrocery.dto;

import java.util.List;



import lombok.Data;

@Data
public class WishlistDto {

	private int productId;
	private double ProductPrice;
	public WishlistDto(int productId, double productPrice) {
		super();
		this.productId = productId;
		ProductPrice = productPrice;
	}
	public WishlistDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public double getProductPrice() {
		return ProductPrice;
	}
	public void setProductPrice(double productPrice) {
		ProductPrice = productPrice;
	}
	

	}

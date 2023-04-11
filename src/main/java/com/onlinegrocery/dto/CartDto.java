package com.onlinegrocery.dto;

import java.util.List;

import lombok.Data;

@Data
public class CartDto {
	
	private int productCount;
	private double totalPrice;
	private int productId;
	public int getProductCount() {
		return productCount;
	}
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	@Override
	public String toString() {
		return "CartDto [productCount=" + productCount + ", totalPrice=" + totalPrice + ", productId=" + productId
				+ "]";
	}
	public CartDto(int productCount, double totalPrice, int productId) {
		super();
		this.productCount = productCount;
		this.totalPrice = totalPrice;
		this.productId = productId;
	}
	public CartDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}


package com.onlinegrocery.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="wishlist")
public class Wishlist {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int WishlistId;
	private int productCount;
	private double ProductPrice;
	
	@OneToMany(targetEntity = Product.class, fetch = FetchType.EAGER)
	private List<Product> products;

	@Override
	public String toString() {
		return "Wishlist [WishlistId=" + WishlistId + ", productCount=" + productCount + ", ProductPrice="
				+ ProductPrice + ", products=" + products + "]";
	}

	public Wishlist(int wishlistId, int productCount, double productPrice, List<Product> products) {
		super();
		WishlistId = wishlistId;
		this.productCount = productCount;
		ProductPrice = productPrice;
		this.products = products;
	}

	public Wishlist() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getWishlistId() {
		return WishlistId;
	}

	public void setWishlistId(int wishlistId) {
		WishlistId = wishlistId;
	}

	public int getProductCount() {
		return productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}

	public double getProductPrice() {
		return ProductPrice;
	}

	public void setProductPrice(double productPrice) {
		ProductPrice = productPrice;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	
	
	

	
}

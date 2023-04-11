package com.onlinegrocery.entity;



import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name="cart")
public class Cart {
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", productCount=" + productCount + ", totalPrice=" + totalPrice
				+ ", products=" + products + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;
	private int productCount;
	private double totalPrice;
	
	@OneToMany(targetEntity = Product.class, fetch = FetchType.EAGER)
	private List<Product> products;

	public Cart(int cartId, int productCount, double totalPrice, List<Product> products) {
		super();
		this.cartId = cartId;
		this.productCount = productCount;
		this.totalPrice = totalPrice;
		this.products = products;
	}

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	
}


package com.onlinegrocery.service;

import java.util.List;

import com.onlinegrocery.dto.CartDto;
import com.onlinegrocery.entity.Cart;



public interface CartService {
	
	Cart addItemToCart(CartDto cartDTO);
	
	String deleteItemFromCart(int cartId);
	
	Cart getCartById(int cartId);

	List<Cart> getAllCartItems();

	Cart updateCart(int cartId, CartDto cartDTO);

	

	



	
	
	
	
}

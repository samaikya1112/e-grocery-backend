package com.onlinegrocery.dto;

import java.util.List;



import lombok.Data;

@Data
public class WishlistDto {

	private List<Integer> productId;
	private double totalPrice;

	}

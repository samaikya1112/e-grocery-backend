package com.onlinegrocery.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinegrocery.entity.Wishlist;
import com.onlinegrocery.exceptions.WishlistNotFoundException;
import com.onlinegrocery.repo.ProductRepo;
import com.onlinegrocery.repo.WishlistRepo;
import com.onlinegrocery.service.WishlistService;



@Service
public class WishlistServiceImpl implements WishlistService{
	
	@Autowired
	private WishlistRepo wishlistRepo;
	
	@Autowired
	private ProductRepo productRepo;

	@Override
	public Wishlist addWishlist(Wishlist wishlist) {
		return wishlistRepo.save(wishlist);
	}

	@Override
	public String deleteWishlist(int wishlistId) {
		wishlistRepo.deleteById(wishlistId);
		return "Wishlist deleted successfully";
		
	}

	

	@Override
	public List<Wishlist> getAllWishlist() {
		
		return wishlistRepo.findAll();
	}

	@Override
	public Wishlist getWishlistById(int wishlistId) {
		return wishlistRepo.findById(wishlistId).orElseThrow(()-> new WishlistNotFoundException("Wishlist not found with given Id"));
	}
	
	
	

}


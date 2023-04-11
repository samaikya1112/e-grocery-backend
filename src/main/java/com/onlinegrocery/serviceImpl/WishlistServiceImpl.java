package com.onlinegrocery.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinegrocery.dto.WishlistDto;
import com.onlinegrocery.entity.Cart;
import com.onlinegrocery.entity.Product;
import com.onlinegrocery.entity.Wishlist;
import com.onlinegrocery.exceptions.ProductNotFoundException;
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
	public Wishlist addWishlist(WishlistDto wishlistDto) {
		Wishlist wishlist=new Wishlist();
    	Product product=productRepo.findById(wishlistDto.getProductId()).get();
    	List<Product> listProducts=new ArrayList<>();
    	wishlist.setProductPrice(wishlistDto.getProductPrice());
    	listProducts.add(product);
    	wishlist.setProducts(listProducts);
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


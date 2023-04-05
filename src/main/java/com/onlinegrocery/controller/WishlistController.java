package com.onlinegrocery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinegrocery.entity.Wishlist;
import com.onlinegrocery.service.WishlistService;



@RestController
@RequestMapping("/wishlist")
public class WishlistController {
	
	@Autowired
	private WishlistService wishlistService;
	
	
	@PostMapping("/addWishlist")
	public ResponseEntity<Wishlist> addWishlist( @RequestBody Wishlist wishlist) { 
			return new ResponseEntity<Wishlist>(wishlistService.addWishlist(wishlist) , HttpStatus.OK);
	}
	
	@DeleteMapping("deleteById/{id}")
	public void deleteWishlistById(@PathVariable int id){
		wishlistService.deleteWishlist(id);
	}
	
	
	@GetMapping("getWishlistById/{wishlistId}")
	public ResponseEntity<Wishlist> getWishlistById (@PathVariable int wishlistId){
	return new ResponseEntity<Wishlist>(wishlistService.getWishlistById(wishlistId),HttpStatus.OK);
	}
	
	@GetMapping("getAllWishlist")
	public List<Wishlist> getAllWishlist(){
		return wishlistService.getAllWishlist();
	}
	

}


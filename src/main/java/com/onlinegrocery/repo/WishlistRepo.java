package com.onlinegrocery.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.onlinegrocery.entity.Wishlist;


public interface WishlistRepo extends JpaRepository<Wishlist, Integer> {

}

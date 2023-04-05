package com.onlinegrocery.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.onlinegrocery.entity.Cart;

public interface CartRepo extends JpaRepository<Cart, Integer>{

}

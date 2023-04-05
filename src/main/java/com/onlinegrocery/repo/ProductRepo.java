package com.onlinegrocery.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinegrocery.entity.Product;
import com.onlinegrocery.enums.Category;



public interface ProductRepo extends JpaRepository<Product, Integer>{

	List<Product> findByCategory(Category category);

	

}

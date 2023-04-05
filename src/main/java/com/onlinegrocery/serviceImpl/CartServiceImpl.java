package com.onlinegrocery.serviceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.onlinegrocery.dto.CartDto;
import com.onlinegrocery.entity.Cart;
import com.onlinegrocery.entity.Product;
import com.onlinegrocery.exceptions.CartNotFoundException;
import com.onlinegrocery.exceptions.ProductNotFoundException;
import com.onlinegrocery.repo.CartRepo;
import com.onlinegrocery.repo.ProductRepo;
import com.onlinegrocery.service.CartService;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepo cartRepo;

    @Autowired
    private ProductRepo productRepo;

 
    @Override
    public Cart addItemToCart(CartDto cartDTO) {
        int productId = cartDTO.getProductId();
        Optional<Product> optionalProduct = productRepo.findById(productId);
        if (!optionalProduct.isPresent()) {
            throw new ProductNotFoundException("Product doesn't exist with id: " + productId);
        }

        Product product = optionalProduct.get();

        Cart cartEntity = new Cart();
        cartEntity.setProductCount(cartDTO.getProductCount());
        cartEntity.setProducts(Collections.singletonList(product));
        cartEntity.setTotalPrice(cartDTO.getTotalPrice());

        try {
            cartEntity = cartRepo.save(cartEntity);
            return cartEntity;
        } catch (Exception e) {
            throw new CartNotFoundException("Something went wrong while adding item to cart");
        }
    }

    @Override
    public Cart updateCart(int id, CartDto cartDTO) {
        Optional<Cart> optionalCart = cartRepo.findById(id);
        if (optionalCart.isPresent()) {
            Cart cartEntity = optionalCart.get();
            List<Product> productEntityList = new ArrayList<>();
            int productId = cartDTO.getProductId();
            Optional<Product> optionalProduct = productRepo.findById(productId);
            if (optionalProduct.isPresent()) {
                productEntityList.add(optionalProduct.get());
            } else {
                throw new CartNotFoundException("Product doesn't exist with id: " + productId);
            }
            cartEntity.setProductCount(cartDTO.getProductCount());
            cartEntity.setProducts(productEntityList);
            cartEntity.setTotalPrice(cartDTO.getTotalPrice());
            try {
                cartEntity = cartRepo.save(cartEntity);
                return cartEntity;
            } catch (Exception e) {
                throw new CartNotFoundException("Something went wrong while updating cart");
            }
        } else {
            throw new CartNotFoundException("Cart doesn't exist with id: " + id);
        }
    }



    @Override
    public String deleteItemFromCart(int cartId) {
        if (!cartRepo.existsById(cartId)) {
            throw new CartNotFoundException("Cart not found");
        }
        cartRepo.deleteById(cartId);
        return "Deleted successfully";
    }

    @Override
    public Cart getCartById(int cartId) {
        return cartRepo.findById(cartId).orElseThrow(() -> new CartNotFoundException("Cart Not Found with given id"));
    }

    @Override
    public List<Cart> getAllCartItems() {
        return cartRepo.findAll();
    }

}

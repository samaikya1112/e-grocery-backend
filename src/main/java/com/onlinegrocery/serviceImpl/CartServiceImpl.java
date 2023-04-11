package com.onlinegrocery.serviceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.onlinegrocery.dto.CartDto;
import com.onlinegrocery.entity.Cart;
import com.onlinegrocery.entity.Product;
import com.onlinegrocery.exceptions.CartNotFoundException;
import com.onlinegrocery.exceptions.ProductNotFoundException;
import com.onlinegrocery.exceptions.UnhandledException;
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
//		List<Product> productEntityList = new ArrayList<>();
//		for (int productId : cartDTO.getProductId()) {
//			Optional<Product> optionalProduct = productRepo.findById(productId);
//			if (optionalProduct.isPresent()) {
//				productEntityList.add(optionalProduct.get());
//			} else {
//				throw new CartNotFoundException("Product doesn't exist with id: " + productId);
//			}
//		}
//
//		Cart cartEntity = new Cart();
//		cartEntity.setProductCount(cartDTO.getProductCount());
//		cartEntity.setProducts(productEntityList);
//		cartEntity.setTotalPrice(cartDTO.getTotalPrice());
//
//		try {
//			cartEntity = cartRepo.save(cartEntity);
//			return cartEntity;
//		} catch (Exception e) {
//			throw new CartNotFoundException("Something went wrong while adding item to cart");
//		}
    	Cart cart=new Cart();
    	Product product=productRepo.findById(cartDTO.getProductId()).get();
    	List<Product> listProducts=new ArrayList<>();
    	cart.setProductCount(cartDTO.getProductCount());
    	cart.setTotalPrice(cartDTO.getTotalPrice());
    	listProducts.add(product);
    	cart.setProducts(listProducts);
    	return cartRepo.save(cart);
	}

    
   
   
//    @Override
//    public Cart updateCart(int cartId, CartDto cartDTO) {
//        Product product = productRepo.findById(cartDTO.getProductId()).orElseThrow(() -> new CartNotFoundException("Product not found with id: " + cartDTO.getProductId()));
//        Cart cart = cartRepo.findById(cartId).orElseThrow(() -> new CartNotFoundException("Cart not found with id: " + cartId));
//        cart.setProductCount(cartDTO.getProductCount());
//        cart.setTotalPrice(cartDTO.getTotalPrice());
//        //cart.setProducts(product);
//        System.out.println(cart);
//        cartRepo.save(cart);
//        return cart;
//    }
    @Override
    public Cart updateCart(int cartId, CartDto cartDTO) {
        // Find the product by ID
        Product product = productRepo.findById(cartDTO.getProductId())
            .orElseThrow(() -> new ProductNotFoundException("Product not found"));

        // Find the cart by ID
        Cart cart = cartRepo.findById(cartId)
            .orElseThrow(() -> new CartNotFoundException("Cart not found"));

        // Update the cart
        cart.setProductCount(cartDTO.getProductCount());
        cart.setTotalPrice(cartDTO.getTotalPrice());

        // Add the product to the cart if it is not already present
        if (!cart.getProducts().contains(product)) {
            cart.getProducts().add(product);
        }

        // Save the cart
        cartRepo.save(cart);

        // Return the updated cart
        return cart;
    }



    
    	
    	
    	
//        Optional<Cart> optionalCart = cartRepo.findById(id);
//        if(optionalCart.isPresent()) {
//            Optional<Product> optionalProduct = productRepo.findById(cartDTO.getProductId());
//            if(optionalProduct.isPresent()) {
//                Cart basketEntity = optionalCart.get(); 
//                basketEntity.setProductCount(cartDTO.getProductCount());
//                basketEntity.setProducts(Collections.singletonList(optionalProduct.get()));
//                basketEntity.setTotalPrice(cartDTO.getTotalPrice());
//
//                basketEntity = cartRepo.save(basketEntity);
//                return basketEntity;
//            }
//            else {
//                throw new CartNotFoundException("Product doesnt exists with id: "+cartDTO.getProductId());
//            }
//        }
//        else {
//            throw new CartNotFoundException("Basket doesnt exists with id: "+id);
//        }
    //}


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

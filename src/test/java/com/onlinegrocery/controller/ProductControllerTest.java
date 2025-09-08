 package com.onlinegrocery.controller;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.mock;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.io.IOException;
import java.util.Arrays;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.multipart.MultipartFile;

import com.onlinegrocery.controller.ProductController;
import com.onlinegrocery.entity.Product;
import com.onlinegrocery.enums.Category;
import com.onlinegrocery.service.ProductService;

@RunWith(SpringRunner.class)
public class ProductControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;
    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }

    @Test
    public void testAddProduct() throws IOException {
       
        String productName = "Test Product";
        String description = "Test description";
        double price = 10.0;
        Category category = Category.DAIRY;
        int stockQuantity = 100;
        String base64Image = "base64image";
        byte[] images = new byte[] {1, 2, 3};
        MultipartFile image = mock(MultipartFile.class);
        when(image.getBytes()).thenReturn(images);
        Product expectedProduct = new Product(1, "Product 1", "Description 1", Category.DAIRY, null, 10.0, 5);
        when(productService.addProduct(productName, description, price, images, category, stockQuantity, base64Image)).thenReturn(expectedProduct);

       
        ResponseEntity<Product> response = productController.addProduct(productName, description, price, category, stockQuantity, base64Image, image);

      
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(expectedProduct, response.getBody());
    }

    
   

    @Test
    public void testDeleteProduct() throws Exception {
        int productId = 1;
        when(productService.deleteProduct(productId)).thenReturn("Product deleted successfully");

        mockMvc.perform(delete("/product/delete/{productId}", productId))
                .andExpect(status().isOk());

        verify(productService).deleteProduct(productId);
    }
    	
  

    @Test
    public void testGetAllProducts() throws Exception {
        
        Product mockProduct1 = new Product(1, "Product 1", "Description 1", Category.DAIRY, null, 10.0, 5);
		Product mockProduct2 = new Product(2, "Product 2", "Description 2", Category.MEAT, null, 20.0, 10);
        List<Product> mockProducts = Arrays.asList(mockProduct1, mockProduct2);

        
        when(productService.getAllProducts()).thenReturn(mockProducts);

        
        mockMvc.perform(get("/product/getallproducts")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].productId").value(1))
                .andExpect(jsonPath("$[0].productName").value("Product 1"))
                .andExpect(jsonPath("$[0].description").value("Description 1"))
                .andExpect(jsonPath("$[0].price").value(10.0))
                .andExpect(jsonPath("$[0].category").value(Category.DAIRY.toString()))
                .andExpect(jsonPath("$[0].stockQuantity").value(5))
               
                .andExpect(jsonPath("$[1].productId").value(2))
                .andExpect(jsonPath("$[1].productName").value("Product 2"))
                .andExpect(jsonPath("$[1].description").value("Description 2"))
                .andExpect(jsonPath("$[1].price").value(20.0))
                .andExpect(jsonPath("$[1].category").value(Category.MEAT.toString()))
                .andExpect(jsonPath("$[1].stockQuantity").value(10));
               
    }
    
    @Test
    public void testGetProductByCategory() throws Exception {
       
        List<Product> mockProducts = Arrays.asList(
                new Product(1, "Milk", "Fresh milk", Category.DAIRY,null, 1.99,  100),
                new Product(2, "Banana", "Fresh bread", Category.FRUITS,null, 2.99,  50));

       
        when(productService.getProductByCategory(Category.DAIRY)).thenReturn(mockProducts);

       
        mockMvc.perform(get("/product/getby/DAIRY"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].productName").value("Milk"))
                .andExpect(jsonPath("$[0].description").value("Fresh milk"))
                .andExpect(jsonPath("$[0].price").value(1.99))
                .andExpect(jsonPath("$[0].category").value(Category.DAIRY.toString()))
                .andExpect(jsonPath("$[0].stockQuantity").value(100));
               

        
        verify(productService).getProductByCategory(Category.DAIRY);
    }
    
    @Test
    public void testGetById() throws Exception {
        
        Product mockProduct = new Product();
        mockProduct.setProductId(1);
        mockProduct.setProductName("test product");
        mockProduct.setDescription("test description");
        mockProduct.setPrice(10.99);
        mockProduct.setCategory(Category.DAIRY);
        mockProduct.setStockQuantity(100);
        
        
        when(productService.getById(1)).thenReturn(mockProduct);
        
       
        mockMvc.perform(get("/product/getbyid/1"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.productId").value(1))
               .andExpect(jsonPath("$.productName").value("test product"))
               .andExpect(jsonPath("$.description").value("test description"))
               .andExpect(jsonPath("$.price").value(10.99))
               .andExpect(jsonPath("$.category").value(Category.DAIRY.toString()))
               .andExpect(jsonPath("$.stockQuantity").value(100));
        
        
        verify(productService).getById(1);
    }
    
    
   
    
  
    @Test
    public void testAddOrUpdateProduct() throws Exception {
    
    String productName = "Test Product";
    String description = "This is a test product.";
    double price = 9.99;
    MultipartFile image = mock(MultipartFile.class);
    Category category = Category.DAIRY;
    int stockQuantity = 10;
    String base64Image = "data:image/jpeg;base64,/9j/4AAQSkZJRgABAQEASABIAAD...";
    int productId = 123;
     
    Product product = new Product();
    when(productService.updateProduct(productName, description, price, image.getBytes(), category, stockQuantity, base64Image, productId))
    .thenReturn(product);
     
      ResponseEntity<Product> response = productController.addOrUpdateProduct(productName, description, price, image, category, stockQuantity, base64Image, productId);
     
    
    assertNotNull(response);
    assertEquals(HttpStatus.CREATED, response.getStatusCode());
    assertEquals(product, response.getBody());
    }


    
    

}

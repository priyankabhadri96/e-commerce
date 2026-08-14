package com.example.e_commerce.service;


import com.example.e_commerce.controller.ProductsController;
import com.example.e_commerce.model.Products;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;import
        java.util.Optional;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@WebMvcTest(ProductsController.class)
public class ProductsControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockitoBean
//    private ProductsService productsService;
//    @Test
//    void shouldGetProductById() throws Exception {
//
//        Products product = new Products();
//        product.setId(1L);
//        product.setName("Laptop");
//        product.setPrice(2500.00);
//
//        when(productsService.getProductsById(1L))
//                .thenReturn((product));
//
//        mockMvc.perform(get("/products/1"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value(1))
//                .andExpect(jsonPath("$.name").value("Laptop"))
//                .andExpect(jsonPath("$.price").value(2500));
//
//        verify(productsService).getProductsById(1L);
//    }
}

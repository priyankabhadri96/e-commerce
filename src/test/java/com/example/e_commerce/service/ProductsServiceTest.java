package com.example.e_commerce.service;

import com.example.e_commerce.dto.ProductsRequest;
import com.example.e_commerce.model.Categories;
import com.example.e_commerce.model.Products;
import com.example.e_commerce.repository.CategoriesRepository;
import com.example.e_commerce.repository.ProductsRepository;
import io.swagger.v3.oas.annotations.extensions.Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertNotNull;


//@ExtendWith(MockitoExtension.class)
public class ProductsServiceTest {
//
//    @Mock
//    private ProductsRepository productsRepository;
//
//    @Mock
//    private CategoriesRepository categoriesRepository;
//
//    @InjectMocks
//    private ProductsService productsService;
//
//
//    public void getProductsByIdTest(Long id){
//        ProductsRequest request = new ProductsRequest();
//        request.setName("Laptop");
//        request.setPrice(2500.00);
//        request.setCategory_id(1l);
//
//        Categories c = new Categories();
//        c.setName("Electronics");
//        c.setId(1L);
//
//        Products savedProduct = new Products();
//        savedProduct.setCategory(c);
//        savedProduct.setPrice(2500.00);
//        savedProduct.setName("Laptop");
//        savedProduct.setId(100L);
//
//        when(categoriesRepository.findById(1L)).thenReturn(Optional.of(c));
//
//        when(productsRepository.save(any(Products.class))).thenReturn(savedProduct);
//        Products result = productsService.createProduct(request);
//        assertNotNull(result);
//        assertEquals(100L, result.getId());
//        assertEquals("Laptop", result.getName());
//        assertEquals(2500L, result.getPrice());
//
//        verify(categoriesRepository).findById(1L);
//        verify(productsRepository).save(any(Products.class));
//
//
//
//
//
//
//
//
//    }
//

}

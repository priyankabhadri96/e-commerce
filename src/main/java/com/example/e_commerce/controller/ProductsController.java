package com.example.e_commerce.controller;

import com.example.e_commerce.dto.ProductsRequest;
import com.example.e_commerce.model.Products;
import com.example.e_commerce.repository.ProductsRepository;
import com.example.e_commerce.service.ProductsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductsController {
    private final ProductsService productsService;

    public ProductsController(ProductsService productsService){
        this.productsService = productsService;
    }

    @GetMapping
    public ResponseEntity<List<Products>> getAllProducts(){
        return ResponseEntity.ok(productsService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Products> getProductById(@PathVariable Long id){
        return ResponseEntity.ok(productsService.getProductsById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducts(@PathVariable Long id){
        productsService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Products> createProduct(@RequestBody ProductsRequest p){
        return ResponseEntity.status(HttpStatus.CREATED).body(productsService.createProduct(p));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Products> updateProduct(@PathVariable Long id , @RequestBody ProductsRequest p){
        return ResponseEntity.ok(productsService.updateProduct(id,p));
    }
}

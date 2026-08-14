package com.example.e_commerce.service;

import com.example.e_commerce.dto.ProductsRequest;
import com.example.e_commerce.model.Categories;
import com.example.e_commerce.model.Products;
import com.example.e_commerce.repository.CategoriesRepository;
import com.example.e_commerce.repository.ProductsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {

    private final ProductsRepository productsRepository;
    private final CategoriesRepository categoriesRepository;

    public ProductsService(ProductsRepository productsRepository,CategoriesRepository categoriesRepository){
        this.productsRepository = productsRepository;
        this.categoriesRepository = categoriesRepository;
    }

    public List<Products> getAllProducts(){
        return productsRepository.findAll();
    }

    public Products getProductsById(Long id) {
        return productsRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Product with id " + id + " not found"));
    }

    public void deleteProduct(Long id) {

        Products product = productsRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Product with id " + id + " not found"));

        productsRepository.delete(product);
    }

    public Products updateProduct(Long id, ProductsRequest request){
        Categories c =  categoriesRepository.findById(request.getCategory_id()).orElseThrow(()-> new RuntimeException("Category with "+ request.getCategory_id() + " not found"));

        Products p =productsRepository.findById(id).stream().findFirst().orElseThrow(()->new RuntimeException("product with id not found"));
        p.setName(request.getName());
        p.setPrice(request.getPrice());
        p.setCategory(c);
        return productsRepository.save(p);
    }

    public Products createProduct(ProductsRequest request){
       Categories c =  categoriesRepository.findById(request.getCategory_id()).orElseThrow(()-> new RuntimeException("Category with "+ request.getCategory_id() + " not found"));
       Products p = new Products();
       p.setName(request.getName());
       p.setPrice(request.getPrice());
       p.setName(request.getName());
       p.setCategory(c);


        return productsRepository.save(p);
    }

}

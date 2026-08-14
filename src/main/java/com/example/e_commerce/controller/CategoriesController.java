package com.example.e_commerce.controller;

import com.example.e_commerce.model.Categories;
import com.example.e_commerce.repository.CategoriesRepository;
import com.example.e_commerce.service.CategoriesService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoriesController {

    private CategoriesService categoriesService;

    public CategoriesController(CategoriesService categoriesService){
        this.categoriesService = categoriesService;
    }

    @GetMapping
    public ResponseEntity<List<Categories>> getAllCategories(){
        return ResponseEntity.ok(categoriesService.getAllCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Categories>> getCategoryById(@PathVariable Long id){
        return ResponseEntity.ok(categoriesService.getCategoriesById(id));
    }

    @PostMapping
    public ResponseEntity<Categories> createCategories(@RequestBody Categories c){
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriesService.createCategories(c));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categories> updateCategory(@PathVariable Long id, @RequestBody Categories c){
        return ResponseEntity.ok(categoriesService.updateCategories(id,c));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id){
        categoriesService.deleteCategories(id);
        return ResponseEntity.noContent().build();
    }

}

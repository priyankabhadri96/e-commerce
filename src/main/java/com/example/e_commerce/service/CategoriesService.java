package com.example.e_commerce.service;

import com.example.e_commerce.model.Categories;
import com.example.e_commerce.repository.CategoriesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriesService {
    private final CategoriesRepository categoriesRepository;

    public CategoriesService(CategoriesRepository categoriesRepository){
        this.categoriesRepository = categoriesRepository;
    }

    public List<Categories> getAllCategories(){
        return categoriesRepository.findAll();
    }

    public Optional<Categories> getCategoriesById(Long id){
        return categoriesRepository.findById(id);

    }
    public Categories updateCategories(Long id,Categories catagory){
    Categories c  =  categoriesRepository.findById(id).stream().findFirst().
            orElseThrow(()-> new RuntimeException("categroy with "+id+" not found"));

    c.setName(catagory.getName());
     return categoriesRepository.save(c);
    }

    public void deleteCategories(Long id){
         categoriesRepository.deleteById(id);
    }
    public Categories createCategories(Categories category){
        return categoriesRepository.save(category);

    }
}

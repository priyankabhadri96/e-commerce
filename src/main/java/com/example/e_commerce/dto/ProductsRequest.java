package com.example.e_commerce.dto;


import jakarta.persistence.Column;
import jakarta.validation.constraints.Positive;

public class ProductsRequest {
    @Column(nullable = false,unique = true)
    String name;

    @Positive
    Double price;
    @Column(nullable = false)
    Long category_id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }
}

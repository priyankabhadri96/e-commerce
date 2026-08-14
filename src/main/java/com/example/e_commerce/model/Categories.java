package com.example.e_commerce.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(unique = true,nullable = false)
    String name;

    @OneToMany(mappedBy = "category")
    private List<Products> products = new ArrayList<>();

    public Categories(){

    }
    public Categories(Long id, String name){
        this.id = id;
        this.name = name;

    }
    public Categories(String name){
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

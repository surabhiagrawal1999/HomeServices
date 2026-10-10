package com.homeserve.homeserve.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String category;
    private double price;

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public int getId(){
        return id;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price=price;
    }

    public void setId(int id){
        this.id=id;
    }

    public String getCategory(){
        return category;
    }

    public void setCategory(String category){
        this.category=category;
    }
}

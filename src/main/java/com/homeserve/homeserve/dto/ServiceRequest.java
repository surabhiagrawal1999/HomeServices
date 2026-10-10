package com.homeserve.homeserve.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class ServiceRequest {

    @NotBlank(message="Name cannot be blank")
    private String name;
    @NotBlank(message="Category needs to be defined")
    private String category;
    @Positive(message = "Price should be >₹0")
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory(){
        return category;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price){
        this.price=price;
    }
}

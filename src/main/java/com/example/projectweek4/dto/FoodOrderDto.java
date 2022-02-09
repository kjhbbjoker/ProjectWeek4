package com.example.projectweek4.dto;

import com.example.projectweek4.model.Food;
import com.example.projectweek4.model.FoodOrder;
import lombok.Data;

@Data
public class FoodOrderDto {
    String name;
    int quantity;
    int price;



public FoodOrderDto(String name, int quantity, int price) {
        this.name = name;
        this.quantity =quantity;
        this.price = price;
    }

    public FoodOrderDto(FoodOrder item) {
        this.name = item.getFood().getName();
        this.quantity = item.getQuantity();
        this.price = item.getTotalPrice();
    }
}


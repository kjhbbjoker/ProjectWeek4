package com.example.projectweek4.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderDto {
    String restaurantName;
    List<FoodOrderDto> foods;
    int deliveryFee;
    int totalPrice;
}

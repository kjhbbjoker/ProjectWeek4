package com.example.projectweek4.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderRequestDto {
    Long restaurantId;
    List<FoodOrderRequestDto> foods;
}

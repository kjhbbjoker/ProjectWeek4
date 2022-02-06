package com.example.projectweek4.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RestaurantDto {
    private Long id;
    private String name;
    private int minOrderPrice;
    private int deliveryFee;


    public RestaurantDto() {

    }


    public RestaurantDto(Long id, String name, int deliveryFee, int minOrderPrice) {
        this.id = id;
        this.name = name;
        this.deliveryFee = deliveryFee;
        this.minOrderPrice = minOrderPrice;
    }


}

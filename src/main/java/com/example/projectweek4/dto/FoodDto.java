package com.example.projectweek4.dto;


import com.example.projectweek4.model.Food;
import com.example.projectweek4.model.Restaurant;
import lombok.Data;

@Data
public class FoodDto {

    private Long id;
    private String name;
    private int price;


    public FoodDto() {

    }



    public FoodDto(Long id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }


  /*  public Food getFood(Restaurant restaurant){
        this.name;
        this.price
    }*/












}

package com.example.projectweek4.model;



import com.example.projectweek4.dto.FoodDto;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Food {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name; //음식점 이름

    @Column(name = "price", nullable = false)
    private int price;  ///음식 가격

    @JoinColumn(name = "restaurant_id") //외래키
    @ManyToOne
    private Restaurant restaurant;


    public Food() {}

    public Food(FoodDto FoodRequest, Restaurant restaurant) {
        this.name = FoodRequest.getName();
        this.price = FoodRequest.getPrice();
        this.restaurant = restaurant;
    }

    public FoodDto toFoodReadResDTO() {
        return new FoodDto(this.id, this.name, this.price);
    }
}






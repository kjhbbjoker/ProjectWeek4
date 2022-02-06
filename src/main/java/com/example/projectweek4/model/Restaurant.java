package com.example.projectweek4.model;



import com.example.projectweek4.dto.RestaurantDto;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Restaurant {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private  Long id; //음식점 아이디


    @Column(name = "name", nullable = false)
    private String name; //음식점 이름

    @Column(name = "min_order_price", nullable = false)
    private int minOrderPrice; //최소 주문 가격

    @Column(name = "delivery_fee", nullable = false)
    private int deliveryFee; //배달비용

    public Restaurant() {}


    public Restaurant(RestaurantDto RestaurantRequest) {
        this.name = RestaurantRequest.getName();
        this.deliveryFee = RestaurantRequest.getDeliveryFee();
        this.minOrderPrice = RestaurantRequest.getMinOrderPrice();
    }


    public RestaurantDto GetDto() {
        return new RestaurantDto(id, name, deliveryFee, minOrderPrice);
    }


}

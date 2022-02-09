package com.example.projectweek4.model;

import com.example.projectweek4.dto.FoodDto;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class FoodOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private  Long id;

    @Column(name = "quantity")
    private int quantity; //주문 갯수 수량

    @Column(name = "totalPrice")
    private int totalPrice; //총가격

    @JoinColumn(name = "orderId") //주문 외래키
    @ManyToOne
    private Orders order;


    @JoinColumn(name = "FoodId") //주문 외래키
    @ManyToOne
    private Food Food;

    public FoodOrder() {

    }





}

package com.example.projectweek4.model;

import javax.persistence.*;


@Entity
public class FoodOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private  Long id;

    @Column(name = "quantity")
    private Long quantity; //주문 갯수 수량

    @Column(name = "price")
    private int price; //가격

    @JoinColumn(name = "food_id") // 음식 외래키
    @ManyToOne
    private Food foods;

    @JoinColumn(name = "order_id") //주문 외래키
    @ManyToOne
    private Order order;
}

package com.example.projectweek4.model;

import javax.persistence.*;


@Entity
public class FoodOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private  Long id;

    @Column(name = "quantity")
    private int quantity; //주문 갯수 수량

    @Column(name = "totalPrice")
    private int totalPrice; //가격

    @JoinColumn(name = "orderId") //주문 외래키
    @ManyToOne
    private Orders order;



}

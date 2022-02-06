package com.example.projectweek4.model;

import javax.persistence.*;


@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private  long id;

    @Column(name ="delivery_fee")
    private int deliveryFee;  //배달비


    @Column(name ="total_price")
    private int totalPrice;  //배달비

    @JoinColumn(name = "restaurant_id") //외래키
    @ManyToOne
    private Restaurant restaurant;
}

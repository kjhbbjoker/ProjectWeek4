package com.example.projectweek4.model;


import javax.persistence.*;

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name ="deliveryFee")
    private int deliveryFee;  //배달비

    @JoinColumn(name = "restaurantId") //외래키
    @ManyToOne
    private Restaurant restaurant;
}

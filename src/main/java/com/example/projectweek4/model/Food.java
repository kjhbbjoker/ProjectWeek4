package com.example.projectweek4.model;



import javax.persistence.*;

@Entity
public class Food {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;  ///음식 이름

    @Column(name = "price")
    private int price;  ///음식 가격

    @JoinColumn(name = "restaurant_id") //외래키
    @ManyToOne
    private Restaurant restaurant;
}





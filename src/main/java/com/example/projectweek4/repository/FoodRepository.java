package com.example.projectweek4.repository;

import com.example.projectweek4.model.Food;
import com.example.projectweek4.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long> {


    List<Food> findByRestaurant(Restaurant restaurant);

    Food findByNameAndRestaurant(String name, Restaurant restaurant);
}

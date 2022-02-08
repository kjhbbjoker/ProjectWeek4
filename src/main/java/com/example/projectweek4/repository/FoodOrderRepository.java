package com.example.projectweek4.repository;

import com.example.projectweek4.model.FoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodOrderRepository extends JpaRepository<FoodOrder, Long> {
}

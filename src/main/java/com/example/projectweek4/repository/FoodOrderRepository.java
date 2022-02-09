package com.example.projectweek4.repository;

import com.example.projectweek4.model.FoodOrder;
import com.example.projectweek4.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodOrderRepository extends JpaRepository<FoodOrder, Long> {
    List<FoodOrder> findByOrder(Orders orders);
}

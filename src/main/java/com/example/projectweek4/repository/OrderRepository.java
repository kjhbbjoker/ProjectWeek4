package com.example.projectweek4.repository;

import com.example.projectweek4.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}

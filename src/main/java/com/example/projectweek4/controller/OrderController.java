package com.example.projectweek4.controller;

import com.example.projectweek4.dto.FoodDto;
import com.example.projectweek4.dto.OrderDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public class OrderController {


    @GetMapping("/orders")
    public List<OrderDto> getOrders(){
        return null;
    }


    @PostMapping("/order/request")
    public List<OrderDto> OrderRegister(){
        return null;
    }
}

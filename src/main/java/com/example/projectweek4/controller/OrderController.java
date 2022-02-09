package com.example.projectweek4.controller;

import com.example.projectweek4.dto.FoodDto;
import com.example.projectweek4.dto.FoodOrderRequestDto;
import com.example.projectweek4.dto.OrderDto;
import com.example.projectweek4.dto.OrderRequestDto;
import com.example.projectweek4.service.FoodService;
import com.example.projectweek4.service.OrderService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Getter
public class OrderController {

    private final OrderService orderService;


    @GetMapping("/orders")
    public ResponseEntity<List<OrderDto>> getOrders(){
        return new ResponseEntity<>(orderService.getOrders(), HttpStatus.OK);
    }

    @PostMapping("/order/request")
    public ResponseEntity<OrderDto> OrderRegister(@RequestBody OrderRequestDto orderRequestDto){
        OrderDto order = new OrderDto();
        if (orderRequestDto.getRestaurantId() == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        for (FoodOrderRequestDto item : orderRequestDto.getFoods()) {
            if (item.getQuantity() < 1 || item.getQuantity() > 100) {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
        }

        try {
            order = orderService.orderRegister(orderRequestDto.getRestaurantId(), orderRequestDto.getFoods());
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
}

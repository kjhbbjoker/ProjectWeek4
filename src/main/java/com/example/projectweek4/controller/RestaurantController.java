package com.example.projectweek4.controller;


import com.example.projectweek4.dto.RestaurantDto;
import com.example.projectweek4.service.RestaurantService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Getter
public class RestaurantController {


    private final RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public ResponseEntity<RestaurantDto[]> readRestaurants() {
        return new ResponseEntity<>(restaurantService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/restaurant/register")
    public ResponseEntity<RestaurantDto> register(@RequestBody RestaurantDto paramDto) {
        if (paramDto.getDeliveryFee() % 100 != 0 || paramDto.getMinOrderPrice() % 100 != 0) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        if (paramDto.getDeliveryFee() % 500 != 0) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        if (paramDto.getDeliveryFee() < 0) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        if (paramDto.getDeliveryFee() > 10000) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        if (paramDto.getMinOrderPrice() < 1000) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        if (paramDto.getMinOrderPrice() > 100000) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(restaurantService.register(paramDto), HttpStatus.OK);
    }

}

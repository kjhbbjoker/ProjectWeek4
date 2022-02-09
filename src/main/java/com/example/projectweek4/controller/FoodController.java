package com.example.projectweek4.controller;

import com.example.projectweek4.dto.FoodDto;
import com.example.projectweek4.dto.RestaurantDto;
import com.example.projectweek4.model.Food;
import com.example.projectweek4.service.FoodService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@Getter
public class FoodController {


    private final FoodService foodService;

    @GetMapping("/restaurant/{restaurantId}/foods")
    public List<FoodDto> getFoods(@PathVariable Long restaurantId) {
        return foodService.getFoods(restaurantId);


    }

    @PostMapping("/restaurant/{restaurantId}/food/register")
    public ResponseEntity<List<FoodDto>> registerFood(@PathVariable Long restaurantId, @RequestBody List<FoodDto> FoodRequest) {
        if (restaurantId == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        List<String> dupCheckList = new ArrayList<>();
        for (FoodDto item : FoodRequest) {
            if (dupCheckList.contains(item.getName())) {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            } else {
                dupCheckList.add(item.getName());
            }
        }

        try {
            for (FoodDto item : FoodRequest) {
                if (item.getPrice() < 100) {
                    return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
                }
                if (item.getPrice() > 1000000) {
                    return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
                }
                if (item.getPrice() % 100 != 0) {
                    return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
                }
                    foodService.registerFood(item, restaurantId);
                }
            }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
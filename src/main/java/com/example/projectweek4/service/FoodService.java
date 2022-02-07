package com.example.projectweek4.service;

import com.example.projectweek4.dto.FoodDto;
import com.example.projectweek4.dto.RestaurantDto;
import com.example.projectweek4.model.Food;
import com.example.projectweek4.model.Restaurant;
import com.example.projectweek4.repository.FoodRepository;
import com.example.projectweek4.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor //롬북을 통해서 간단하게 생성자 주입 방식의 어노테이션으로 fjnal이 붙거나 @notNull이 붙은 생성자들을 자동 생성해준다.
@Service
public class FoodService {


    private final FoodRepository foodRepository;
    private final RestaurantRepository restaurantRepository;



    public List<FoodDto> getFoods(Long restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();
        List<Food> list = foodRepository.findByRestaurant(restaurant);
        List<FoodDto> result = new ArrayList<>();
        for (Food item : list) {
            result.add(item.toFoodReadResDTO());
        }

        return result;
    }


    public FoodDto registerFood(FoodDto FoodRequest,Long restaurantId) throws Exception {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();
        Food current = foodRepository.findByNameAndRestaurant(FoodRequest.getName(), restaurant);
        if (current != null) {
            throw new Exception();
        }

        Food result = foodRepository.save(new Food(FoodRequest, restaurant));

        return result.toFoodReadResDTO();
    }
}

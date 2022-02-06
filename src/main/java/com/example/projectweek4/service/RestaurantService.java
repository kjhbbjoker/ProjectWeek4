package com.example.projectweek4.service;

import com.example.projectweek4.dto.RestaurantDto;
import com.example.projectweek4.model.Restaurant;
import com.example.projectweek4.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor //롬북을 통해서 간단하게 생성자 주입 방식의 어노테이션으로 fjnal이 붙거나 @notNull이 붙은 생성자들을 자동 생성해준다.
@Service
public class RestaurantService {


    private final RestaurantRepository restaurantRepository;


    public RestaurantDto[] findAll(){//음식점 전체 조회
        List<Restaurant> list = restaurantRepository.findAll();
        List<RestaurantDto> result = new ArrayList<>();

        for (Restaurant item : list) {
            result.add(item.GetDto());
        }
        return result.stream().toArray(RestaurantDto[]::new);
    }

    public RestaurantDto register(RestaurantDto paramDto) {
        Restaurant result = restaurantRepository.save(new Restaurant(paramDto));

        return result.GetDto();
    }
}
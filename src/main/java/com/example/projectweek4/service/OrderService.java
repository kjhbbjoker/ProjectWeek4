package com.example.projectweek4.service;

import com.example.projectweek4.dto.FoodDto;
import com.example.projectweek4.dto.FoodOrderDto;
import com.example.projectweek4.dto.FoodOrderRequestDto;
import com.example.projectweek4.dto.OrderDto;
import com.example.projectweek4.model.Food;
import com.example.projectweek4.model.FoodOrder;
import com.example.projectweek4.model.Orders;
import com.example.projectweek4.model.Restaurant;
import com.example.projectweek4.repository.FoodOrderRepository;
import com.example.projectweek4.repository.FoodRepository;
import com.example.projectweek4.repository.OrderRepository;
import com.example.projectweek4.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor //롬북을 통해서 간단하게 생성자 주입 방식의 어노테이션으로 fjnal이 붙거나 @notNull이 붙은 생성자들을 자동 생성해준다.
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final FoodOrderRepository foodOrderRepository;
    private final RestaurantRepository restaurantRepository;
    private final FoodRepository foodRepository;



    public List<OrderDto> getOrders(){
        List<OrderDto> result = new ArrayList<>();
        List<Orders> orders = orderRepository.findAll();

        for (Orders item : orders) {
            OrderDto itemResult = new OrderDto();
            List<FoodOrder> foods = foodOrderRepository.findByOrder(item);
            List<FoodOrderDto> foodOrderDtoList = getFoodOrderDtoList(foods);
            String restaurantName = item.getRestaurant().getName();

            itemResult.setFoods(foodOrderDtoList);
            itemResult.setRestaurantName(restaurantName);
            itemResult.setDeliveryFee(item.getDeliveryFee());
            itemResult.setTotalPrice(getTotalPrice(foodOrderDtoList) + item.getDeliveryFee());

            result.add(itemResult);
        }
        return result;
    }

    private int getTotalPrice(List<FoodOrderDto> foodOrderDtoList) {
        int totalPrice = 0;
        for (FoodOrderDto item : foodOrderDtoList) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    private List<FoodOrderDto> getFoodOrderDtoList(List<FoodOrder> foods) {
        List<FoodOrderDto> result = new ArrayList<>();

        for (FoodOrder item : foods) {
            FoodOrderDto data = new FoodOrderDto(item);
            result.add(data);
        }

        return result;
    }

    public OrderDto orderRegister(Long restaurantId ,List<FoodOrderRequestDto> foods) throws Exception {
        OrderDto result = new OrderDto();
        Restaurant restaurant = restaurantRepository.findById(restaurantId).get(); //음식점 아이디 가져오기
        List<FoodOrderDto> foodOrderDtoList = new ArrayList<>();
        int deliveryFee = restaurant.getDeliveryFee();
        int minOrderPrice = restaurant.getMinOrderPrice();

        int totalPrice = 0;
        for (FoodOrderRequestDto food : foods) {
            Food f = foodRepository.findById(food.getId()).get();
            int foodOrderTotalPrice = f.getPrice() * food.getQuantity();
            totalPrice += foodOrderTotalPrice;
        }
        if (minOrderPrice > totalPrice) {
            throw new Exception();
        }

        Orders item = new Orders();
        item.setDeliveryFee(deliveryFee);
        item.setRestaurant(restaurant);
        item = orderRepository.save(item);

        for (FoodOrderRequestDto food : foods) {
            Food f = foodRepository.findById(food.getId()).get();
            FoodOrder fo = new FoodOrder();
            fo.setQuantity(food.getQuantity());
            fo.setOrder(item);
            fo.setFood(f);
            int foodOrderTotalPrice = f.getPrice() * food.getQuantity();
            fo.setTotalPrice(foodOrderTotalPrice);
            foodOrderRepository.save(fo);

            foodOrderDtoList.add(new FoodOrderDto(fo));
        }

        result.setRestaurantName(restaurant.getName());
        result.setDeliveryFee(deliveryFee);
        result.setFoods(foodOrderDtoList);
        result.setTotalPrice(totalPrice + deliveryFee);
        return result;
    }
}

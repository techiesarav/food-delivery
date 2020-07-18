package com.sample.fdsystem.fooddelivery.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.fdsystem.fooddelivery.model.Food;
import com.sample.fdsystem.fooddelivery.model.FoodCatagaloue;
import com.sample.fdsystem.fooddelivery.model.FoodItem;
import com.sample.fdsystem.fooddelivery.model.Restaurant;
import com.sample.fdsystem.fooddelivery.repository.RestaurantRepository;
import com.sample.fdsystem.fooddelivery.service.RestaurantService;

@Service
@Transactional
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	RestaurantRepository restaurantRepository;
	
	@Override
	public List<FoodCatagaloue> getAvailableFoods(String location) {
		List<Restaurant> restaurantList= restaurantRepository.getRestaurants();
		List<FoodCatagaloue> foodCatList =restaurantList.stream()
		 .filter(restaurant ->restaurant.getLocation().equals(location))
		 .map(restaurant ->{
			 List<Food> foodList =restaurant.getFoods();
			 List<FoodItem> foodItemList =foodList.stream().map(food ->{
				return new FoodItem(food.getName(),food.getPrice());
			 }).collect(Collectors.toList());
			 FoodCatagaloue fc = new FoodCatagaloue(restaurant.getName(),foodItemList);
			 return fc;
		 }).collect(Collectors.toList());
		return foodCatList;
	}

	
}

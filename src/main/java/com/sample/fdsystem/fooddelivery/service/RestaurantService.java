package com.sample.fdsystem.fooddelivery.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sample.fdsystem.fooddelivery.model.Food;
import com.sample.fdsystem.fooddelivery.model.FoodCatagaloue;

@Service
public interface RestaurantService {

	List<FoodCatagaloue> getAvailableFoods(String location);
}

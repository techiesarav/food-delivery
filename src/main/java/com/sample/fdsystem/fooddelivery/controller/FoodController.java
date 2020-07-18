package com.sample.fdsystem.fooddelivery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.fdsystem.fooddelivery.model.FoodCatagaloue;
import com.sample.fdsystem.fooddelivery.service.RestaurantService;

@RestController()
@RequestMapping("/food")
public class FoodController {

	@Autowired
	private RestaurantService restaurantService;
	
	@GetMapping("/location/{name}")
	public List<FoodCatagaloue> getAvailableFoods(@PathVariable String name){
		return restaurantService.getAvailableFoods(name);
	} 
	
}

package com.sample.fdsystem.fooddelivery.model;

import java.util.List;

public class FoodCatagaloue {

	private String restaurantName;
	
	List<FoodItem> foodItems;
	
	public FoodCatagaloue(String restaurantName,List<FoodItem> foodItems){
		this.restaurantName = restaurantName;
		this.foodItems = foodItems;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public List<FoodItem> getFoodItems() {
		return foodItems;
	}

	public void setFoodItems(List<FoodItem> foodItems) {
		this.foodItems = foodItems;
	}
}

package com.sample.fdsystem.fooddelivery.model;

public class FoodItem{
	private String name;
	
	private int price;
	
	public FoodItem(String name,int price){
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}	
}

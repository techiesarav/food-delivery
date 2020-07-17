package com.sample.fdsystem.fooddelivery.model;

public class Order {
		int quantity;
		
		Food food;
		
		int price;
		
		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public Food getFood() {
			return food;
		}

		public void setFood(Food food) {
			this.food = food;
		}

		
		public Order(int quantity,Food food,int price){
			this.quantity = quantity;
			this.food = food;
			this.price=price;
		}
}

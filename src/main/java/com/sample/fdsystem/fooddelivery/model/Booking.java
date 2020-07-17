package com.sample.fdsystem.fooddelivery.model;

import java.util.List;

public class Booking {
	
	int orderId;
	
	List<Order> orders;
	
	int totalPrice;
	
	public Booking(){
		super();
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
}

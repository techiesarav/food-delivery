package com.sample.fdsystem.fooddelivery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.fdsystem.fooddelivery.model.Booking;
import com.sample.fdsystem.fooddelivery.model.Orders;
import com.sample.fdsystem.fooddelivery.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService; 
	
	@PostMapping("/create")
	public Orders createOrders(@RequestBody Orders orderFood) {
		return orderService.save(orderFood);
	}
	
	@PutMapping("/update")
	public Orders updateOrders(@RequestBody Orders orderFood) {
		return orderService.save(orderFood);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteOrders(@PathVariable Integer id) {
		orderService.deleteById(id);
	}
	
	@GetMapping("/get/all")
	public List<Orders> getOrderss() {
		return orderService.findAll();
	}
	
	@GetMapping("/bookings")
	public List<Booking> getBookings(){
		return orderService.getBookings();
	}
	
}

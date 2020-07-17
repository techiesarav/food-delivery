package com.sample.fdsystem.fooddelivery.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sample.fdsystem.fooddelivery.model.Booking;
import com.sample.fdsystem.fooddelivery.model.Orders;

@Service
public interface OrderService {
	
	public List<Orders> findAll();
	
	 public Orders findById(Integer id);
	 
	 public void deleteById(Integer id);
	 
	 public Orders save(Orders c);
	 
	 public List<Booking> getBookings();

}

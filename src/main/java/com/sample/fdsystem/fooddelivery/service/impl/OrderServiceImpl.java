package com.sample.fdsystem.fooddelivery.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.fdsystem.fooddelivery.model.Booking;
import com.sample.fdsystem.fooddelivery.model.Order;
import com.sample.fdsystem.fooddelivery.model.Orders;
import com.sample.fdsystem.fooddelivery.repository.OrderRepository;
import com.sample.fdsystem.fooddelivery.service.OrderService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public List<Orders> findAll() {
		return orderRepository.findAll();
	}

	@Override
	public Orders findById(Integer id) {
		return orderRepository.findById(id);
	}

	@Override
	public void deleteById(Integer id) {
		 orderRepository.deleteById(id);
	}

	@Override
	public Orders save(Orders c) {
		return orderRepository.save(c);
	}

	@Override
	public List<Booking> getBookings() {
		List<Booking> res = new ArrayList<>();
		List<Orders> orderList = this.findAll();
		Map<Integer, Booking> ordersMap = prepareOrderDetails(orderList);
		res=ordersMap.values().stream().collect(Collectors.toList());
		return  res;
	}

	private Map<Integer, Booking> prepareOrderDetails(List<Orders> orderList) {
		Map<Integer,Booking> ordersMap = new HashMap<>();
		for(int i=0;i<orderList.size();i++) {
			Orders order=orderList.get(i);
			if(ordersMap.containsKey(order.getId())) {
				Booking booking = ordersMap.get(order.getId());
				List<Order> oList =booking.getOrders();
				int quan=order.getQuantity();
				int price =order.getFood().getPrice();
				int totalPrice =quan *price;
				Order o = new Order(order.getQuantity(),order.getFood(),order.getFood().getPrice());
				oList.add(o);
				booking.setOrders(oList);
				booking.setTotalPrice(booking.getTotalPrice()+totalPrice);
				ordersMap.put(order.getId(), booking);
			}else {
				Booking booking = new Booking();
				List<Order> oList =new ArrayList<>();
				int quan=order.getQuantity();
				int price =order.getFood().getPrice();
				Order o = new Order(order.getQuantity(),order.getFood(),order.getFood().getPrice());
				oList.add(o);
				booking.setOrderId(order.getId());
				booking.setOrders(oList);
				booking.setTotalPrice(quan *price);
				ordersMap.put(order.getId(), booking);
			}
		}
		return ordersMap;
	}
	

}

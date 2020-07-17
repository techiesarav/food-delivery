package com.sample.fdsystem.fooddelivery;


import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.sample.fdsystem.fooddelivery.model.Orders;
import com.sample.fdsystem.fooddelivery.service.OrderService;


@SpringBootTest
class FoodDeliveryApplicationTests {

	private Logger logger = LoggerFactory.getLogger(FoodDeliveryApplicationTests.class);
	
	@Autowired
	OrderService orderService;
	
	@Test
	public void findById_test() {
		Orders o =orderService.findById(1);
		logger.info("Find By Id =o =>{}",o);
	}
	
	@Test
	@DirtiesContext
	public void deleteById_test() {
		orderService.deleteById(1);
		assertNull(orderService.findById(1));
	}
	
	@Test
	@DirtiesContext
	public void save_test() {
		Orders o =orderService.findById(1);
		o.setQuantity(3);
		orderService.save(o);
		Orders o1 =orderService.findById(1);
		assertEquals(3,o1.getQuantity());
	}
}

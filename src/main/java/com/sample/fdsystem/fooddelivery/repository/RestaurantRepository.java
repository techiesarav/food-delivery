package com.sample.fdsystem.fooddelivery.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.sample.fdsystem.fooddelivery.model.Food;
import com.sample.fdsystem.fooddelivery.model.Restaurant;

@Repository
public class RestaurantRepository {

	@PersistenceContext
	EntityManager entityManager;
	
	public List<Restaurant> getRestaurants(){
		TypedQuery<Restaurant> restaurantQuery=entityManager.createQuery("select f from Restaurant f"
				,Restaurant.class);
		return restaurantQuery.getResultList();
	}
	
}

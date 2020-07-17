package com.sample.fdsystem.fooddelivery.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.sample.fdsystem.fooddelivery.model.Orders;


@Repository
public class OrderRepository {

	@PersistenceContext
	private EntityManager en;
	
	public List<Orders> findAll() {
		TypedQuery<Orders> query = en.createQuery("select c from Orders c",Orders.class);
		return query.getResultList();
	}
	
	public Orders findById(Integer id) {
		return en.find(Orders.class, id);
	}
	 
	public void deleteById(Integer id) {
		Orders c = en.find(Orders.class, id);
		en.remove(c);
	}
	
	public Orders save(Orders c) {
		if(c.getId() == null) {
			en.persist(c);
		}else {
			en.merge(c);
		}
		return c;
	}
}

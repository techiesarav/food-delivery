package com.sample.fdsystem.fooddelivery.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Orders{
	
	@Id
	private Integer id;
	
	@Column(nullable=false)
	private int quantity;
	
	@CreationTimestamp
    private LocalDateTime orderedDate;
	
	@ManyToOne()
	private Food food;
	
	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	protected Orders() {
		super();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public LocalDateTime getOrdersedDate() {
		return orderedDate;
	}

	public void setCreatedDate(LocalDateTime orderedDate) {
		this.orderedDate = orderedDate;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + id + ", quantity=" + quantity + ", orderedDate=" + orderedDate + "]";
	}
	
}

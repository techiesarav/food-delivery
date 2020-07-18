package com.sample.fdsystem.fooddelivery.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.UniqueConstraint;

@Entity
public class Restaurant {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false)
	private String location;
	
	@ManyToMany
	@JoinTable(name="RESTAURANT_FOOD",joinColumns= {@JoinColumn(name="RESTAURANT_ID")},
	  inverseJoinColumns= {@JoinColumn(name="FOOD_ID")}
	,uniqueConstraints=@UniqueConstraint(columnNames = {"RESTAURANT_ID", "FOOD_ID"}))
	List<Food> foods = new ArrayList<>();
	
	public List<Food> getFoods() {
		return foods;
	}

	public void setFoods(List<Food> foods) {
		this.foods = foods;
	}

	protected Restaurant() {
		super();
	}
	
	Restaurant(String name,String location){
		this.name = name;
		this.location = location;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", name=" + name + ", location=" + location + "]";
	}
}

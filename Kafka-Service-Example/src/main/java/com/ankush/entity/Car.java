package com.ankush.entity;

public class Car {

	int id;
	
	String carName;
	String companyName;
	Double carPrice;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Double getCarPrice() {
		return carPrice;
	}
	public void setCarPrice(Double carPrice) {
		this.carPrice = carPrice;
	}
	public Car(int id, String carName, String companyName, Double carPrice) {
		super();
		this.id = id;
		this.carName = carName;
		this.companyName = companyName;
		this.carPrice = carPrice;
	}
	
	
	
	
}

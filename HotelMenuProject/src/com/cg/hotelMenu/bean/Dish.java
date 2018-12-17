package com.cg.hotelMenu.bean;

public class Dish {
	private String dishName;
	private int dishPrice;

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public int getDishPrice() {
		return dishPrice;
	}

	public void setDishPrice(int dishPrice) {
		this.dishPrice = dishPrice;
	}

	@Override
	public String toString() {
		return "Product [dishName=" + dishName + ", dishPrice=" + dishPrice + "]";
	}

}

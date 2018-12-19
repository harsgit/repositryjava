package com.cg.hotelMenu.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.cg.hotelMenu.bean.Customer;
import com.cg.hotelMenu.bean.Dish;
import com.cg.hotelMenu.exception.HotelMenuException;

public interface IHotelMenuDao {
	public String addDish(Dish dish) throws ClassNotFoundException, IOException, SQLException, HotelMenuException;

	public Dish viewDishDetails(String dishName) throws ClassNotFoundException, IOException, SQLException;

	public List retriveAll() throws ClassNotFoundException, IOException, SQLException;

	public Dish updateDetails(int dishPrice, String dishName)
			throws ClassNotFoundException, IOException, SQLException, HotelMenuException;

	String addCustomerDetails(Customer customer) throws ClassNotFoundException, IOException, SQLException, HotelMenuException;

	public boolean roomStaus() throws ClassNotFoundException, IOException, SQLException;

	String deleteCustomer(String PhoneNumber) throws ClassNotFoundException, IOException, SQLException;
}

package com.cg.hotelMenu.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.cg.hotelMenu.bean.Customer;
import com.cg.hotelMenu.bean.Dish;
import com.cg.hotelMenu.exception.HotelMenuException;

public interface IHotelMenuService {
	public String addDish(Dish dish) throws ClassNotFoundException, IOException, SQLException;

	public Dish viewDishDetails(String dishName) throws ClassNotFoundException, IOException, SQLException;

	public Dish updateDetails(int dishPrice, String dishName)
			throws ClassNotFoundException, IOException, SQLException, HotelMenuException;

	public List retriveAll() throws ClassNotFoundException, IOException, SQLException;

	public String addCustomerDetails(Customer customer) throws ClassNotFoundException, IOException, SQLException;

	public boolean roomStaus() throws ClassNotFoundException, IOException, SQLException;

	public String deleteCustomer(String phoneNumber) throws ClassNotFoundException, IOException, SQLException;

}
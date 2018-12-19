package com.cg.hotelMenu.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.hotelMenu.bean.Customer;
import com.cg.hotelMenu.bean.Dish;

import com.cg.hotelMenu.dao.HotelMenuDaoImpl;
import com.cg.hotelMenu.dao.IHotelMenuDao;
import com.cg.hotelMenu.exception.HotelMenuException;

public class HotelMenuServiceImpl implements IHotelMenuService {
	IHotelMenuDao HotelMenudao = new HotelMenuDaoImpl();

	@Override
	public String addDish(Dish dish) throws ClassNotFoundException, IOException, SQLException, HotelMenuException {
		// TODO Auto-generated method stub

		String dishName;
		dishName = HotelMenudao.addDish(dish);
		return dishName;
	}

	@Override
	public Dish viewDishDetails(String dishName) throws ClassNotFoundException, IOException, SQLException {
		Dish dish;
		dish = HotelMenudao.viewDishDetails(dishName);
		return dish;
	}

	@Override
	public List retriveAll() throws ClassNotFoundException, IOException, SQLException {
		List<Dish> dishList = null;
		dishList = HotelMenudao.retriveAll();
		return dishList;
	}

	@Override
	public Dish updateDetails(int disPrice, String dishName)
			throws ClassNotFoundException, IOException, SQLException, HotelMenuException {
		Dish dish = null;
		dish = HotelMenudao.updateDetails(disPrice, dishName);
 //System.out.println(dish);
		return dish;
	}

	@Override
	public boolean roomStaus() throws ClassNotFoundException, IOException, SQLException {
		// Room room=null;
		boolean x = HotelMenudao.roomStaus();

		return x;
	}

	@Override
	public String addCustomerDetails(Customer customer) throws ClassNotFoundException, IOException, SQLException, HotelMenuException {
		// TODO Auto-generated method stub
		String customerId;
		customerId = HotelMenudao.addCustomerDetails(customer);
		return customerId;
	}

	@Override
	public String deleteCustomer(String phoneNumber) throws ClassNotFoundException, IOException, SQLException {
		// TODO Auto-generated method stub
		String customerName;
		customerName = HotelMenudao.deleteCustomer(phoneNumber);
		return customerName;
	}

	public static boolean validateDish(Dish dish) throws HotelMenuException {
		List<String> validationErrors = new ArrayList<String>();
		if (!(isValidName(dish.getDishName()))) {
			validationErrors.add("\nDish Name cant be Alpha numeric");
		}
		if (!(isValidPrice(dish.getDishPrice()))) {
			validationErrors.add("\nDish price should be a numeric value");
		}

		if (!(validationErrors.isEmpty())) {

			System.err.println(validationErrors + " ");
			return false;
		}
		return true;
	}

	private static boolean isValidName(String dishName) {
		Pattern namePattern = Pattern.compile("[A-Za-z]*");
		Matcher nameMatcher = namePattern.matcher(dishName);
		return nameMatcher.matches();

	}

	private static boolean isValidPrice(int dishPrice) {
		String price = String.valueOf(dishPrice);
		Pattern phonePattern = Pattern.compile("[0-9]*");
		Matcher phoneMatcher = phonePattern.matcher(price);

		return phoneMatcher.matches();
	}

	public static boolean validateCustomer(Customer customer) throws HotelMenuException {
		List<String> validationErrors = new ArrayList<String>();
		if (!(isValidName(customer.getCustName()))) {
			validationErrors.add("\n Name cant be Alpha numeric");
		}
		if (!(isValidPhoneNumber(customer.getPhoneNumber()))) {
			validationErrors.add("\nPlease enter a valid phone Number");
		}

		if (!(validationErrors.isEmpty())) {

			System.err.println(validationErrors + " ");
			return false;
		}
		return true;
	}

	private static boolean isValidPhoneNumber(String phoneNumber) {
		// TODO Auto-generated method stub
		String price = String.valueOf(phoneNumber);
		Pattern phonePattern = Pattern.compile("[6-9][0-9]{9}$");
		Matcher phoneMatcher = phonePattern.matcher(price);

		return phoneMatcher.matches();
		
	}

}

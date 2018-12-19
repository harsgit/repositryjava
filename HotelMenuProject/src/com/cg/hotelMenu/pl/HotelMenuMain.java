package com.cg.hotelMenu.pl;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.hotelMenu.bean.Customer;
import com.cg.hotelMenu.bean.Dish;
import com.cg.hotelMenu.exception.HotelMenuException;
import com.cg.hotelMenu.service.HotelMenuServiceImpl;
import com.cg.hotelMenu.service.IHotelMenuService;

public class HotelMenuMain {
	static Scanner sc = new Scanner(System.in);
	static IHotelMenuService HotelMenuService = null;
	static HotelMenuServiceImpl hotelMenuServiceImpl = null;
	static Logger logger = Logger.getRootLogger();

	public static void main(String[] args) throws HotelMenuException {
		PropertyConfigurator.configure("resources//log4j.properties");
		Customer customer = null;
		Dish dish = null;
		String dishName = null;
		String customerId = null;
		String customerName = null;
		
		int option = 0;
		while (true) {
			System.out.println();
			System.out.println();
			System.out.println("Hotel xyz");
			System.out.println("====================");
			System.out.println("1.Add Dish");
			System.out.println("2.view details of dish");
			System.out.println("3.Display Menu");
			System.out.println("4.Update Menu");
			System.out.println("5.Book a Room");
			System.out.println("6.CheckOut/cancel Room");
			System.out.println("7.exit");
			System.out.println("---------------------");
			System.out.println("select an option");
			try {
				option = sc.nextInt();
				switch (option) {
				case 1:
					while (dish == null) {
						dish = populateDish();
					}
					try {

						HotelMenuService = new HotelMenuServiceImpl();
						dishName = HotelMenuService.addDish(dish);
						System.out.println(dish);
					
						
					} finally {
						dishName = null;
						HotelMenuService = null;
						dish = null;
					}
					break;

				case 2:
					System.out.println(" Enter DishName");
					dishName = sc.next();
					HotelMenuService = new HotelMenuServiceImpl();
					dish = HotelMenuService.viewDishDetails(dishName);
					System.out.println(dish);

					break;
				case 3:

					HotelMenuService = new HotelMenuServiceImpl();
					try {
						List<Dish> donorList = new ArrayList<Dish>();
						donorList = HotelMenuService.retriveAll();
						if (donorList != null) {
							Iterator<Dish> i = donorList.iterator();
							while (i.hasNext()) {
								//System.out.println(i.next());
								i.next();
							}
						} else {
							System.out.println("There is no Menu for the Day ");
						}
					} catch (Exception e) {
						e.getStackTrace();

					}
					break;
				case 4:
					System.out.println(" Enter DishName");
					dishName = sc.next();
					System.out.println("Enter dishPrice");
					int dishPrice = sc.nextInt();
					HotelMenuService = new HotelMenuServiceImpl();
					dish = HotelMenuService.updateDetails(dishPrice, dishName);
					System.out.println(dish);
					break;
				case 5:
					int choice = 0;
					HotelMenuService = new HotelMenuServiceImpl();
					boolean x = HotelMenuService.roomStaus();
					if (x == true) {
						choice = 1;

					} else
						choice = 2;

					switch (choice) {
					case 1:
						System.out.println("Please Enter Customer Deatils");
						while (customer == null) {
							customer = populateCustomer();
						}
						try {

							HotelMenuService = new HotelMenuServiceImpl();
							customerId = HotelMenuService.addCustomerDetails(customer);
							System.out.println(customer);
						} finally {
							customerId = null;
							HotelMenuService = null;
							customer = null;
						}

						break;

					case 2:
						System.out.println("Sorry no rooms are vacant");

					default:
						break;
					}

					break;
				case 6:

					System.out.println("enter Customer PhoneNumber");
					String PhoneNumber = sc.next();

					try {
						HotelMenuService = new HotelMenuServiceImpl();
						customerName = HotelMenuService.deleteCustomer(PhoneNumber);

						System.out.println("Customer Details has been successfully deleted");

					} finally {
						customerId = null;
						HotelMenuService = null;

					}

					break;
				case 7:
					System.exit(0);
					break;

				default:
					break;
				}
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
	}
	/*
	 * This function will be called by main and will return  validated Customer Details
	 * object OR null if details are invalid
	 */

	private static Customer populateCustomer() {
		Customer customer = new Customer();
		System.out.println("Enter the details");
		System.out.println("Enter Customer name");
		customer.setCustName(sc.next());
		System.out.println("Enter Customer Phone Number");

		customer.setPhoneNumber(sc.next());

		try {

			if (HotelMenuServiceImpl.validateCustomer(customer)) {
				return customer;
			} else {
				return null;
			}

		} catch (HotelMenuException hotelMenuException) {
			logger.error("exception occured", hotelMenuException);
			System.err.println(hotelMenuException.getMessage() + "\n Try again..");
		}
		System.exit(0);

		return customer;
	}
	/*
	 * This function will be called by main and will return  validated Dish Details
	 * object OR null if details are invalid
	 */
	private static Dish populateDish() {
		Dish dish = new Dish();
		System.out.println("Enter the details");
		System.out.println("enter dish name");
		dish.setDishName(sc.next());
		System.out.println("enter dishPrice");

		dish.setDishPrice(sc.nextInt());

		try {

			if (HotelMenuServiceImpl.validateDish(dish)) {
				return dish;
			} else {
				return null;
			}

		}  catch (HotelMenuException hotelMenuException) {
			logger.error("exception occured", hotelMenuException);
			System.err.println(hotelMenuException.getMessage() + "\n Try again..");
		}
		System.exit(0);

		return dish;
	}
}
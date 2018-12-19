package com.cg.hotelMenu.dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.hotelMenu.bean.Customer;
import com.cg.hotelMenu.bean.Dish;

public class HotelMenuDaoImplTest {

	static HotelMenuDaoImpl dao;
	static Dish dish;
	static Customer customer;

	@BeforeClass
	public static void initialize() {
		System.out.println("in before class");
		dao = new HotelMenuDaoImpl();
		 dish= new Dish();
		 customer=new Customer();
	}
	@Test
	public void testAddDish() throws NumberFormatException, ClassNotFoundException, IOException, SQLException {
		dish.setDishName("Puliogare");
		dish.setDishPrice(35);
		assertEquals(dish,dish);
	}

	@Test
	public void testViewDishDetails() throws ClassNotFoundException, IOException, SQLException {
		assertNotNull(dao.viewDishDetails("Roti"));
	}

	@Test
	public void testRetriveAll() throws ClassNotFoundException, IOException, SQLException {
		assertNotNull(dao.retriveAll());
	}

	@Test
	public void testUpdateDetails() {
		//fail("Not yet implemented");
		dish.setDishName("Puliogare");
		dish.setDishPrice(25);
		assertEquals(dish,dish);
	}

	@Test
	public void testRoomStaus() throws ClassNotFoundException, IOException, SQLException {
		//fail("Not yet implemented");
		assertEquals(true,dao.roomStaus());
	}

	@Test
	public void testAddCustomerDetails()  throws ClassNotFoundException, IOException, SQLException{
		//customer.setCustomerId("106");
		customer.setCustName("Ramesh");
		customer.setPhoneNumber("8675123110");
		
		assertEquals(customer,customer);
		
	}

	@Test
	public void testDeleteCustomer() throws ClassNotFoundException, IOException, SQLException {
		//fail("Not yet implemented");
		
		assertNull(dao.deleteCustomer("8675123110"));
	}

}

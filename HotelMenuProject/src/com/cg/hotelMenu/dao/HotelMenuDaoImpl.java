package com.cg.hotelMenu.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.hotelMenu.bean.Customer;
import com.cg.hotelMenu.bean.Dish;
import com.cg.hotelMenu.exception.HotelMenuException;
import com.cg.hotelMenu.util.DbConnection;

public class HotelMenuDaoImpl implements IHotelMenuDao {

	Logger logger=Logger.getRootLogger();
	 public HotelMenuDaoImpl() {
		PropertyConfigurator.configure("resources//log4j.properties");
		// TODO Auto-generated constructor stub
	}
	
	
	//------------------------ 1. HotelMenu Application --------------------------
		/*******************************************************************************************************
		 - Function Name	:	addDish(Dish dish)
		 - Input Parameters	:	Dish dish
		 - Return Type		:	String
		 - Throws			:  	ClassNotFoundException, IOException, SQLException, HotelMenuException
		 - Author			:	S,Harshitha
		 - Creation Date	:	18/12/2018
		 - Description		:	Adding Dish Details
		 ********************************************************************************************************/
	@Override
	public String addDish(Dish dish) throws ClassNotFoundException, IOException, SQLException, HotelMenuException {
		// TODO Auto-generated method stub
		Connection connection = DbConnection.getConnection();
		PreparedStatement preparedStatement = null;
		String dishName = null;
		int queryResult=0;

		try {

			preparedStatement = connection.prepareStatement(QueryMapper.insert_Query);

			preparedStatement.setString(1, dish.getDishName());

			preparedStatement.setInt(2, dish.getDishPrice());

			queryResult=preparedStatement.executeUpdate();
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(queryResult==0)
		{
			logger.error("Insertion failed ");
			throw new HotelMenuException("Inserting Dish details failed ");

		}
		else
		{
			logger.info("Dish details added successfully:");
			return dishName;
		}

		//return dishName;
	}
	//------------------------ 1. HotelMenu Application --------------------------
			/*******************************************************************************************************
			 - Function Name	:	viewDishDetails(String dishName)
			 - Input Parameters	:	String dishName
			 - Return Type		:	Dish
			 - Throws			:  	ClassNotFoundException, IOException, SQLException, HotelMenuException
			 - Author			:	S,Harshitha
			 - Creation Date	:	18/12/2018
			 - Description		:	view Dish Details
			 ********************************************************************************************************/
	@Override
	public Dish viewDishDetails(String dishName) throws ClassNotFoundException, IOException, SQLException {
		Dish dish = null;
		Connection connection = DbConnection.getConnection();
		

		ResultSet resultset = null;
		//Statement st = connection.createStatement();
		PreparedStatement preparedStatement = null;
		preparedStatement = connection.prepareStatement(QueryMapper.viewDishDetails_Query);
		preparedStatement.setString(1, dishName);
		resultset=preparedStatement.executeQuery();
		
		while (resultset.next()) {
			dish = new Dish();
			dish.setDishName(resultset.getString(1));
			dish.setDishPrice(resultset.getInt(2));
		}
		if( dish != null)
		{
			logger.info("Record Found Successfully");
			return dish;
		}
		else
		{
			logger.info("Record not Found");
			return null;
		}
		//return dish;
	}
	//------------------------ 1. HotelMenu Application --------------------------
	/*******************************************************************************************************
	 - Function Name	:	retriveAll()
	 - Input Parameters	:	
	 - Return Type		:	List
	 - Throws			:  	ClassNotFoundException, IOException, SQLException, HotelMenuException
	 - Author			:	S,Harshitha
	 - Creation Date	:	18/12/2018
	 - Description		:	 return Menu
	 ********************************************************************************************************/

	@Override
	public List retriveAll() throws ClassNotFoundException, IOException, SQLException {
		Connection con = DbConnection.getConnection();
		int dishCount = 0;

		PreparedStatement ps = null;
		ResultSet resultset = null;

		List<Dish> dishList = new ArrayList<Dish>();
		try {
			ps = con.prepareStatement(QueryMapper.retrieveAll_Query);
			resultset = ps.executeQuery();
			System.out.println("|-------------------+-------------------------|");
			System.out.println("DishName\t+DishPrice\t");
			System.out.println("|-------------------+-------------------------|");
			while (resultset.next()) {
				Dish dish = new Dish();
				dish.setDishName(resultset.getString(1));
				dish.setDishPrice(resultset.getInt(2));
				dishList.add(dish);
				System.out.println(resultset.getString(1)+"\t\t"+resultset.getString(2)+"\t");
				dishCount++;
			}
			System.out.println("|-------------------+-------------------------|");
		} catch (SQLException sqlException) {

			logger.error(sqlException.getMessage());
			System.out.println(sqlException);
		}
		if( dishCount != 0)
		{
			logger.info("Records Found Successfully");
			return dishList;
		}
		else
		{
			logger.info("No records found");
			return null;
		}
		//return dishList;
	}
	//------------------------ 1. HotelMenu Application --------------------------
		/*******************************************************************************************************
		 - Function Name	:	 updateDetails(int dishPrice, String dishName)
		 - Input Parameters	:	int dishPrice, String dishName
		 - Return Type		:	Dish
		 - Throws			:  	ClassNotFoundException, IOException, SQLException, HotelMenuException
		 - Author			:	S,Harshitha
		 - Creation Date	:	18/12/2018
		 - Description		:	 updateDetails of Dish
		 ********************************************************************************************************/
	@Override
	public Dish updateDetails(int dishPrice, String dishName)
			throws ClassNotFoundException, IOException, SQLException, HotelMenuException {
		Connection connection = DbConnection.getConnection();
		ResultSet resultset = null;
		Statement st = connection.createStatement();
		PreparedStatement preparedStatement = null;
		Dish dish = null;
		try {
			preparedStatement = connection.prepareStatement(QueryMapper.update_Query);
			preparedStatement.setString(2, dishName);
			preparedStatement.setInt(1, dishPrice);
			int i = preparedStatement.executeUpdate();
			preparedStatement.close();
			preparedStatement = connection.prepareStatement(QueryMapper.viewDishDetails_Query);
			preparedStatement.setString(1, dishName);
			resultset = preparedStatement.executeQuery();
			while (resultset.next()) {
				dish = new Dish();
				dish.setDishName(resultset.getString(1));
				dish.setDishPrice(resultset.getInt(2));
				return dish;

			}

		} catch (SQLException e) {
			
			throw new HotelMenuException("Error in closing db connection");

		} finally {
			try {
				resultset.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				
				throw new HotelMenuException("Error in closing db connection");

			}
		}
		return null;
	}
	//------------------------ 1. HotelMenu Application --------------------------
			/*******************************************************************************************************
			 - Function Name	:	 roomStaus()
			 - Input Parameters	:	
			 - Return Type		:	boolean
			 - Throws			:  	ClassNotFoundException, IOException, SQLException
			 - Author			:	S,Harshitha
			 - Creation Date	:	18/12/2018
			 - Description		:	 status Of room
			 ********************************************************************************************************/
	@Override
	public boolean roomStaus() throws ClassNotFoundException, IOException, SQLException {
		try {

			Connection connection = DbConnection.getConnection();
			ResultSet resultset = null;
			Statement st = connection.createStatement();
			int count = 0;
			resultset = st.executeQuery(QueryMapper.count_rows);
			
			while (resultset.next()) {
				count = resultset.getInt(1);
				if (count <= 10)
					return true;
			}
			return false;
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return false;

	}
	//------------------------ 1. HotelMenu Application --------------------------
	/*******************************************************************************************************
	 - Function Name	:	 addCustomerDetails(Customer customer)
	 - Input Parameters	:	Customer customer
	 - Return Type		:	String
	 - Throws			:  	ClassNotFoundException, IOException, SQLException,HotelMenuException
	 - Author			:	S,Harshitha
	 - Creation Date	:	18/12/2018
	 - Description		:	addCustomerDetails
	 ********************************************************************************************************/
	@Override
	public String addCustomerDetails(Customer customer) throws ClassNotFoundException, IOException, SQLException, HotelMenuException {
		// TODO Auto-generated method stub
		Connection connection = DbConnection.getConnection();
		Statement statement = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		String customerId = null;
		int queryResult = 0;

		try {

			preparedStatement = connection.prepareStatement(QueryMapper.insertIntoCustomer_Query);

			preparedStatement.setString(1, customer.getCustName());

			preparedStatement.setString(2, customer.getPhoneNumber());
			// preparedStatement.setString(3, customer.getAdharNumber());
			preparedStatement.executeUpdate();
			statement = connection.createStatement();
			resultset = statement.executeQuery( QueryMapper.max_id);
			while (resultset.next()) {
				customer.setCustomerId(resultset.getString(1));
				
			}
			return customerId;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(queryResult==0)
		{
			logger.error("Insertion of customer details failed ");
			throw new HotelMenuException("Inserting Customer details failed ");

		}
		else
		{
			logger.info("Customer details added successfully:");
			return customerId;
		}

		//return null;
	}
	//------------------------ 1. HotelMenu Application --------------------------
		/*******************************************************************************************************
		 - Function Name	:	deleteCustomer(String PhoneNumber)
		 - Input Parameters	:	String PhoneNumber
		 - Return Type		:	String
		 - Throws			:  	ClassNotFoundException, IOException, SQLException,HotelMenuException
		 - Author			:	S,Harshitha
		 - Creation Date	:	18/12/2018
		 - Description		:	deleteCustomer
		 ********************************************************************************************************/
	@Override
	public String deleteCustomer(String PhoneNumber) throws ClassNotFoundException, IOException, SQLException {
		Connection con = DbConnection.getConnection();
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		String customerName = null;
		
		try {

			prepareStatement = con.prepareStatement(QueryMapper.delete_Query);

			prepareStatement.setString(1, PhoneNumber);
			prepareStatement.executeQuery();

			Statement st = con.createStatement();
			resultSet = prepareStatement.executeQuery(QueryMapper.viewCustomerDetails_Query);
			while (resultSet.next()) {

				customerName = resultSet.getString(1);

			}
			return customerName;

			
			

		} catch (SQLException sql) {
			
			sql.printStackTrace();
		}

		return null;
	}

}

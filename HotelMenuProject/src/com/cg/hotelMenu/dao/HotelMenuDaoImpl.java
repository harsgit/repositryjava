package com.cg.hotelMenu.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.cg.hotelMenu.bean.Customer;
import com.cg.hotelMenu.bean.Dish;
import com.cg.hotelMenu.exception.HotelMenuException;
import com.cg.hotelMenu.util.DbConnection;

public class HotelMenuDaoImpl implements IHotelMenuDao {

	@Override
	public String addDish(Dish dish) throws ClassNotFoundException, IOException, SQLException {
		// TODO Auto-generated method stub
		Connection connection = DbConnection.getConnection();
		PreparedStatement preparedStatement = null;
		String dishName = null;
		

		try {

			preparedStatement = connection.prepareStatement("Insert into HotelMenu values(?,?)");

			preparedStatement.setString(1, dish.getDishName());

			preparedStatement.setInt(2, dish.getDishPrice());

			preparedStatement.executeUpdate();
			

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dishName;
	}

	@Override
	public Dish viewDishDetails(String dishName) throws ClassNotFoundException, IOException, SQLException {
		Dish dish = null;
		Connection connection = DbConnection.getConnection();

		ResultSet resultset = null;
		Statement st = connection.createStatement();
		PreparedStatement preparedStatement = null;
		resultset = preparedStatement.executeQuery("select * from HotelMenu where dish_Name=?");
		while (resultset.next()) {
			dish = new Dish();
			dish.setDishName(resultset.getString(1));
			dish.setDishPrice(resultset.getInt(2));
		}
		return dish;
	}

	@Override
	public List retriveAll() throws ClassNotFoundException, IOException, SQLException {
		Connection con = DbConnection.getConnection();
		int dishCount = 0;

		PreparedStatement ps = null;
		ResultSet resultset = null;

		List<Dish> dishList = new ArrayList<Dish>();
		try {
			ps = con.prepareStatement("select * from hotelMenu ");
			resultset = ps.executeQuery();
			System.out.println("|-------------------+-------------------------|");
			System.out.println("DishName\t+DishPrice\t");
			System.out.println("|-------------------+-------------------------|");
			while (resultset.next()) {
				Dish dish = new Dish();
				dish.setDishName(resultset.getString(1));
				dish.setDishPrice(resultset.getInt(2));
				dishList.add(dish);
				System.out.println("|"+resultset.getString(1)+"\t\t"+resultset.getString(2)+"\t"+"|");
				dishCount++;
			}
			System.out.println("|-------------------+-------------------------|");
		} catch (SQLException sqlException) {

			
			System.out.println(sqlException);
		}
		return dishList;
	}

	@Override
	public Dish updateDetails(int dishPrice, String dishName)
			throws ClassNotFoundException, IOException, SQLException, HotelMenuException {
		Connection connection = DbConnection.getConnection();
		ResultSet resultset = null;
		Statement st = connection.createStatement();
		PreparedStatement preparedStatement = null;
		Dish dish = null;
		try {
			preparedStatement = connection.prepareStatement("update  HotelMenu  SET dish_price=? where dish_Name= ?");
			preparedStatement.setString(2, dishName);
			preparedStatement.setInt(1, dishPrice);
			int i = preparedStatement.executeUpdate();
			System.out.println(dishName);
			resultset = preparedStatement.executeQuery("select * from HotelMenu where dish_Name=?");

			while (resultset.next()) {
				dish = new Dish();
				dish.setDishName(resultset.getString(1));
				dish.setDishPrice(resultset.getInt(2));
				
				return dish;

			}

		} catch (SQLException e) {
			// System.out.println(e);
			throw new HotelMenuException("Error in closing db connection");

		} finally {
			try {
				resultset.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				// System.out.println(e);
				throw new HotelMenuException("Error in closing db connection");

			}
		}
		return null;
	}

	@Override
	public boolean roomStaus() throws ClassNotFoundException, IOException, SQLException {
		try {

			Connection connection = DbConnection.getConnection();
			ResultSet resultset = null;
			Statement st = connection.createStatement();
			int count = 0;
			resultset = st.executeQuery("select count(*) AS total from customer");
			
			while (resultset.next()) {
				count = resultset.getInt(1);
				if (count <= 10)
					return true;
			}
			return false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public String addCustomerDetails(Customer customer) throws ClassNotFoundException, IOException, SQLException {
		// TODO Auto-generated method stub
		Connection connection = DbConnection.getConnection();
		Statement statement = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		String customerId = null;
		int queryResult = 0;

		try {

			preparedStatement = connection.prepareStatement("Insert into Customer values(custId.nextval,?,?)");

			preparedStatement.setString(1, customer.getCustName());

			preparedStatement.setString(2, customer.getPhoneNumber());
			// preparedStatement.setString(3, customer.getAdharNumber());
			preparedStatement.executeUpdate();
			statement = connection.createStatement();
			resultset = statement.executeQuery("select max(cust_Id) from customer");
			while (resultset.next()) {
				customer.setCustomerId(resultset.getString(1));
				
			}
			return customerId;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public String deleteCustomer(String PhoneNumber) throws ClassNotFoundException, IOException, SQLException {
		Connection con = DbConnection.getConnection();
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		String customerName = null;
		
		try {

			prepareStatement = con.prepareStatement("delete from customer where cust_phno=?");

			prepareStatement.setString(1, PhoneNumber);
			prepareStatement.executeUpdate();

			Statement st = con.createStatement();
			resultSet = prepareStatement.executeQuery("select cust_name from customer where cust_phno=?");
			while (resultSet.next()) {

				customerName = resultSet.getString(1);

			}
			return customerName;

			

		} catch (SQLException sql) {
			System.out.println(sql);
			sql.printStackTrace();
		}

		return customerName;
	}

}

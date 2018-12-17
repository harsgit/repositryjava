/*package com.cg.hotelMenu.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cg.hotelMenu.util.DbConnection;

public class Dummy {
public static void	updateDetails1(int dishPrice,String dishName) throws ClassNotFoundException, IOException, SQLException{
	Connection con;
		con = DbConnection.getConnection();
	
	int i=0;
	PreparedStatement ps;
	try {
		ps = con.prepareStatement("select dish_name from hotelMenu  where dish_price=100");
		//ps.setInt(1, dishPrice);
		//ps.setString(1, dishName);
		System.out.println(ps.executeQuery().next());
		if(ps.executeQuery().next()){
			System.out.println("it done bro!!!");
		}
		
	} catch (SQLException e) {
         System.out.println(e);
		
	}

	
	
}
}*/

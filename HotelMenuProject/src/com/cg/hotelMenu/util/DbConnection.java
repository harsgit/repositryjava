package com.cg.hotelMenu.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnection {
	public static Connection getConnection() throws IOException, SQLException, ClassNotFoundException {
		try {

			FileInputStream fis = new FileInputStream("resources/MyProp.Properties");
			Properties p = new Properties();
			p.load(fis);
			String driver1 = p.getProperty("driver");
			String url = p.getProperty("url");
			String username = p.getProperty("username");
			String password = p.getProperty("password");
			Class.forName(driver1);
			Connection conn = DriverManager.getConnection(url, username, password);
			return conn;

		} catch (FileNotFoundException e) {

			System.out.println(e);
		}
		// return null;
		return null;

	}

}

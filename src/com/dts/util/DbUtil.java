package com.dts.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbUtil {

	private static String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static String DB_URL = "jdbc:mysql://localhost:3306/dts";
	private static String DB_USER = "root";
	private static String DB_PASSWORD = "root";
	
	private static Connection connection;
	private DbUtil(){}
	
	static{
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConnection(){
		return connection;
	}

	
	public static ResultSet getResultSet(String query) throws SQLException {
		return getConnection().createStatement().executeQuery(query);
	}

	public static void executeUpdate(String query) throws SQLException {
		getConnection().createStatement().executeUpdate(query);
	}
	
}

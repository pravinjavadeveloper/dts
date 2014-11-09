package com.dts.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dts.model.User;
import com.dts.util.DbUtil;

public class UserService {

	public static boolean isUserAlreadyExists(String user_name) {
		String sql = "select * from user where username='"+user_name+"';";
		Connection connection = DbUtil.getConnection();
		boolean isExistingUser = false;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			if(resultSet.next()) isExistingUser = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isExistingUser;
	}

	public static void registerUser(String fist_name, String last_name, String user_name, String password,
			String designation, String qualification, String address, String email, String contactNumber) {
		
		String insert_sql = "insert into user (first_name, last_name, username, password, qualificaiton, designation, address, email_address, contact_number) "
				+ "values ('"+fist_name+"','"+last_name+"','"+user_name+"','"+password+"','"+qualification+"','"+designation+"','"+address+"','"+email+"','"+contactNumber+"');";
		
		Connection connection = DbUtil.getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(insert_sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static User authenticateUser(String user_name, String password) {
		User user = null;
		String sql = "select first_name, last_name, username, password, qualificaiton, designation, address, email_address, contact_number"
				+ " from user where username='"+user_name+"' and password='"+password+"';";
		Connection connection = DbUtil.getConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			if(resultSet.next()){
				user = new User();
				user.setAddress(resultSet.getString("address"));
				user.setContactNumber(resultSet.getString("contact_number"));
				user.setDesignation(resultSet.getString("designation"));
				user.setEmail(resultSet.getString("email_address"));
				user.setFist_name(resultSet.getString("first_name"));
				user.setLast_name(resultSet.getString("last_name"));
				user.setPassword(resultSet.getString("password"));
				user.setQualification(resultSet.getString("qualificaiton"));
				user.setUser_name(resultSet.getString("username"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

}

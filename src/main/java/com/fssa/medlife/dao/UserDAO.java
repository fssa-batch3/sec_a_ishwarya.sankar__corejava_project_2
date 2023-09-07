package com.fssa.medlife.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.medlife.model.User;
import com.fssa.medlife.service.*;
import com.fssa.medlife.utils.ConnectionUtil;

public class UserDAO {
	
   
	public boolean register(User user) throws SQLException {
	   
	    String query = "INSERT INTO user (email, userName, password, phone_number, type) VALUES ( ?, ?, ?, ?, ?)";
	    
	    try (Connection connection = ConnectionUtil.getConnection(); 
	        PreparedStatement pmt = connection.prepareStatement(query)) {
	        
	        pmt.setString(1, user.getEmail());
	        pmt.setString(2, user.getUsername());
	        pmt.setString(3, user.getPassword());
	        pmt.setString(4, user.getPhonenumber());
	        pmt.setString(5, user.getType());
	        
	        int rows = pmt.executeUpdate();
	        return rows == 1; 
	    }
	}
	

	public boolean isEmailExists(String email) throws SQLException {
	    String query = "SELECT * FROM user WHERE email = ?";
	    
	    try (Connection connection = ConnectionUtil.getConnection();
	        PreparedStatement pmt = connection.prepareStatement(query)) {
	        
	        pmt.setString(1, email);
	        
	        ResultSet rs = pmt.executeQuery();
	        return rs.next(); 
	    }
	}

	public boolean login(User password, String email) throws SQLException {
	    String query = "SELECT * FROM user WHERE email = ? AND password = ?";
	    
	    try (Connection connection = ConnectionUtil.getConnection(); 
	        PreparedStatement pmt = connection.prepareStatement(query)) {
	        
	        pmt.setString(1, email); 
	        pmt.setString(2, password.getPassword());
	        
	        try (ResultSet rs = pmt.executeQuery()) {
	            return rs.next(); 
	        }
	    }
	}
	
	public static User FindUserByIdEmail(String email) {
		User user1 = new User();
		String query = "SELECT * FROM user WHERE email= ?";
		try(Connection connection = ConnectionUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(query)){
        		statement.setString(1,email);
		try(ResultSet resultset = statement.executeQuery()){
		if(resultset.next()) {
		   user1.setUserId(resultset.getInt("userId"));
				
			       user1.setUsername ( resultset.getString("userName"));
			       user1.setEmail(resultset.getString("email"));
			      
			       user1.setPassword  (resultset.getString("password"));
			        user1.setType ( resultset.getString("type"));
			        user1.setPhonenumber (resultset.getString("phone_number"));
               
			}
		
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return user1;
}
	
	public boolean updateUser(User user) throws SQLException {
	    // Define the SQL query to update the 'username' and 'phonenumber' columns for a user based on email
	    String query = "UPDATE USER SET username=?, phonenumber=? WHERE email=?";
	    
	    try (Connection connection = ConnectionUtil.getConnection();
	        PreparedStatement pmt = connection.prepareStatement(query)) {
	        
	        // Set the values for the placeholders in the SQL query
	        pmt.setString(1, user.getUsername());
	        pmt.setString(2, user.getPhonenumber());
	        pmt.setString(3, user.getEmail());
	        
	        // Execute the SQL query and check the number of affected rows
	        int rows = pmt.executeUpdate();
	        return rows == 1; // Return true if one row was updated successfully
	    }
	}

	// Delete user based on email
	public boolean deleteUser(User user) throws SQLException {
	    // Define the SQL query to set the 'isDeleted' column to true for a user based on email
	    String query = "UPDATE user SET isDeleted = ? WHERE email = ?";
	    
	    try (Connection connection = ConnectionUtil.getConnection(); 
	        PreparedStatement pmt = connection.prepareStatement(query)) {
	        
	        // Set the values for the placeholders in the SQL query
	        pmt.setBoolean(1, true); 
	        pmt.setString(2, user.getEmail());
	        
	        // Execute the SQL query and check the number of affected rows
	        int rows = pmt.executeUpdate();
	        return rows == 1; // Return true if one row was updated successfully
	    }
	}

	
}

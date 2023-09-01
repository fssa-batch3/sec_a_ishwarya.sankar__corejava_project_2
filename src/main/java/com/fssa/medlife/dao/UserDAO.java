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
	    // Define the SQL query to insert a new user into the 'user' table
	    String query = "INSERT INTO user (email, userName, password, phone_number, type) VALUES ( ?, ?, ?, ?, ?)";
	    
	    try (Connection connection = ConnectionUtil.getConnection(); 
	        PreparedStatement pmt = connection.prepareStatement(query)) {
	        
	        // Set the values for the placeholders in the SQL query
	        pmt.setString(1, user.getEmail());
	        pmt.setString(2, user.getUsername());
	        pmt.setString(3, user.getPassword());
	        pmt.setString(4, user.getPhonenumber());
	        pmt.setString(5, user.getType());
	        
	        // Execute the SQL query and check the number of affected rows
	        int rows = pmt.executeUpdate();
	        return rows == 1; // Return true if one row was inserted successfully
	    }
	}

	// Method to check if a user with the given email exists in the database
	public boolean isEmailExists(String email) throws SQLException {
	    // Define the SQL query to select a user with the given email
	    String query = "SELECT * FROM user WHERE email = ?";
	    
	    try (Connection connection = ConnectionUtil.getConnection();
	        PreparedStatement pmt = connection.prepareStatement(query)) {
	        
	        // Set the value for the email placeholder in the SQL query
	        pmt.setString(1, email);
	        
	        // Execute the SQL query and check if a row is found
	        ResultSet rs = pmt.executeQuery();
	        return rs.next(); // If a row is found, the email exists
	    }
	}

	public boolean login(User user, String email) throws SQLException {
	    // Define the SQL query to select a user with the given email and password
	    String query = "SELECT * FROM user WHERE email = ? AND password = ?";
	    
	    try (Connection connection = ConnectionUtil.getConnection(); 
	        PreparedStatement pmt = connection.prepareStatement(query)) {
	        
	        // Set the values for the email and password placeholders in the SQL query
	        pmt.setString(1, email); 
	        pmt.setString(2, user.getPassword());
	        
	        try (ResultSet rs = pmt.executeQuery()) {
	            return rs.next(); // Return true if a matching user is found
	        }
	    }
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

package com.fssa.medlife.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.medlife.model.User;

public class UserDAO {
    // connect to database
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/backend", "root", "123456");
    }

    
	// Add new user to DB - Register
	public boolean register(User user) throws SQLException {

		String query = "INSERT INTO user (userId, email, userName, password, phoneNumber, type) VALUES (?, ?, ?, ?, ?, ?)";

		try (Connection connection = getConnection(); PreparedStatement pmt = connection.prepareStatement(query)) {
			pmt.setInt(1, user.getUserId()); // Set the userId during registration
			pmt.setString(2, user.getEmail());
			pmt.setString(3, user.getUsername());
			pmt.setString(4, user.getPassword());
			pmt.setString(5, user.getPhonenumber());
			pmt.setString(6, user.getType());
			int rows = pmt.executeUpdate();
			return rows == 1;
		}
	}

	// Method to check if a user with the given email exists in the database
	public boolean isEmailExists(String email) throws SQLException {
		String query = "SELECT * FROM user WHERE email = ?";
		try (Connection connection = getConnection(); PreparedStatement pmt = connection.prepareStatement(query)) {
			pmt.setString(1, email);
			ResultSet rs = pmt.executeQuery();
			return rs.next(); // If a row is found, the email exists
		}
	}

	public boolean login(User user, String email) throws SQLException {
		String query = "SELECT * FROM user WHERE email = ? AND password = ?";
		try (Connection connection = getConnection(); PreparedStatement pmt = connection.prepareStatement(query)) {
			pmt.setString(1, email); 
			pmt.setString(2, user.getPassword());
			try (ResultSet rs = pmt.executeQuery()) {
				return rs.next(); 
			}
		}
	}

	public boolean updateUser(User user) throws SQLException {
		String query = "UPDATE USER SET username=?, phonenumber=? WHERE email=?";
		try (Connection connection = getConnection(); PreparedStatement pmt = connection.prepareStatement(query)) {
			pmt.setString(1, user.getUsername());
			pmt.setString(2, user.getPhonenumber());
			pmt.setString(3, user.getEmail());
			int rows = pmt.executeUpdate();
			return rows == 1;
		}
	}

	// Delete user based on email
	public boolean deleteUser(User user) throws SQLException {
		String query = "UPDATE user SET isDeleted = ? WHERE email = ?";
		try (Connection connection = getConnection(); PreparedStatement pmt = connection.prepareStatement(query)) {
			pmt.setBoolean(1, true); 
			pmt.setString(2, user.getEmail());
			int rows = pmt.executeUpdate();
			return rows == 1;
		}
	}

	
}

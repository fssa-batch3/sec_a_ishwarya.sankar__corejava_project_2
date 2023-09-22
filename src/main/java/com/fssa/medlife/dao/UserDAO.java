package com.fssa.medlife.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.medlife.exception.DAOException;
import com.fssa.medlife.model.Appointment;
import com.fssa.medlife.model.Doctor;
import com.fssa.medlife.model.User;
import com.fssa.medlife.service.exception.ServiceException;
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

	public User login(String password, String email) throws SQLException {
		User user1 = new User();
		String query = "SELECT * FROM user WHERE email = ? AND password = ?";

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pmt = connection.prepareStatement(query)) {

			pmt.setString(1, email);
			pmt.setString(2, password);

			try (ResultSet resultset = pmt.executeQuery()) {
				if (resultset.next()) {
					user1.setUserId(resultset.getInt("userId"));

					user1.setUsername(resultset.getString("userName"));
					user1.setEmail(resultset.getString("email"));

					user1.setPassword(resultset.getString("password"));
					user1.setType(resultset.getString("type"));
					user1.setPhonenumber(resultset.getString("phone_number"));

				}
			}
		}
		return user1;
	}

	public String getUsernameByUserId(int userId) throws SQLException {
	    String query = "SELECT userName FROM user WHERE userId = ?";
	    String username = null;

	    try (Connection connection = ConnectionUtil.getConnection();
	         PreparedStatement pmt = connection.prepareStatement(query)) {

	        pmt.setInt(1, userId);

	        ResultSet rs = pmt.executeQuery();
	        if (rs.next()) {
	            username = rs.getString("userName");
	        }
	    }

	    return username;
	}

	public static User FindUserByIdEmail(String email) {
		User user1 = new User();
		String query = "SELECT * FROM user WHERE email= ?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, email);
			try (ResultSet resultset = statement.executeQuery()) {
				if (resultset.next()) {
					user1.setUserId(resultset.getInt("userId"));

					user1.setUsername(resultset.getString("userName"));
					user1.setEmail(resultset.getString("email"));

					user1.setPassword(resultset.getString("password"));
					user1.setType(resultset.getString("type"));
					user1.setPhonenumber(resultset.getString("phone_number"));

				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user1;
	}

	public boolean updateUser(User user) throws SQLException {
		// Define the SQL query to update the 'username' and 'phonenumber' columns for a
		// user based on email
		String query = "UPDATE USER SET userName=?, phone_number=? WHERE email=?";

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
		// Define the SQL query to set the 'isDeleted' column to true for a user based
		// on email
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

	/**
	 * Get a user by their email address.
	 *
	 * @param email The email address of the user to retrieve.
	 * @return The User object if found, or null if not found.
	 * @throws ServiceException If a database error occurs.
	 */
	public User getUserByEmail(String email) throws DAOException {
		String query = "SELECT * FROM user WHERE email = ?";
		User user = new User();

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, email);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				// Create a User object with the retrieved data
				user.setUserId(resultSet.getInt("UserId"));
				user.setUsername(resultSet.getString("userName"));
				user.setPassword(resultSet.getString("password"));
				user.setPhonenumber(resultSet.getString("phone_number"));
				user.setType(resultSet.getString("type"));

			}
		} catch (SQLException e) {
			throw new DAOException("Error fetching user by email: " + e.getMessage());
		}

		return user;
	}
	
	 public List<User> getAllUsers() throws SQLException, ClassNotFoundException {
	        List<User> users = new ArrayList<>();

	        String query = "SELECT * FROM user";
	        try (Connection connection = ConnectionUtil.getConnection();
	             PreparedStatement pmt = connection.prepareStatement(query);
	             ResultSet rs = pmt.executeQuery()) {

	            while (rs.next()) {
	            	User user = new User();
	            	user.setUserId( rs.getInt("userId"));
	                user.setEmail( rs.getString("email"));
	                user.setUsername( rs.getString("userName"));
	                user.setPassword( rs.getString("password"));
	                user.setPhonenumber(rs.getString("phone_number"));
	                user.setType( rs.getString("type"));
	                users.add(user);
	            }
	        }
	        return users;
	        }
	public List<Appointment> getAppointmentsForUser(int userId) throws DAOException {
	    List<Appointment> appointments = new ArrayList<>();
	    String query = "SELECT * FROM appointments WHERE user_id = ?";
	    
	    try (Connection connection = ConnectionUtil.getConnection();
	         PreparedStatement pmt = connection.prepareStatement(query)) {
	        pmt.setInt(1, userId);
	        try (ResultSet rs = pmt.executeQuery()) {
	            while (rs.next()) {
	                Appointment appointment = new Appointment();
	                User user = new User();
	                Doctor doctor = new Doctor();
	                user.setUserId(rs.getInt("user_id"));
	                doctor.setId(rs.getInt("doc_id"));
	                appointment.setUser(user);
	                appointment.setDoctor(doctor);
	                appointment.setAppointmentDate(rs.getDate("appointment_date").toString());
	                appointment.setBookingDate(rs.getDate("booking_date").toString());
	                appointment.setStatus(rs.getString("status"));
	                appointments.add(appointment);
	            }
	        }
	    } catch (SQLException e) {
	        throw new DAOException(e);
	    }
	    
	    return appointments;
	}






}

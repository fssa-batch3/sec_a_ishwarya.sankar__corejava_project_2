package com.fssa.medlife.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.fssa.medlife.exception.DAOException;
import com.fssa.medlife.model.Doctor;
import com.fssa.medlife.model.Medicine;

public class DoctorDAO {
	// connect to database
	public Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/backend", "root", "123456");
		return connection;
	}

	public static void close(Connection connection, PreparedStatement ps) throws DAOException {
		try {
			if (ps != null) {
				ps.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	//checking each  for null and closing it if it's not null and throws exception
	public static void closeAll(Connection connection, PreparedStatement ps, ResultSet rs) throws DAOException {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
	
	
	// read
	public void addDoctor(Doctor doctor) throws DAOException {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			String query = "INSERT INTO doctor (doctor_name, specialist,availability,Experience,image) VALUES (?, ?, ?, ?,?)";
			con = getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, doctor.getDoctorname());
			ps.setString(2, doctor.getSpecialist());
			ps.setInt(3, doctor.getAvailability());
			ps.setInt(4, doctor.getExperience());
			ps.setString(5, doctor.getImage());
			ps.executeUpdate();
			System.out.println("Doctor has been created successfully");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException(e);
		} finally {
			close(con,ps);
		}
	}

}

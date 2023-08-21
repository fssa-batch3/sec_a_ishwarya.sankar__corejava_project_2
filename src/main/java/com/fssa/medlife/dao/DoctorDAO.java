package com.fssa.medlife.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.fssa.medlife.model.Doctor;
import com.fssa.medlife.model.Medicine;

public class DoctorDAO {
	public Connection getConnection() throws SQLException {
		 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/backend", "root","123456");
		 return connection;
		}
	

	  public boolean addDoctor(Doctor doctor) throws SQLException {
	        try (Connection connection = getConnection()) {
	            String insertQuery = "INSERT INTO Doctor (doctorname, specialist, availability, Experience, image) VALUES (?, ?, ?, ?, ?);";
	            PreparedStatement pst = connection.prepareStatement(insertQuery);

	            pst.setString(1, doctor.getDoctorname());
	            pst.setString(2, doctor.getSpecialist());
	            pst.setInt(3, doctor.getAvailability());
	            pst.setInt(4, doctor.getExperience());
	            pst.setString(5, doctor.getImage());

	            int rows = pst.executeUpdate();

	            return rows == 1;
	        }
	    }
 
	    public List<Doctor> listDoctors() throws SQLException {
	        List<Doctor> doctors = new ArrayList<>();
	        String query = "SELECT * FROM Doctor";
	        try (Connection connection = getConnection();
	             PreparedStatement pstmt = connection.prepareStatement(query);
	             ResultSet resultSet = pstmt.executeQuery()) {
	            while (resultSet.next()) {
	                String doctorname = resultSet.getString("doctorname");
	                String specialist = resultSet.getString("specialist");
	                int availability = resultSet.getInt("availability");
	                int experience = resultSet.getInt("Experience");
	                String image = resultSet.getString("image");

	                Doctor doctor = new Doctor(doctorname, specialist, availability, experience, image);
	                doctors.add(doctor);
	            }
	            return doctors;
	        }
	    }
}

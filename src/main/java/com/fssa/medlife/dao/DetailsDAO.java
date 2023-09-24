package com.fssa.medlife.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.medlife.exception.DAOException;
import com.fssa.medlife.model.Doctordetails;
import com.fssa.medlife.utils.ConnectionUtil;

public class DetailsDAO {
	
	 public boolean addDoctorDetails(Doctordetails doctor) throws DAOException {
	        String query = "INSERT INTO doctor_details (Certification, Qualification, Specialist, Experience, Image, License, UserId) VALUES (?, ?, ?, ?, ?, ?, ?)";

	        try (Connection connection = ConnectionUtil.getConnection();
	             PreparedStatement pmt = connection.prepareStatement(query)) {
	            pmt.setString(1, doctor.getCertification());
	            pmt.setString(2, doctor.getQualification());
	            pmt.setString(3, doctor.getSpecialist());
	            pmt.setInt(4, doctor.getExperience());
	            pmt.setString(5, doctor.getImage());
	            pmt.setInt(6, doctor.getLicense());
	            pmt.setInt(7, doctor.getUserId());

	            int rows = pmt.executeUpdate();
	            return rows == 1;
	        } catch (SQLException e) {
	            throw new DAOException(e);
	        }
	    }
	   public List<Doctordetails> listDoctorDetails() throws DAOException {
	        List<Doctordetails> doctorDetailsList = new ArrayList<>();

	        String query = "SELECT * FROM doctor_details";

	        try (Connection connection = ConnectionUtil.getConnection();
	             PreparedStatement pmt = connection.prepareStatement(query);
	             ResultSet resultSet = pmt.executeQuery()) {

	            while (resultSet.next()) {
	                int license = resultSet.getInt("License");
	                String certification = resultSet.getString("Certification");
	                String qualification = resultSet.getString("Qualification");
	                String specialist = resultSet.getString("Specialist");
	                int experience = resultSet.getInt("Experience");
	                String image = resultSet.getString("Image");
	                int userId = resultSet.getInt("UserId");

	                Doctordetails doctor = new Doctordetails(license, certification, qualification, specialist, experience,
	                        image, userId);

	                doctorDetailsList.add(doctor);
	            }
	        } catch (SQLException e) {
	            throw new DAOException(e);
	        }

	        return doctorDetailsList;
	    }
	
}

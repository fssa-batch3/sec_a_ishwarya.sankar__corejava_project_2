package com.fssa.medlife.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.medlife.exception.DAOException;
import com.fssa.medlife.model.Doctordetails;
import com.fssa.medlife.model.User;
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

	public List<Doctordetails> listDoctorDetails(int id) throws DAOException {
		List<Doctordetails> doctorDetailsList = new ArrayList<>();

		String sql = "SELECT dd.Specialist, dd.Experience, dd.Image, u.userName FROM doctor_details dd INNER JOIN user u ON dd.UserId = u.userId WHERE u.userId= ?";

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
			System.out.println(id + "inner");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String specialist = resultSet.getString("Specialist");
				int experience = resultSet.getInt("Experience");
				String image = resultSet.getString("Image");
				String userName = resultSet.getString("userName");
				Doctordetails doctorDetails = new Doctordetails();
				doctorDetails.setSpecialist(specialist);
				doctorDetails.setExperience(experience);
				doctorDetails.setImage(image);
				User user = new User();
				user.setUsername(userName);
				doctorDetails.setUser(user);
				doctorDetailsList.add(doctorDetails);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException(e);
		}

		return doctorDetailsList;
	}

	public List<Doctordetails> listDoctorDetailsByUserId(int userId) throws DAOException {
		List<Doctordetails> doctorDetailsList = new ArrayList<>();

		String query = "SELECT * FROM doctor_details WHERE UserId = ?";

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pmt = connection.prepareStatement(query)) {
			pmt.setInt(1, userId);
			ResultSet resultSet = pmt.executeQuery();

			while (resultSet.next()) {
				int license = resultSet.getInt("License");
				String certification = resultSet.getString("Certification");
				String qualification = resultSet.getString("Qualification");
				String specialist = resultSet.getString("Specialist");
				int experience = resultSet.getInt("Experience");
				String image = resultSet.getString("Image");

				Doctordetails doctor = new Doctordetails(license, certification, qualification, specialist, experience,
						image, userId);

				doctorDetailsList.add(doctor);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}

		return doctorDetailsList;
	}

	public boolean isUserIdPresent(int userId) {
		String query = "SELECT UserId FROM doctor_details WHERE UserId = ?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setInt(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			return resultSet.next();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}

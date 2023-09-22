package com.fssa.medlife.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.Utilities;

import com.fssa.medlife.exception.DAOException;
import com.fssa.medlife.model.Appointment;
import com.fssa.medlife.model.Doctor;
import com.fssa.medlife.model.User;
import com.fssa.medlife.utils.ConnectionUtil;


public class DoctorDAO {

	// connect to database
	 
    public boolean addDoctor(Doctor doctor) throws DAOException {
    	
    	
        int rows = 0;
        String query = "INSERT INTO doctor (doctor_name, specialist, start_time, end_time, Experience, image,userId,doc_email) VALUES (?, ?, ?, ?, ?, ?,?,?)";
        try (Connection connection =ConnectionUtil.getConnection();
             PreparedStatement pmt = connection.prepareStatement(query)) {

            pmt.setString(1, doctor.getDoctorname());
            pmt.setString(2, doctor.getSpecialist());
            pmt.setString(3, doctor.getStartTime());
            pmt.setString(4, doctor.getEndtime());
            pmt.setInt(5, doctor.getExperience());
            pmt.setString(6, doctor.getImage());
            pmt.setInt(7,doctor.getUserId());
            pmt.setString(8,doctor.getEmail());

            rows = pmt.executeUpdate();
        }
catch(SQLException e){
	throw new DAOException(e);
	
}
        return rows == 1;
    }

    public List<Doctor> getAllDoctors() throws SQLException, ClassNotFoundException {
        List<Doctor> doctors = new ArrayList<>();

        String query = "SELECT * FROM doctor";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pmt = connection.prepareStatement(query);
             ResultSet rs = pmt.executeQuery()) {

            while (rs.next()) {
                String doctorName = rs.getString("doctor_name");
                String specialist = rs.getString("specialist");
                String startTime = rs.getString("start_time");
                String endTime = rs.getString("end_time");
                int experience = rs.getInt("Experience");
                String image = rs.getString("image");
                int id = rs.getInt("id");
                Doctor doctor = new Doctor(doctorName, specialist, startTime, endTime, experience, image);
                doctor.setId(id);
                doctors.add(doctor);
                
            }
        }

        return doctors;
    }

    public boolean updateDoctor(Doctor doctor, int id) throws DAOException {
        String query = "UPDATE doctor SET doctor_name=?, specialist=?, start_time=?, end_time=?, Experience=?, image=? WHERE id=?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pmt = connection.prepareStatement(query)) {
            pmt.setString(1, doctor.getDoctorname());
            pmt.setString(2, doctor.getSpecialist());
            pmt.setString(3, doctor.getStartTime());
            pmt.setString(4, doctor.getEndtime());
            pmt.setInt(5, doctor.getExperience());
            pmt.setString(6, doctor.getImage());
            pmt.setInt(7, id); // Set the value for the id parameter

            int rows = pmt.executeUpdate();

            return rows == 1;
        }
            catch (SQLException e) {
    	        throw new DAOException (e);
    	    }
    }



    public boolean deleteDoctor(String doctorName) throws SQLException, ClassNotFoundException {
        String query = "DELETE FROM doctor WHERE doctor_name = ?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pmt = connection.prepareStatement(query)) {
            pmt.setString(1, doctorName);

            int rows = pmt.executeUpdate();

            return rows == 1;
        }
    }
    
    public List<Doctor> searchDoctorsByName(String name) throws DAOException {
        List<Doctor> doctors = new ArrayList<>();
        String query = "SELECT * FROM doctor WHERE doctor_name LIKE ?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pmt = connection.prepareStatement(query)) {
            pmt.setString(1, "%" + name + "%"); // Use the '%' wildcard to match any part of the name
            try (ResultSet resultSet = pmt.executeQuery()) {
                while (resultSet.next()) {
                    Doctor doctor = new Doctor();
                    doctor.setId(resultSet.getInt("id"));
                    doctor.setDoctorname(resultSet.getString("doctor_name"));
                    doctor.setSpecialist(resultSet.getString("specialist"));
                    doctor.setStartTime(resultSet.getString("start_time"));
                    doctor.setEndtime(resultSet.getString("end_time"));
                    doctor.setExperience(resultSet.getInt("Experience"));
                    doctor.setImage(resultSet.getString("image"));
                    doctors.add(doctor);
                }
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return doctors;
    }

    
    
    public Doctor findDoctorById(int id) throws DAOException {
        String query = "SELECT * FROM doctor WHERE id = ?";
        Doctor doctor = null;

        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pmt = connection.prepareStatement(query)) {

            pmt.setInt(1, id);

            try (ResultSet resultSet = pmt.executeQuery()) {
                if (resultSet.next()) {
                    doctor = new Doctor();
                    doctor.setId(resultSet.getInt("id"));
                    doctor.setDoctorname(resultSet.getString("doctor_name"));
                    doctor.setSpecialist(resultSet.getString("specialist"));
                    doctor.setStartTime(resultSet.getString("start_Time"));
                    doctor.setEndtime(resultSet.getString("End_time"));
                    doctor.setExperience(resultSet.getInt("Experience"));
                    doctor.setImage(resultSet.getString("image"));
                }
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }

        return doctor;
    }

	public List<Appointment> getAppointmentsForDoctor(int id) throws DAOException {
	    List<Appointment> appointments = new ArrayList<>();
	    String query = "SELECT * FROM appointments WHERE doc_id = ?";

	    try (Connection connection = ConnectionUtil.getConnection();
	         PreparedStatement pmt = connection.prepareStatement(query)) {
	        pmt.setInt(1, id);
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
	
	 public Doctor getDoctorByEmail(String email) throws DAOException {
	        String query = "SELECT * FROM doctor WHERE doc_email = ?"; // Replace 'email' with the actual column name for email in your database

	        try (Connection connection = ConnectionUtil.getConnection();
	             PreparedStatement pmt = connection.prepareStatement(query)) {
	            pmt.setString(1, email);

	            try (ResultSet rs = pmt.executeQuery()) {
	                if (rs.next()) {
	                    int id = rs.getInt("id");
	                    String doctorname = rs.getString("doctor_name");
	                    String specialist = rs.getString("specialist");
	                    String startTime = rs.getString("start_time");
	                    String endTime = rs.getString("end_time");
	                    int experience = rs.getInt("Experience");
	                    String image = rs.getString("image");

	                    return new Doctor(doctorname, specialist, startTime, endTime, experience, image, id);
	                } else {
	                    return null; // No doctor found with the given email
	                }
	            }
	        } catch (SQLException e) {
	            throw new DAOException(e);
	        }
	    }
	 
	 
	
	
}

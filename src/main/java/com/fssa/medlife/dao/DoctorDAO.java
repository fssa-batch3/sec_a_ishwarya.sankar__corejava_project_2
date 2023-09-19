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
        String query = "INSERT INTO doctor (doctorname, specialist, StartTime, Endtime, Experience, image) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection =ConnectionUtil.getConnection();
             PreparedStatement pmt = connection.prepareStatement(query)) {

            pmt.setString(1, doctor.getDoctorname());
            pmt.setString(2, doctor.getSpecialist());
            pmt.setString(3, doctor.getStartTime());
            pmt.setString(4, doctor.getEndtime());
            pmt.setInt(5, doctor.getExperience());
            pmt.setString(6, doctor.getImage());

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
                String doctorName = rs.getString("doctorname");
                String specialist = rs.getString("specialist");
                String startTime = rs.getString("StartTime");
                String endTime = rs.getString("Endtime");
                int experience = rs.getInt("Experience");
                String image = rs.getString("image");

                Doctor doctor = new Doctor(doctorName, specialist, startTime, endTime, experience, image);
                doctors.add(doctor);
            }
        }

        return doctors;
    }

    public boolean updateDoctor(Doctor doctor) throws SQLException, ClassNotFoundException {
        String query = "UPDATE doctor SET specialist = ?, start_time = ?, end_time = ?, experience = ?, image = ? WHERE doctor_name = ?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement pmt = connection.prepareStatement(query)) {
            pmt.setString(1, doctor.getSpecialist());
            pmt.setString(2, doctor.getStartTime());
            pmt.setString(3, doctor.getEndtime());
            pmt.setInt(4, doctor.getExperience());
            pmt.setString(5, doctor.getImage());
            pmt.setString(6, doctor.getDoctorname());

            int rows = pmt.executeUpdate();

            return rows == 1;
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

}

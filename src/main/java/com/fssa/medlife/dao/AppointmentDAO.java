package com.fssa.medlife.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.medlife.exception.DAOException;
import com.fssa.medlife.model.Appointment;
import com.fssa.medlife.model.Doctor;
import com.fssa.medlife.model.User;
import com.fssa.medlife.utils.ConnectionUtil;

public class AppointmentDAO {
	public boolean createAppointment(Appointment appointment) throws DAOException {
	    String insertQuery = "INSERT INTO appointments (user_id, doc_id, appointment_date, booking_date, Status) VALUES (?, ?, ?, ?, ?)";
	    try (Connection connection = ConnectionUtil.getConnection();
	         PreparedStatement pst = connection.prepareStatement(insertQuery)) {
	        pst.setInt(1, appointment.getUser().getUserId());
	        pst.setInt(2, appointment.getDoctor().getId());
	        
	        pst.setDate(3, java.sql.Date.valueOf(appointment.getAppointmentDate()));
	        
	        // Convert LocalDate to java.sql.Date for 'booking_date'
	        pst.setDate(4, java.sql.Date.valueOf(appointment.getBookingDate()));
	        
	        pst.setString(5, appointment.getStatus());
	        
	        int rows = pst.executeUpdate();
	        return (rows > 0);
	    } catch (SQLException e) {
	        throw new DAOException(e);
	    }
	}


	public List<Appointment> getAllAppointments() throws DAOException {
		List<Appointment> appointments = new ArrayList<>();
		String query = "SELECT" + "    appointments.id," + "    appointments.appointment_date," + "    doctor.*,"
				+ "    User.*" + "FROM" + "    appointments" + "INNER JOIN"
				+ "    doctor ON appointments.id = doctor.id" + "INNER JOIN"
				+ "    user ON appointments.id = User.userId;";

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pmt = connection.prepareStatement(query);
				ResultSet rs = pmt.executeQuery()) {

			while (rs.next()) {
				Appointment appointment = new Appointment();
				User user = new User();
				Doctor doctor = new Doctor();

				user.setUserId(rs.getInt("user_id"));
				doctor.setId(rs.getInt("doc_id"));
				doctor.setDoctorname(rs.getString("doctor_name"));
				doctor.setSpecialist(rs.getString("specialist"));
				doctor.setStartTime(rs.getString("start_time"));
				doctor.setEndtime(rs.getString("End_Time"));
				doctor.setExperience(rs.getInt("experience"));
				doctor.setImage(rs.getString("image"));

				appointment.setUser(user);
				appointment.setDoctor(doctor);
				appointment.setAppointmentDate(rs.getDate("appointment_date").toString());
				appointment.setBookingDate(rs.getDate("booking_date").toString());
				appointment.setStatus(rs.getString("status"));

				appointments.add(appointment);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}

		return appointments;
	}

	public List<Appointment> getAllDoctorAppointments(int doctorId) throws DAOException {
		List<Appointment> appointments = new ArrayList<>();
		String query = "SELECT "
				+ " appointments.id as appointmentId,"
				+ "    appointments.appointment_date,"
				+ "    doctor.*,"
				+ "    user.*"
				+ "FROM"
				+ "    appointments"
				+ "INNER JOIN"
				+ "    doctor ON appointments.doc_id = doctor.id"
				+ "INNER JOIN\r\n"
				+ "    user ON appointments.user_id = user.userId"
				+ "WHERE\r\n"
				+ "    appointments.id = ?;"
				+ "";

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pmt = connection.prepareStatement(query)) {

			pmt.setInt(1, doctorId);

			try (ResultSet rs = pmt.executeQuery()) {
				while (rs.next()) {
					Appointment appointment = new Appointment();
					User user = new User();
					Doctor doctor = new Doctor();

					user.setUserId(rs.getInt("user_id"));
					doctor.setId(rs.getInt("id"));
					doctor.setDoctorname(rs.getString("doctor_name"));
					doctor.setSpecialist(rs.getString("specialist"));
					doctor.setStartTime(rs.getString("start_time"));
					doctor.setEndtime(rs.getString("End_Time"));
					doctor.setExperience(rs.getInt("Experience"));
					doctor.setImage(rs.getString("image"));

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

	public List<Appointment> getAllUserAppointments(int userId) throws DAOException {
		System.out.println(userId);
		List<Appointment> appointments = new ArrayList<>();
		String query = """
				SELECT appointments.id as appointmentId,  appointments.appointment_date,appointments.booking_date,
    appointments.status, doctor.*, user.* FROM appointments INNER JOIN doctor ON appointments.doc_id = doctor.id  INNER JOIN user ON appointments.user_id = user.userId WHERE  appointments.user_id = ?""";

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pmt = connection.prepareStatement(query)) {

			pmt.setInt(1, userId);

			try (ResultSet rs = pmt.executeQuery()) {
				while (rs.next()) {
					Appointment appointment = new Appointment();
					User user = new User();
					Doctor doctor = new Doctor();

					user.setUserId(rs.getInt("userId"));

					doctor.setId(rs.getInt("id"));
					doctor.setDoctorname(rs.getString("doctor_name"));
					doctor.setSpecialist(rs.getString("specialist"));
					doctor.setStartTime(rs.getString("start_time"));
					doctor.setEndtime(rs.getString("end_time"));
					doctor.setExperience(rs.getInt("Experience"));
					doctor.setImage(rs.getString("image"));

					user.setUsername(rs.getString("userName"));
					user.setEmail(rs.getString("email"));
					user.setPassword(rs.getString("password"));
					user.setType(rs.getString("type"));
					user.setPhonenumber(rs.getString("phone_number"));

					appointment.setUser(user);
					appointment.setDoctor(doctor);
					appointment.setAppointmentDate(rs.getDate("appointment_date").toString());
					appointment.setBookingDate(rs.getDate("booking_date").toString());
					appointment.setStatus(rs.getString("status"));
					appointments.add(appointment);
					System.out.println(appointments);

				}
			}

			System.out.println(appointments);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException(e);
		}

		return appointments;
	}

	// public List<Appointment> getAllAppointments() throws DAOException {
//		List<Appointment> appointments = new ArrayList<>();
//		Appointment appointment = null;
//		String query = "SELECT * FROM appointments";
//		try (Connection connection = ConnectionUtil.getConnection();
//				PreparedStatement pmt = connection.prepareStatement(query);
//				ResultSet rs = pmt.executeQuery()) {
//
//			while (rs.next()) {
//				appointment = new Appointment();
//				User user = new User();
//				Doctor doctor = new Doctor();
//				user.setUserId(rs.getInt("user_id"));
//				doctor.setId(rs.getInt("doc_id"));
//				appointment.setUser(user);
//				appointment.setDoctor(doctor);
//				appointment.setAppointmentDate(rs.getDate("appointment_date").toString());
//				appointment.setBookingDate(rs.getDate("booking_date").toString());
//				appointment.setStatus(rs.getString("status"));
//				appointments.add(appointment);
//			}
//		} catch (SQLException e) {
//			throw new DAOException(e);
//		}
//
//		return appointments;
//	}

	public boolean updateAppointment(Appointment appointment) throws DAOException {
		String updateQuery = "UPDATE appointments SET doc_id = ?, appointment_date = ?, booking_date = ?, status = ? WHERE user_id = ?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(updateQuery)) {
			pst.setInt(1, appointment.getDoctor().getId());
			pst.setString(2, appointment.getAppointmentDate().toString());
			pst.setString(3, appointment.getBookingDate().toString());
			pst.setString(4, appointment.getStatus());
			pst.setInt(5, appointment.getUser().getUserId());
			int rows = pst.executeUpdate();
			return (rows > 0);
		} catch (SQLException e) {
			throw new DAOException("Invalid in update appointment");
		}
	}

	public boolean deleteAppointment(int userId) throws DAOException {
		String deleteQuery = "DELETE FROM appointments WHERE user_id = ?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(deleteQuery)) {
			pst.setInt(1, userId);
			int rows = pst.executeUpdate();
			return (rows > 0);
		} catch (SQLException e) {
			throw new DAOException("Invalid in delete appointment");
		}
	}

}

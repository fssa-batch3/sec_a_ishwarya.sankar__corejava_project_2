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
	
	
	public void CreateDoctor(Doctor doctor) throws DAOException {
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
	
	
	
	public List<Doctor> listDoctors() throws DAOException {
	    List<Doctor> doctors = new ArrayList<>();
	    Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;

	    try {
	        String query = "SELECT * FROM doctor";
	        con = getConnection();
	        ps = con.prepareStatement(query);
	        rs = ps.executeQuery();

	        while (rs.next()) {
	            Doctor doctor = new Doctor();
	            doctor.setDoctorname(rs.getString("doctor_name"));
	            doctor.setSpecialist(rs.getString("specialist"));
	            doctor.setAvailability(rs.getInt("availability"));
	            doctor.setExperience(rs.getInt("Experience"));
	            doctor.setImage(rs.getString("image"));
	            doctors.add(doctor);
	        }

	        return doctors;
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	        throw new DAOException(e);
	    } finally {
	        closeAll(con, ps, rs);
	    }
	}
	
	// update
	public void updateDoctor(Doctor doctor) throws DAOException {
	    Connection con = null;
	    PreparedStatement ps = null;

	    try {
	        String query = "UPDATE doctor SET specialist=?, availability=?, Experience=?, image=? WHERE doctor_name=?";
	        con = getConnection();
	        ps = con.prepareStatement(query);
	        ps.setString(1, doctor.getSpecialist());
	        ps.setInt(2, doctor.getAvailability());
	        ps.setInt(3, doctor.getExperience());
	        ps.setString(4, doctor.getImage());
	        ps.setString(5, doctor.getDoctorname());
	        int rowsAffected = ps.executeUpdate();

	        if (rowsAffected > 0) {
	            System.out.println("Doctor information has been updated successfully");
	        } else {
	            System.out.println("No records were updated");
	        }
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	        throw new DAOException(e);
	    } finally {
	        close(con, ps);
	    }
	}
	//delete
	public void deleteDoctor(String doctorName) throws DAOException {
	    Connection con = null;
	    PreparedStatement ps = null;

	    try {
	        String query = "DELETE FROM doctor WHERE doctor_name=?";
	        con = getConnection();
	        ps = con.prepareStatement(query);
	        ps.setString(1, doctorName);
	        int rowsAffected = ps.executeUpdate();

	        if (rowsAffected > 0) {
	            System.out.println("Doctor record has been deleted successfully");
	        } else {
	            System.out.println("No records were deleted");
	        }
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	        throw new DAOException(e);
	    } finally {
	        close(con, ps);
	    }
	}
	
}

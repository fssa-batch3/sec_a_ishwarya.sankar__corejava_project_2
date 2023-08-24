package com.fssa.medlife.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.*;

import com.fssa.medlife.exception.DAOException;
import com.fssa.medlife.exception.ValidatorException;
import com.fssa.medlife.model.Medicine;


public class MedicineDAO {
	

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

	// add new user to DB - medicine
	public void addMedicine(Medicine medicine) throws DAOException {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			String query = "INSERT INTO medicine (medicine_name, medicine_rupees,user_id,medicine_url) VALUES (?, ?, ?, ?)";
			con = getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, medicine.getMedicineName());
			ps.setInt(2, medicine.getMedicineRupees());
			ps.setInt(3, medicine.getUserID());
			ps.setString(4, medicine.getMedicineUrl());
			ps.executeUpdate();
			System.out.println("Medicine has been created successfully");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException(e);
		} finally {
			close(con,ps);
		}
	}

	public void checkMedicineName(String medicineName) throws ValidatorException, DAOException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String query = "SELECT* FROM medicines WHERE medicine_name = ?";
			con = getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, medicineName);
			rs = ps.executeQuery();
			if (rs.next()) {
				throw new ValidatorException("Medicine already exists");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException(e);
		} finally {
			closeAll(con,ps, rs);
		}
	}
	

	public void updateMedicine(int id, Medicine medicine) throws DAOException {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			String query = "UPDATE medicine SET medicine_name = ?, medicine_rupees = ?, user_id = ?, medicine_url = ? WHERE id = ?";
			con = getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, medicine.getMedicineName());
			ps.setInt(2, medicine.getMedicineRupees());
			ps.setInt(3, medicine.getUserID());
			ps.setString(4, medicine.getMedicineUrl());
			ps.setInt(5, id);
			ps.executeUpdate();
			System.out.println("Medicine has been updated successfully");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException(e);
		} finally {
			close(con,ps);
		}
	}
	public void checkMedicineIdExists(int id) throws ValidatorException, DAOException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String query = "SELECT id FROM medicine WHERE id = ?";
			con = getConnection();
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (!rs.next()) {
				throw new ValidatorException("Medicine Id doesn't exists");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException(e);
		} finally {
			closeAll(con,ps, rs);
		}
	}
	
	public boolean deleteMedicine(int id) throws DAOException {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			String query = "UPDATE medicine SET is_deleted=1 WHERE id=?";
			con = getConnection();
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			int rows = ps.executeUpdate();
			return (rows == 1);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException(e);
		} finally {
			close(con,ps);
		}
	}
	
	public List<Medicine> findAllMedicine() throws DAOException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Medicine> medicineList = new ArrayList<>();
		try {
			String query = "SELECT * FROM medicine";
			conn = getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				Medicine med = new Medicine();
				med.setId(rs.getInt("id"));
				med.setMedicineName(rs.getString("medicine_name"));
				med.setMedicineRupees(rs.getInt("medicine_rupees"));
				med.setMedicineUrl(rs.getString("medicine_url"));
				med.setUserID(rs.getInt("user_id"));
				medicineList.add(med);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DAOException(e);
		} finally {
			closeAll(conn, ps, rs);
		}
		return medicineList;
	}

	public Medicine findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	//Finally, the med object, which may contain the retrieved medicine data or be null, is returned.
}
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
import com.fssa.medlife.utils.ConnectionUtil;


public class MedicineDAO {
	

	// connect to database
public Connection getConnection() throws SQLException {
	return ConnectionUtil.getConnection();
	}
//
//	public static void close(Connection connection, PreparedStatement ps) throws DAOException {
//		try {
//			if (ps != null) {
//				ps.close();
//			}
//			if (connection != null) {
//				connection.close();
//			}
//		} catch (SQLException e) {
//			throw new DAOException(e);
//		}
//	}
//	//checking each  for null and closing it if it's not null and throws exception
//	public static void closeAll(Connection connection, PreparedStatement ps, ResultSet rs) throws DAOException {
//		try {
//			if (rs != null) {
//				rs.close();
//			}
//			if (ps != null) {
//				ps.close();
//			}
//			if (connection != null) {
//				connection.close();
//			}
//		} catch (SQLException e) {
//			throw new DAOException(e);
//		}
//	}

//	// add new user to DB - medicine
//	public boolean addMedicine(Medicine medicine) throws DAOException {
//		Connection con = null;
//		PreparedStatement ps = null;
//
//		try {
//			String query = "INSERT INTO medicine (medicine_name, medicine_rupees,medicine_url) VALUES (?, ?, ?,)";
//			con = getConnection();
//			ps = con.prepareStatement(query);
//			ps.setString(1, medicine.getMedicineName());
//			ps.setInt(2, medicine.getMedicineRupees());
//			ps.setString(3, medicine.getMedicineUrl());
//			ps.executeUpdate();
//			System.out.println("Medicine has been created successfully");
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());
//			throw new DAOException(e);
//		} finally {
//			close(con,ps);
//		}
//		return false;
//	}
	
	
	 // Add new medicine to DB
	public boolean addMedicine(Medicine medicine) throws DAOException {
	    String query = "INSERT INTO medicine (MedicineName, MedicineRupees, MedicineUrl) VALUES (?, ?, ?)";

	    try (Connection connection = ConnectionUtil.getConnection();
	         PreparedStatement pmt = connection.prepareStatement(query)) {
	        pmt.setString(1, medicine.getMedicineName());
	        pmt.setInt(2, medicine.getMedicineRupees());
	        pmt.setString(3, medicine.getMedicineUrl());

	        int rows = pmt.executeUpdate();
	        return rows == 1;
	    } catch (SQLException e) {
	        // Convert the SQLException to a custom DaoException and throw it
	        throw new DAOException(e);
	    }
	}

   
	public List<Medicine> getAllMedicines() throws DAOException {
	    List<Medicine> medicines = new ArrayList<>();

	    String query = "SELECT * FROM medicine";
	    try (Connection connection = getConnection();
	         PreparedStatement pmt = connection.prepareStatement(query);
	         ResultSet rs = pmt.executeQuery()) {

	        while (rs.next()) {
	            String medicineName = rs.getString("MedicineName");
	            int medicineRupees = rs.getInt("MedicineRupees");
	            String medicineUrl = rs.getString("MedicineUrl");
	            int id = rs.getInt("id");

	            Medicine medicine = new Medicine(medicineName, medicineRupees, medicineUrl);
	            medicine.setId(id);
	            medicines.add(medicine);
	        }
	    } catch (SQLException e) {
	        throw new DAOException(e);
	    }

	    return medicines;
	}
	public boolean updateMedicine(Medicine medicine, int id) throws DAOException {
	    String query = "UPDATE medicine SET MedicineName = ?, MedicineRupees = ?, MedicineUrl = ? WHERE id = ?";
	    System.out.println("Query: " + query); // Print the query for debugging purposes

	    try (Connection connection = ConnectionUtil.getConnection();
	         PreparedStatement pmt = connection.prepareStatement(query)) {
	        pmt.setString(1, medicine.getMedicineName());
	        pmt.setInt(2, medicine.getMedicineRupees());
	        pmt.setString(3, medicine.getMedicineUrl());
	        pmt.setInt(4, id); // Set the ID parameter

	        int rows = pmt.executeUpdate();
	        return rows == 1;
	    } catch (SQLException e) {
	        // Convert the SQLException to a custom DaoException and throw it
	        throw new DAOException (e);
	    }
	}

    
	// Delete a medicine from the DB
	public boolean deleteMedicine(int id) throws DAOException {
	    String query = "DELETE FROM medicine WHERE id = ?";

	    try (Connection connection = ConnectionUtil.getConnection();
	         PreparedStatement pmt = connection.prepareStatement(query)) {
	        pmt.setInt(1, id);

	        int rows = pmt.executeUpdate();
	        return rows == 1;
	    } catch (SQLException e) {
	        // Convert the SQLException to a custom DaoException and throw it
	        throw new DAOException(e);
	    }
	}

	// Check if a medicine name already exists in the DB
	public boolean isMedicineNameExists(String medicineName) throws DAOException {
	    String query = "SELECT COUNT(*) FROM medicine WHERE MedicineName = ?";

	    try (Connection connection = ConnectionUtil.getConnection();
	         PreparedStatement pmt = connection.prepareStatement(query)) {
	        pmt.setString(1, medicineName);

	        try (ResultSet resultSet = pmt.executeQuery()) {
	            if (resultSet.next()) {
	                int count = resultSet.getInt(1);
	                return count > 0;
	            }
	        }
	    } catch (SQLException e) {
	        // Convert the SQLException to a custom DaoException and throw it
	        throw new DAOException(e);
	    }
	    return false;
	}

	public Medicine findMedicineById(int id) throws DAOException {
	    String query = "SELECT * FROM medicine WHERE MedicineId = ?";
	    Medicine medicine = null;

	    try (Connection connection = ConnectionUtil.getConnection();
	         PreparedStatement pmt = connection.prepareStatement(query)) {
	        pmt.setInt(1, id);

	        try (ResultSet resultSet = pmt.executeQuery()) {
	            if (resultSet.next()) {
	                // Extract data from the ResultSet and create a Medicine object
	                medicine.setId(resultSet.getInt("id"));
	                medicine.setMedicineName(resultSet.getString("MedicineName"));
	                medicine.setMedicineRupees(resultSet.getInt("MedicineRupees"));
	                medicine.setMedicineUrl(resultSet.getString("MedicineUrl"));

	                // You can set other fields similarly here

	                // Return the Medicine object
	                return medicine;
	            }
	        }
	    } catch (SQLException e) {
	        // Convert the SQLException to a custom DAOException and throw it
	        throw new DAOException(e);
	    }

	    return null; // Return null if no Medicine with the specified ID was found
	}


	
	
	
	
	
	
	
	
	
	
	
//    
//	public void checkMedicineName(String medicineName) throws ValidatorException, DAOException {
//		Connection con = null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		try {
//			String query = "SELECT* FROM medicine WHERE medicine_name = ?";
//			con = getConnection();
//			ps = con.prepareStatement(query);
//			ps.setString(1, medicineName);
//			rs = ps.executeQuery();
//			if (rs.next()) {
//				throw new ValidatorException("Medicine already exists");
//			}
//
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());
//			throw new DAOException(e);
//		} finally {
//			closeAll(con,ps, rs);
//		}
//	}
//	
//
//	public void updateMedicine(int id, Medicine medicine) throws DAOException {
//		Connection con = null;
//		PreparedStatement ps = null;
//
//		try {
//			String query = "UPDATE medicine SET medicine_name = ?, medicine_rupees = ?, medicine_url = ? WHERE id = ?";
//			con = getConnection();
//			ps = con.prepareStatement(query);
//			ps.setString(1, medicine.getMedicineName());
//			ps.setInt(2, medicine.getMedicineRupees());
//			ps.setString(4, medicine.getMedicineUrl());
//			ps.setInt(5, id);
//			ps.executeUpdate();
//			System.out.println("Medicine has been updated successfully");
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());
//			throw new DAOException(e);
//		} finally {
//			close(con,ps);
//		}
//	}
//	public void checkMedicineIdExists(int id) throws ValidatorException, DAOException {
//		Connection con = null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		try {
//			String query = "SELECT id FROM medicine WHERE id = ?";
//			con = getConnection();
//			ps = con.prepareStatement(query);
//			ps.setInt(1, id);
//			rs = ps.executeQuery();
//			if (!rs.next()) {
//				throw new ValidatorException("Medicine Id doesn't exists");
//			}
//
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());
//			throw new DAOException(e);
//		} finally {
//			closeAll(con,ps, rs);
//		}
//	}
//	
//	public boolean deleteMedicine(int id) throws DAOException {
//		Connection con = null;
//		PreparedStatement ps = null;
//		
//		try {
//			String query = "UPDATE medicine SET is_deleted=1 WHERE id=?";
//			con = getConnection();
//			ps = con.prepareStatement(query);
//			ps.setInt(1, id);
//			int rows = ps.executeUpdate();
//			return (rows == 1);
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());
//			throw new DAOException(e);
//		} finally {
//			close(con,ps);
//		}
//	}
//	
//	public List<Medicine> findAllMedicine() throws DAOException{
//		Connection conn = null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		List<Medicine> medicineList = new ArrayList<>();
//		try {
//			String query = "SELECT * FROM medicine";
//			conn = getConnection();
//			ps = conn.prepareStatement(query);
//			rs = ps.executeQuery();
//			while (rs.next()) {
//				Medicine med = new Medicine();
//				med.setId(rs.getInt("id"));
//				med.setMedicineName(rs.getString("medicine_name"));
//				med.setMedicineRupees(rs.getInt("medicine_rupees"));
//				med.setMedicineUrl(rs.getString("medicine_url"));
//				med.setUserID(rs.getInt("user_id"));
//				medicineList.add(med);
//			}
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());
//			throw new DAOException(e);
//		} finally {
//			closeAll(conn, ps, rs);
//		}
//		return medicineList;
//	}
//
//	public Medicine findById(int id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
	
	
	//Finally, the med object, which may contain the retrieved medicine data or be null, is returned.
}
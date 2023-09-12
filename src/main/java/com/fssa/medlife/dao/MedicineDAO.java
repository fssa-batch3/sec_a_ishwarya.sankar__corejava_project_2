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


/**
 * Adds a new medicine to the database.
 *
 * @param medicine The Medicine object to be added.
 * @return true if the medicine is successfully added, false otherwise.
 * @throws DAOException if there is an issue with the database operation.
 */
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
	        throw new DAOException(e);
	        
	        
	    }
	}

	 /**
     * Retrieves a list of all medicines from the database.
     *
     * @return A list of Medicine objects representing all medicines in the database.
     * @throws DAOException if there is an issue with the database operation.
     */
   
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
	  /**
     * Updates an existing medicine in the database.
     *
     * @param medicine The updated Medicine object.
     * @param id       The ID of the medicine to be updated.
     * @return true if the medicine is successfully updated, false otherwise.
     * @throws DAOException if there is an issue with the database operation.
     */
	public boolean updateMedicine(Medicine medicine, int id) throws DAOException {
	    String query = "UPDATE medicine SET MedicineName = ?, MedicineRupees = ?, MedicineUrl = ? WHERE id = ?";
	    System.out.println("Query: " + query);
	    try (Connection connection = ConnectionUtil.getConnection();
	         PreparedStatement pmt = connection.prepareStatement(query)) {
	        pmt.setString(1, medicine.getMedicineName());
	        pmt.setInt(2, medicine.getMedicineRupees());
	        pmt.setString(3, medicine.getMedicineUrl());
	        pmt.setInt(4, id); 

	        int rows = pmt.executeUpdate();
	        return rows == 1;
	    } catch (SQLException e) {
	        throw new DAOException (e);
	    }
	}
	 /**
     * Deletes a medicine from the database by its ID.
     *
     * @param id The ID of the medicine to be deleted.
     * @return true if the medicine is successfully deleted, false otherwise.
     * @throws DAOException if there is an issue with the database operation.
     */
    
	// Delete a medicine from the DB
	public boolean deleteMedicine(int id) throws DAOException {
	    String query = "DELETE FROM medicine WHERE id = ?";

	    try (Connection connection = ConnectionUtil.getConnection();
	         PreparedStatement pmt = connection.prepareStatement(query)) {
	        pmt.setInt(1, id);

	        int rows = pmt.executeUpdate();
	        return rows == 1;
	    } catch (SQLException e) {
	        throw new DAOException(e);
	    }
	}

	
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
	        throw new DAOException(e);
	    }
	    return false;
	}

	
	public Medicine findMedicineById(int id) throws DAOException {
	    String query = "SELECT * FROM medicine WHERE id = ?";
	    Medicine medicine = new Medicine();

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
		return medicine;

	    
	}

	
	}
	
	
	
	


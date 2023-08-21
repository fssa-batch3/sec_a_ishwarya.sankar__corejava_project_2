package com.fssa.medlife.dao;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.*;

import com.fssa.medlife.model.Medicine;

public class MedicineDAO {
	
	 //connect to database
		public Connection getConnection() throws SQLException {
		 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/backend", "root","123456");
		 return connection;
		}
		
		//add new user to DB - medicine
		public boolean addMedicine(Medicine medicine) throws SQLException {
	        String query = "INSERT INTO medicine (medicine_name, medicine_rupees) VALUES (?, ?)";
	        
	        try (Connection connection = getConnection(); PreparedStatement pmt = connection.prepareStatement(query)) {
	            pmt.setString(1, medicine.getMedicineName());
	            pmt.setInt(2, medicine.getMedicineRupees());
	            //pmt.setInt(3, medicine.getUserID());
//	            pmt.setString(3, medicine.getMedicineUrl());
	            
	            int rows = pmt.executeUpdate();
	            return rows == 1;
	        }
	    }
	
		
	
		public List<Medicine> listMedicines() throws SQLException {
		    List<Medicine> medicines = new ArrayList<>();
		    String query = "SELECT * FROM Medicine";
		    try (Connection connection = getConnection();
		         PreparedStatement pstmt = connection.prepareStatement(query);
		         ResultSet resultSet = pstmt.executeQuery()) {
		        while (resultSet.next()) {
		            int medicineId = resultSet.getInt("id");
		            String medicineName = resultSet.getString("medicine_name");
		            int medicineRupees = resultSet.getInt("medicine_rupees");
		            String medicineUrl = resultSet.getString("medicine_url");
		            // Add other fields as needed
		            
		            Medicine medicine = new Medicine(medicineId);
		            medicines.add(medicine);
		        }
		        return medicines;
		    }
		}
		
		//update medicine 
		public boolean updateMedicine(Medicine medicine) throws SQLException {
			//Get Connection
			Connection connection = getConnection();
			
			// Prepare SQL Statement
			String insertQuery = "Update Medicine SET medicine_name=? , medicine_rupees=?  WHERE id=?;";
			PreparedStatement pst = connection.prepareStatement(insertQuery);

			pst.setString(1, medicine.getMedicineName());
			pst.setInt(2, medicine.getMedicineRupees());
			pst.setInt(3, medicine.getUserID());
			//Execute query
			int rows = pst.executeUpdate();
			
			//Return Successful or not
			return (rows == 1);
		}
		// read 
		public Medicine readMedicine(int medicineId) throws SQLException {
		    Connection connection = getConnection();
		    String selectQuery = "SELECT medicine_name, medicine_rupees FROM Medicine WHERE id = ?";
		    
		    try (PreparedStatement pst = connection.prepareStatement(selectQuery)) {
		        pst.setInt(1, medicineId);
		        
		        try (ResultSet rs = pst.executeQuery()) {
		            if (rs.next()) {
		                Medicine medicine = new Medicine(medicineId);
		               
		                medicine.setMedicineName(rs.getString("medicine_name"));
		                medicine.setMedicineRupees(rs.getInt("medicine_rupees"));
		                // Set other medicine details as needed
		                
		                return medicine;
		            } else {
		                return null; // Medicine not found
		            }
		        }
		    }
		}

		
		//delete 
		public boolean deleteMedicine(Medicine medicine) throws SQLException {
			//Get Connection
			Connection connection = getConnection();
			
			// Prepare SQL Statement
			String insertQuery = "Delete from Medicine WHERE id=?;";
			PreparedStatement pst = connection.prepareStatement(insertQuery);

			pst.setInt(1, medicine.getUserID());
			//Execute query
		int rows = pst.executeUpdate();
			
			//Return Successful or not
			return (rows == 1);
		}
}
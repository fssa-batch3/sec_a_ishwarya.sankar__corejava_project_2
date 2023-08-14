package Medlife.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Medlife.model.User;
import java.util.*;
import Medlife.model.*;
public class MedicineDAO {
	
	 //connect to database
		public Connection getConnection() throws SQLException {
		 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/backend", "root","123456");
		 return connection;
		}
		
		//add new user to DB - medicine
		public boolean Medicine(Medicine medicine) throws SQLException {
			//Get Connection
			Connection connection = getConnection();
			
			// Prepare SQL Statement
			String insertQuery = "INSERT INTO medicine (MedicineName,MedicineRupees) VALUES (?,?);";
			PreparedStatement pst = connection.prepareStatement(insertQuery);
			
			pst.setString(1, medicine.getMedicineName());
			pst.setInt(2, medicine.getMedicineRupees());
			//Execute query
			int rows = pst.executeUpdate();
			
			//Return Successful or not
			return (rows == 1);
		}
		
		//Read
		public boolean ReadMedicine(Medicine medicine) throws SQLException {
			//Get Connection
			Connection connection = getConnection();
			
			// Prepare SQL Statement
			String insertQuery = "select * from ;";
			PreparedStatement pst = connection.prepareStatement(insertQuery);
			
			pst.setString(1, medicine.getMedicineName());
			pst.setInt(2, medicine.getMedicineRupees());
			//Execute query
			int rows = pst.executeUpdate();
			
			//Return Successful or not
			return (rows == 1);
		}
		
		
		
		
		
		//update medicine 
		public boolean UpdateMedicine(Medicine medicine) throws SQLException {
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
		
		//delete 
		public boolean DeleteMedicine(Medicine medicine) throws SQLException {
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
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
		 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root","123456");
		 return connection;
		}
		
		//add new user to DB - medicine
		public boolean Medicine(Medicine medicine) throws SQLException {
			//Get Connection
			Connection connection = getConnection();
			
			// Prepare SQL Statement
			String insertQuery = "INSERT INTO Medicine (MedicineName,MedicineRupees) VALUES (?,?);";
			PreparedStatement pst = connection.prepareStatement(insertQuery);
			
			pst.setString(1, medicine.getMedicineName());
			pst.setInt(2, medicine.getMedicineRupees());
			pst.setLong(3, medicine.getUserID());
			//Execute query
			int rows = pst.executeUpdate();
			
			//Return Successful or not
			return (rows == 1);
		}
}
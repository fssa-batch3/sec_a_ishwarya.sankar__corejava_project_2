package Medlife.dao;
import Medlife.model.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

import Medlife.dao.exception.*;
import Medlife.model.User;

public class UserDAO {

	
	 //connect to database
	public Connection getConnection() throws SQLException {
	 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root","123456");
	 return connection;
	}
	
	//add new user to DB - Register
	public boolean register(User user) throws SQLException {
		//Get Connection
		Connection connection = getConnection();
		
		// Prepare SQL Statement
		String insertQuery = "INSERT INTO user (username,phone_number,email,password) VALUES (?,?,?,?);";
		PreparedStatement pst = connection.prepareStatement(insertQuery);
		
		pst.setString(1, user.getUsername());
		pst.setString(2, user.getMobile_number());
		pst.setString(3, user.getEmail());
		pst.setString(4, user.getPassword());
		//Execute query
		int rows = pst.executeUpdate();
		
		//Return Successful or not
		return (rows == 1);
	}
	// login 
	public boolean login(String email,String password) throws DAOException {
		//Get Connection
		try {
		Connection connection = getConnection();
		
		// Prepare SQL Statement
		String insertQuery = "Select *  from user Where email=? and password=? ;";
		PreparedStatement pst = connection.prepareStatement(insertQuery);
		
		pst.setString(1, email);
		pst.setString(2, password);
		
		//Execute query
		ResultSet rs  = pst.executeQuery();
	return rs.next();
		}catch(SQLException e) {
			throw new DAOException(e);
		}
		}
			
		
		
		
		//Return Successful or not
		
	
}

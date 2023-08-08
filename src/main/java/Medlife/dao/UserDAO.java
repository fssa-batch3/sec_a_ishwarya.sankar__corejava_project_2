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
import io.github.cdimascio.dotenv.Dotenv;

public class UserDAO {

	
	 //connect to database
	public Connection getConnection() throws SQLException {
		
		String DB_URL;
		String DB_USER;
		String DB_PASSWORD;
		if (System.getenv("CI") != null) {
			DB_URL = System.getenv("DB_URL");
			DB_USER = System.getenv("DB_USER");
			DB_PASSWORD = System.getenv("DB_PASSWORD");
		} else {
			Dotenv env = Dotenv.load();
			DB_URL = env.get("DB_URL");
			DB_USER = env.get("DB_USER");
			DB_PASSWORD = env.get("DB_PASSWORD");
		}
	 Connection connection = DriverManager.getConnection(DB_URL, DB_USER,DB_PASSWORD);
	 return connection;
	}
	public boolean register(User user) throws SQLException {
		//Get Connection
		Connection connection = getConnection();
		
		// Prepare SQL Statement
		String insertQuery = "INSERT INTO user (userID,username,phone_number,email,password) VALUES (?,?,?,?,?);";
		PreparedStatement pst = connection.prepareStatement(insertQuery);
		pst.setInt(1, user.getUserID());;
		pst.setString(2, user.getUsername());
		pst.setString(3, user.getMobile_number());
		pst.setString(4, user.getEmail());
		pst.setString(5, user.getPassword());
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

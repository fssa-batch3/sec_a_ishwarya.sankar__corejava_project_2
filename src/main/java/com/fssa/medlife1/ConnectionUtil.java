package com.fssa.medlife1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import io.github.cdimascio.dotenv.Dotenv;

public class ConnectionUtil {
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
}

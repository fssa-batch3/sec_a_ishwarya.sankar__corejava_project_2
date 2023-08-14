package com.fssa.medlife1.registration.dao.exception;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.fssa.medlife1.*;
import com.fssa.medlife1.registration.dao.exception.*;
import com.fssa.medlife1.registration.model.UserSign;
import com.fssa.medlife.registration.model.User;
import com.fssa.medlife1.ConnectionUtil;
public class DAORegistration {

	
    public boolean register(User user) throws SQLException {
        Connection connection = getConnection();
        String query = "INSERT INTO USER (id, username, password, email, phone , type) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pmt = connection.prepareStatement(query)) {
            pmt.setInt(1, UserSign.getId());
            pmt.setString(2, UserSign.getUsername());
            pmt.setString(3, UserSign.getPassword());
            pmt.setString(4, UserSign.getEmail());
            pmt.setString(5, UserSign.getPhone());
            pmt.setString(6, UserSign.getPhone());
            int rows = pmt.executeUpdate();
            return rows == 1;
        }
    }

	private Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}
}

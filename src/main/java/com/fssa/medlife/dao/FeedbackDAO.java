package com.fssa.medlife.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.fssa.medlife.exception.DAOException;
import com.fssa.medlife.model.Feedback;
import com.fssa.medlife.utils.ConnectionUtil;

public class FeedbackDAO {
	 public boolean addFeedback(Feedback feedback) throws DAOException {
	        String query = "INSERT INTO feedback (feedbackText, rating, userName) VALUES (?, ?, ?)";

	        try (Connection connection = ConnectionUtil.getConnection();
	             PreparedStatement pmt = connection.prepareStatement(query)) {
	            pmt.setString(1, feedback.getFeedbackText());
	            pmt.setInt(2, feedback.getRating());
	            pmt.setString(3, feedback.getUserName());

	            int rows = pmt.executeUpdate();
	            return rows == 1;
	        } catch (SQLException e) {
	            throw new DAOException(e);
	        }
	    }
}

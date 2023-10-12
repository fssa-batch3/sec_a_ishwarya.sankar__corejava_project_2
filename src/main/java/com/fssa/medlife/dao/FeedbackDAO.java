package com.fssa.medlife.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.medlife.exception.DAOException;
import com.fssa.medlife.model.Feedback;
import com.fssa.medlife.utils.ConnectionUtil;

public class FeedbackDAO {
	
	public boolean addFeedback(Feedback feedback) throws DAOException {
	    String query = "INSERT INTO feedback (feedbackText, userName, rating) VALUES (?, ?, ?)";
	    try (Connection connection = ConnectionUtil.getConnection();
	         PreparedStatement pmt = connection.prepareStatement(query)) {

	        pmt.setString(1, feedback.getFeedbackText());
	        pmt.setString(2, feedback.getUserName());
	        pmt.setInt(3, feedback.getRating());

	        int rows = pmt.executeUpdate();
	        return rows == 1;
	    } catch (SQLException e) {
	        throw new DAOException("Failed to add feedback");
	    }
	}

	 public List<Feedback> getAllFeedback() throws DAOException {
		    List<Feedback> feedbackList = new ArrayList<>();

		    String query = "SELECT * FROM feedback";
		    try (Connection connection = ConnectionUtil.getConnection();
		         PreparedStatement pmt = connection.prepareStatement(query);
		         ResultSet rs = pmt.executeQuery()) {

		        while (rs.next()) {
		            String feedbackText = rs.getString("feedbackText");
		            String userName = rs.getString("userName");
		            int rating = rs.getInt("rating");
	                int id = rs.getInt("feedback_id");

		            Feedback feedback = new Feedback(feedbackText, rating, userName);
		            feedback.setFeedback_id(id);
		            feedbackList.add(feedback);
		        }
		    } catch (SQLException e) {
		        throw new DAOException(e);
		    }

		    return feedbackList;
		}

	 
	 
}

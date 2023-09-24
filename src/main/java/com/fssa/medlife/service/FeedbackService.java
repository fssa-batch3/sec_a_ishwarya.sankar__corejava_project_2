package com.fssa.medlife.service;

import com.fssa.medlife.dao.FeedbackDAO;
import com.fssa.medlife.exception.DAOException;
import com.fssa.medlife.model.Feedback;
import com.fssa.medlife.service.exception.ServiceException;

public class FeedbackService {
	  public boolean addFeedback(Feedback feedback) throws ServiceException {
	        try {
	        	FeedbackDAO feedbackDAO = new FeedbackDAO();
	            return feedbackDAO.addFeedback(feedback);
	        } catch (DAOException e) {
	            throw new ServiceException("Failed to add feedback");
	        }
	    }
}

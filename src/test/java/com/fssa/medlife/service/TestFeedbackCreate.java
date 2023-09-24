package com.fssa.medlife.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.medlife.model.Feedback;
import com.fssa.medlife.service.exception.ServiceException;

public class TestFeedbackCreate {
	 @Test
	    public void testAddFeedbackSuccess() {
	        FeedbackService feedbackService = new FeedbackService();
	        Feedback feedback = new Feedback("Good service!", 4, "Gowtham"); 
	        
	        try {
	            assertTrue(feedbackService.addFeedback(feedback));
	            System.out.println("Feedback added successfully");
	        } catch (ServiceException e) {
	            e.printStackTrace();
	            fail();
	        }
	    }
}

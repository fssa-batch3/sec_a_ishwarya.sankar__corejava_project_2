package com.fssa.medlife.validation;

import com.fssa.medlife.model.Feedback;

import exception.InvalidFeedbackException;

public class FeedbackValidator {
	  public FeedbackValidator() {
	        // Public Constructor
	    }

	    public boolean validateFeedback(Feedback feedback) throws InvalidFeedbackException {
	        if (feedback != null && validateFeedbackText(feedback.getFeedbackText()) && validateRating(feedback.getRating())) {
	            return true;
	        } else {
	            throw new InvalidFeedbackException("Feedback details not valid");
	        }
	    }

	    public boolean validateFeedbackText(String feedbackText) throws InvalidFeedbackException {
	        if (feedbackText == null || feedbackText.trim().isEmpty()) {
	            throw new InvalidFeedbackException("Feedback text is empty or null");
	        }
	        
	        // You can add more specific validation rules for feedback text if needed.

	        return true;
	    }

	    public boolean validateRating(int rating) throws InvalidFeedbackException {
	        if (rating < 1 || rating > 5) {
	            throw new InvalidFeedbackException("Rating is not in the valid range (1 to 5)");
	        }
	        
	        return true;
	    }
}

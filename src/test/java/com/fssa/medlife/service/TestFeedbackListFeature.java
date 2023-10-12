package com.fssa.medlife.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fssa.medlife.model.Feedback;
import com.fssa.medlife.service.exception.ServiceException;

public class TestFeedbackListFeature {
	@Test
	void testListAllFeedback() {
		FeedbackService  feedbackService = new FeedbackService();
		List<Feedback> feedbackList;
		
		try {
			feedbackList = feedbackService.getAllFeedback();
			assertNotNull(feedbackList);
			System.out.println(feedbackList);
		} catch (ServiceException  e) {
			e.printStackTrace();
		}
	}
}

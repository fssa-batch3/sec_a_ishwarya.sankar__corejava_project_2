package com.fssa.medlife.model;

public class Feedback {
	
	private int rating;
    private String userName; 
	private int feedback_id ;
	private String feedbackText;
	
	
	 public int getFeedback_id() {
		return feedback_id;
	}






	public void setFeedback_id(int feedback_id) {
		this.feedback_id = feedback_id;
	}



    public Feedback(String feedbackText, int rating, String userName) {
		super();
		this.feedbackText = feedbackText;
		this.rating = rating;
		this.userName = userName;
	}



    
    
    
	  public String getFeedbackText() {
		return feedbackText;
	}

	public void setFeedbackText(String feedbackText) {
		this.feedbackText = feedbackText;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}



	    public Feedback() {
	        // Default constructor
	    }

	 
}

package com.fssa.medlife.model;

public class Doctordetails {
	
	


	private int license ;
	private String certification;
	private String qualification;
	private String userName;
	private User user;

	public void setUserName(String userName) {
		this.userName = userName;
	}


	private String specialist;
	private int Experience;
	private String image;
	private int userId;
	 
	
	public Doctordetails(int license, String certification, String qualification, String specialist, int experience,
			String image, int userId) {
		super();
		this.license = license;
		this.certification = certification;
		this.qualification = qualification;
		this.specialist = specialist;
		Experience = experience;
		this.image = image;
		this.userId = userId;
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getLicense() {
		return license;
	}
	public void setLicense(int license) {
		this.license = license;
	}
	public String getCertification() {
		return certification;
	}
	public void setCertification(String certification) {
		this.certification = certification;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getSpecialist() {
		return specialist;
	}
	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}
	public int getExperience() {
		return Experience;
	}
	public void setExperience(int experience) {
		Experience = experience;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	
	public Doctordetails(String certification, String qualification, String specialist, int experience, String image, int userId) {
	    this.certification = certification;
	    this.qualification = qualification;
	    this.specialist = specialist;
	    this.Experience = experience;
	    this.image = image;
	    this.userId = userId;
	}

	public Doctordetails() {
		// TODO Auto-generated constructor stub
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
}

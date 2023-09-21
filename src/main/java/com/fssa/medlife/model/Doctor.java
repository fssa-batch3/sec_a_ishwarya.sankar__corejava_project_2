package com.fssa.medlife.model;


public class Doctor {
	private String doctorname;
	  private String specialist;
	private String StartTime;
	  private String Endtime;
	  private int Experience;
	  private String image;
	  private int id;
	  private int userId;
	
	
	  public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public Doctor(String doctorname, String specialist, String startTime, String endTime, int experience, String image, int userId) {
	    this.doctorname = doctorname;
	    this.specialist = specialist;
	    this.StartTime = startTime;
	    this.Endtime = endTime;
	    this.Experience = experience;
	    this.image = image;
	    this.userId = userId;
	}

	
	  public Doctor() {
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
	public Doctor(String doctorname, String specialist, String startTime, String endtime, int experience, String image) {
		super();
		this.doctorname = doctorname;
		this.specialist = specialist;
		StartTime = startTime;
		Endtime = endtime;
		Experience = experience;
		this.image = image;
		this.id = id;
		this.userId = userId;
	}
	
	@Override
	public String toString() {
		return "Doctor [doctorname=" + doctorname + ", specialist=" + specialist + ", StartTime=" + StartTime
				+ ", Endtime=" + Endtime + ", Experience=" + Experience + ", image=" + image + ", id=" + id + "]";
	}
	
	  public String getDoctorname() {
		return doctorname;
	}
	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}
	public String getSpecialist() {
		return specialist;
	}
	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}
	public String getStartTime() {
		return StartTime;
	}
	public void setStartTime(String startTime) {
		StartTime = startTime;
	}
	public String getEndtime() {
		return Endtime;
	}
	public void setEndtime(String endtime) {
		Endtime = endtime;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	


  
}

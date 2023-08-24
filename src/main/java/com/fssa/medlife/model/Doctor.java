package com.fssa.medlife.model;

public class Doctor {
	
	  private String doctorname;
	  private String specialist;
	  private int availability;
	  private int Experience;
	  private String image;
	
	
	//constructor
  public Doctor(String doctorname, String specialist, int availability, int experience, String image) {
		super();
		
		this.doctorname = doctorname;
		this.specialist = specialist;
		this.availability = availability;
		this.Experience = experience;
		this.image = image;
	}

  public Doctor() {
	// TODO Auto-generated constructor stub
}

@Override
public String toString() {
	return "Doctor [doctorname=" + doctorname + ", specialist=" + specialist + ", availability=" + availability
			+ ", Experience=" + Experience + ", image=" + image + ", getDoctorname()=" + getDoctorname()
			+ ", getSpecialist()=" + getSpecialist() + ", getAvailability()=" + getAvailability() + ", getExperience()="
			+ getExperience() + ", getImage()=" + getImage() + ", getClass()=" + getClass() + ", hashCode()="
			+ hashCode() + ", toString()=" + super.toString() + "]";
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
public int getAvailability() {
	return availability;
}
public void setAvailability(int availability) {
	this.availability = availability;
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
  
}

package com.fssa.medlife.model;

import java.time.LocalDate;

public class Appointment {

	@Override
	public String toString() {
		return "Appointment [user=" + user + ", doctor=" + doctor + ", appointmentDate=" + appointmentDate
				+ ", bookingDate=" + bookingDate + ", status=" + status + "]";
	}
	private User user;
	private Doctor doctor;
	private  LocalDate  appointmentDate;
	private  LocalDate bookingDate;
	private  String status;
	private int doc_id;
	private int id;
	private int user_id;
	
	

	
	public Appointment(User user2, Doctor doctor2, LocalDate appointmentDate2, LocalDate bookingDate2, String status2) {
		this.user = user2;
		this.doctor = doctor2;
		this.appointmentDate = appointmentDate2;
		this.bookingDate = bookingDate2;
		this.status = status2;
	}
	


	public Appointment() {
		// TODO Auto-generated constructor stub
	}



	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public LocalDate  getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = LocalDate.parse(appointmentDate);
	}
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(String bookingDate) {
		this.bookingDate = LocalDate.parse(bookingDate);
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}



	public int getDoc_id() {
		return doc_id;
	}



	public void setDoc_id(int doc_id) {
		this.doc_id = doc_id;
	}



	public int getUser_id() {
		return user_id;
	}



	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
}

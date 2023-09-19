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
	
	
	
	
}

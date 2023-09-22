package com.fssa.medlife.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.fssa.medlife.model.Appointment;
import com.fssa.medlife.model.Doctor;
import com.fssa.medlife.model.User;
import com.fssa.medlife.service.exception.ServiceException;

class TestAppointmentCreateFeature {

	@Test
	void testCreateAppointmentSuccess() {
	    AppointmentService appointmentService = new AppointmentService();
	    User user = new User();
	    user.setUserId(25);
	    Doctor doctor = new Doctor();
	    doctor.setId(1);
	    LocalDate appointmentDate = LocalDate.parse("2023-09-28");
	    LocalDate bookingDate = LocalDate.parse("2023-09-22");
	    System.out.println(appointmentDate);
	    System.out.println(bookingDate);

	    Appointment appointment = new Appointment(user, doctor, appointmentDate, bookingDate, "pending");
	    System.out.println(appointment);

	    try {
	        assertTrue(appointmentService.createAppointment(appointment));
	    } catch (ServiceException e) {
	        e.printStackTrace();
	        fail("Failed to create an appointment");
	    }
	}

}

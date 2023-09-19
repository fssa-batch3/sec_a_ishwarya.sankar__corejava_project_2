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
		doctor.setId(3);

		Appointment appointment = new Appointment(user, doctor, LocalDate.parse("2023-09-16"),
				LocalDate.parse("2023-09-17"), "Confirmed");

		try {
			assertTrue(appointmentService.createAppointment(appointment));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail("Failed to create an appointment");
		}
	}
}

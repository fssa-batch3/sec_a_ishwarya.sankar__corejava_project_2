package com.fssa.medlife.validation;

import java.time.LocalDate;

import com.fssa.medlife.model.Appointment;

import exception.InvalidAppointmentException;

public class AppointmentValidator {

	public AppointmentValidator() {
		// ...
	}

	public boolean validateAppointment(Appointment appointment) throws InvalidAppointmentException {
		if (appointment == null) {
			throw new InvalidAppointmentException("Appointment is null");
		}
		validateBookingDate(appointment.getAppointmentDate());
		validateAppointmentDate(appointment.getAppointmentDate());
		validateStatus(appointment.getStatus());

		return true;
	}


	private boolean validateBookingDate(LocalDate appointmentDate) throws InvalidAppointmentException {
		if (appointmentDate == null) {
			throw new InvalidAppointmentException("Invalid booking date");
		}
		return true;
	}

	private boolean validateAppointmentDate(LocalDate appointmentDate) throws InvalidAppointmentException {
		if (appointmentDate == null) {
			throw new InvalidAppointmentException("Invalid appointment date");
		}
		return true;
	}

	private boolean validateStatus(String status) throws InvalidAppointmentException {
		if (status == null || status.trim().isEmpty()) {
			throw new InvalidAppointmentException("Invalid status");
		}
		return true;
	}
}

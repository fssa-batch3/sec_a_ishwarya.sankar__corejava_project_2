package com.fssa.medlife.validation;

import com.fssa.medlife.model.Doctor;

import exception.InvalidDoctorException;

public class DoctorValidator {
	
	public DoctorValidator() {
		// Default Constructor
	}

	 public void validateDoctor(Doctor doctor) throws InvalidDoctorException {
	        if (doctor == null) {
	            throw new InvalidDoctorException("Doctor is null");
	        }

	       validateDoctorName(doctor.getDoctorname());
	        validateSpecialist(doctor.getSpecialist());
	        validateAvailability(doctor.getStartTime(), doctor.getEndtime());
	        validateExperience(doctor.getExperience());
	        validateImage(doctor.getImage());
	    }

	 public  void validateDoctorName(String doctorName) throws InvalidDoctorException {
	    if (doctorName == null || doctorName.trim().isEmpty() || !doctorName.matches("^[A-Za-z\\s]+$")) {
		        throw new InvalidDoctorException("Invalid Doctor Name");		    }
	    }



	    public static void validateSpecialist(String specialist) throws InvalidDoctorException {
	        if (specialist == null || specialist.trim().isEmpty()) {
	            throw new InvalidDoctorException("Invalid Specialist");
	        }
	    }

	    public static void validateAvailability(String startTime, String endTime) throws InvalidDoctorException {
	        if (startTime == null || startTime.trim().isEmpty() || endTime == null || endTime.trim().isEmpty()) {
	            throw new InvalidDoctorException("Invalid Availability");
	        }
	    }

	    public static void validateExperience(int experience) throws InvalidDoctorException {
	        if (experience < 0) {
	            throw new InvalidDoctorException("Invalid Experience");
	        }
	    }

	    public static void validateImage(String image) throws InvalidDoctorException {
	        if (image == null || image.trim().isEmpty()) {
	            throw new InvalidDoctorException("Invalid Image URL");
	        }
	    }
}

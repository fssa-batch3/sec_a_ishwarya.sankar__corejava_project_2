package com.fssa.medlife.validation;

import com.fssa.medlife.model.Doctor;

import exception.InvalidDoctorException;

public class DoctorValidator {
	
	public DoctorValidator() {
		// Default Constructor
	}

	 public static boolean validateDoctor(Doctor doctor) throws InvalidDoctorException {
	        if (doctor == null) {
	            throw new InvalidDoctorException("Doctor is null");
	        }

	       validateDoctorName(doctor.getDoctorname());
	        validateSpecialist(doctor.getSpecialist());
	        validateAvailability(doctor.getStartTime(), doctor.getEndtime());
	        validateExperience(doctor.getExperience());
	        validateImage(doctor.getImage());
			return true;
	    }

	 public static boolean validateDoctorName(String doctorName) throws InvalidDoctorException {
	    if (doctorName == null || doctorName.trim().isEmpty() || !doctorName.matches("^[A-Za-z\\s]+$")) {
		        throw new InvalidDoctorException("Invalid Doctor Name");		
		        
	    }
	    return true;
	    }



	    public static boolean validateSpecialist(String specialist) throws InvalidDoctorException {
	        if (specialist == null || specialist.trim().isEmpty()) {
	            throw new InvalidDoctorException("Invalid Specialist");
	        }
			return true;
	    }

	    public static boolean validateAvailability(String startTime, String endTime) throws InvalidDoctorException {
	        if (startTime == null || startTime.trim().isEmpty() || endTime == null || endTime.trim().isEmpty()) {
	            throw new InvalidDoctorException("Invalid Availability");
	        }
	        return true;
	    }

	    public static boolean validateExperience(int experience) throws InvalidDoctorException {
	        if (experience < 0) {
	            throw new InvalidDoctorException("Invalid Experience");
	        }
	        return true;
	    }

	    public static boolean validateImage(String image) throws InvalidDoctorException {
	        if (image == null || image.trim().isEmpty()) {
	            throw new InvalidDoctorException("Invalid Image URL");
	        }
	      return true;  
	    }
}

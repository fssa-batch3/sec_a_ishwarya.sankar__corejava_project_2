package com.fssa.medlife.validation;

import com.fssa.medlife.model.Doctordetails;

import exception.InvalidDetailsException;

public class DetailValidator {
	 public static boolean validateDoctor(Doctordetails doctor) throws InvalidDetailsException {
	        if (doctor == null) {
	            throw new InvalidDetailsException("Doctor is null");
	        }

	        if (!validateLicense(doctor.getLicense())) {
	            throw new InvalidDetailsException("Invalid license");
	        }

	        if (!validateCertification(doctor.getCertification())) {
	            throw new InvalidDetailsException("Invalid certification");
	        }

	        if (!validateQualification(doctor.getQualification())) {
	            throw new InvalidDetailsException("Invalid qualification");
	        }

	        if (!validateSpecialist(doctor.getSpecialist())) {
	            throw new InvalidDetailsException("Invalid specialist");
	        }

	        if (!validateExperience(doctor.getExperience())) {
	            throw new InvalidDetailsException("Invalid experience");
	        }

	        if (!validateImage(doctor.getImage())) {
	            throw new InvalidDetailsException("Invalid image URL");
	        }

	        return true;
	    }

	    public static boolean validateLicense(int license) throws InvalidDetailsException {
	        String licenseStr = String.valueOf(license);
	        if (!licenseStr.matches("\\d{8}")) {
	            throw new InvalidDetailsException("Invalid license number");
	        }
	        return true;
	    }

	    public static boolean validateCertification(String certification) throws InvalidDetailsException {
	        if (!certification.matches("^https?://.*$")) {
	            throw new InvalidDetailsException("Certification should be a valid URL");
	        }
	        return true;
	    }

	    public static boolean validateQualification(String qualification) throws InvalidDetailsException {
	        if (qualification == null || qualification.trim().isEmpty()) {
	            throw new InvalidDetailsException("Qualification is required");
	        }
	        if (!qualification.matches("^[a-zA-Z]+$")) {
	            throw new InvalidDetailsException("Invalid qualification format");
	        }
	        return true;
	    }

	    public static boolean validateSpecialist(String specialist) throws InvalidDetailsException {
	        if (specialist == null || specialist.trim().isEmpty()) {
	            throw new InvalidDetailsException("Specialist field is required");
	        }
	        return true;
	    }

	    public static boolean validateExperience(int experience) throws InvalidDetailsException {
	        String experienceStr = String.valueOf(experience);
	        if (!experienceStr.matches("\\d{2}")) {
	            throw new InvalidDetailsException("Invalid experience format");
	        }
	        return true;
	    }

	    public static boolean validateImage(String image) throws InvalidDetailsException {
	        if (!image.matches("^https?://.*$")) {
	            throw new InvalidDetailsException("Image should be a valid URL");
	        }
	        return true;
	    }
}

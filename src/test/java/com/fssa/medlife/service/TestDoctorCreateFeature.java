package com.fssa.medlife.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.medlife.model.Doctor;
import com.fssa.medlife.service.exception.ServiceException;

class TestDoctorCreateFeature {
	  @Test
	    void testAddDoctorSuccess() {
	        DoctorService doctorService = new DoctorService();
	        Doctor doctor = new Doctor("Chandruraj", "Cardiologist", "09:00 AM", "05:00 PM", 10, "https://www.eternalhospital.com/uploadedfiles/gallery/1686978171_Doctor-Images_Resize-262x329-Dr.-Abhishek-Goyal.jpg");

	        try {
	            assertTrue(doctorService.addDoctor(doctor));
	        } catch (ServiceException e) {
	            fail();
	            e.printStackTrace();
	        }
	    }
	    
}

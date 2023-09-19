package com.fssa.medlife.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.medlife.model.Doctor;
import com.fssa.medlife.service.exception.ServiceException;

class TestDoctorCreateFeature {

	  @Test
	    void testAddDoctorSuccess() throws ClassNotFoundException  {
	        DoctorService doctorService = new DoctorService();
	        Doctor doctor = new Doctor("Ishwarya", "Cardiologist", "09:00 AM", "05:00 PM", 10, "https://www.example.com/images/dr-john-doe.jpg");
	        System.out.println(doctor);
	        System.out.println("Dt");
	        
	        try {
	            assertTrue(doctorService.addDoctor(doctor));
	        } catch (ServiceException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    
}

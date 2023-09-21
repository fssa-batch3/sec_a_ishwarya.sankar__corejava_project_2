package com.fssa.medlife.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.medlife.model.Doctor;

import com.fssa.medlife.service.exception.ServiceException;

 class TestDoctorUpdateFeature {

	
	
	 @Test
	 void testUpdateDoctor() {
	     DoctorService doctorService = new DoctorService();
	     Doctor doctor = new Doctor("Chandruraj", "nephrologist", "09.00 AM", "05.00 PM", 10, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSZeEzeqSeG5MwgQd6_tq3q66w-XrYcZ8lZZA&usqp=CAU");

	     try {
	         boolean updateResult = doctorService.updateDoctor(doctor, 1);
	         assertTrue(updateResult);
	     } catch (ServiceException e) {
	         e.printStackTrace();
	         fail("Failed to update doctor: " + e.getMessage());
	     }
	 }

}
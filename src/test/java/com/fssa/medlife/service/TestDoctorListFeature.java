package com.fssa.medlife.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fssa.medlife.model.Doctor;
import com.fssa.medlife.service.exception.ServiceException;

public class TestDoctorListFeature {
	@Test
	void testListAllMedicine() {
		DoctorService doctorservice = new DoctorService();
		List<Doctor> listDoctors;
		
		try {
			listDoctors = doctorservice.getAllDoctors();
			assertNotNull(listDoctors);
			System.out.println(listDoctors.toString());
		} catch (ServiceException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

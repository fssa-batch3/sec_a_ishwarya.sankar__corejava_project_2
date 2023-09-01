package com.fssa.medlife.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.medlife.model.Medicine;
import com.fssa.medlife.service.exception.ServiceException;


class TestMedicineUpdateFeature {
 
	  @Test
	    void testUpdateMedicine() {
	        MedicineService medicineService = new MedicineService();
	        
	        // Create a sample medicine with updated properties
	        Medicine medicine = new Medicine("newmed", 100, "http://updated.example.com");
	        
	        try {
	            assertTrue(medicineService.updateMedicine(medicine,29));
	        } catch (ServiceException e) {
	            e.printStackTrace();
	           
	        }
	    }

	  @Test
	    void testUpdateMedicineNotFound() {
	        MedicineService medicineService = new MedicineService();
	        
	        // Create a sample medicine with updated properties
	        Medicine medicine = new Medicine("UpdatedMedicineName", 100, "http://updated.example.com");
	        
	        try {
	            assertFalse(medicineService.updateMedicine(medicine, -1)); // Use a non-existent ID
	        } catch (ServiceException e) {
	            e.printStackTrace();
	            fail();
	        }
	    }
	    
	    @Test
	    void testUpdateMedicineInvalidData() {
	        MedicineService medicineService = new MedicineService();
	        
	        // Create a sample medicine with invalid properties (negative rupees)
	        Medicine medicine = new Medicine("InvalidMedicineName", -100, "http://invalid.example.com");
	        
	        try {
	            assertFalse(medicineService.updateMedicine(medicine, 1));
	        } catch (ServiceException e) {
	            e.printStackTrace();
	            fail();
	        }
	    }

}
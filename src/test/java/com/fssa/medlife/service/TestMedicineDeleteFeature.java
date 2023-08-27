package com.fssa.medlife.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.medlife.exception.DAOException;
import com.fssa.medlife.exception.ValidatorException;
import com.fssa.medlife.model.Medicine;
import com.fssa.medlife.service.exception.ServiceException;


public class TestMedicineDeleteFeature {
	 @Test
	    void testDeleteMedicineWithValidInput() throws DAOException, ValidatorException, ServiceException {
	        // Create an instance of the MedicineService class
	        MedicineService medicineService = new MedicineService();
	        // Create a sample medicine to be deleted
	        int id = 29;
	        // assertDoesNotThrow to test that no exceptions are thrown during this code block
            // This is the method being tested to see if it can delete a medicine without throwing an exception.
	        assertTrue(MedicineService.deleteMedicine(id));
	        // Verify that the medicine has been deleted  
	    } 
	
	 
	 @Test
	    void testDeleteMedicineWithInValidInput() throws DAOException, ValidatorException, ServiceException {
	        // Create an instance of the MedicineService class
	        MedicineService medicineService = new MedicineService();

	        // Create a sample medicine to be deleted
	        int id = 1;
	        assertFalse(MedicineService.deleteMedicine(id));
	    }
}
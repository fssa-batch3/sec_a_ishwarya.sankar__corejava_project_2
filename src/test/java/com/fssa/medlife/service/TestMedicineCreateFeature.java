package com.fssa.medlife.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.fssa.medlife.exception.ValidatorException;
import com.fssa.medlife.model.Medicine;

public class TestMedicineCreateFeature {
	
	
	 @Test
	    void testCreateMedicineWithValidInput() {
		   // Create an instance of the MedicineService class

	        MedicineService medicineService = new MedicineService();
	        // MODEL OF MEDICINE I CREATE AN OBJECT
	        Medicine newMedicine = new Medicine();
	        newMedicine.setMedicineName("sas Syrup");
	        newMedicine.setMedicineRupees(50);
	        newMedicine.setUserID(4);
	        newMedicine.setMedicineUrl("https://example.com/paracetamol");
	        // assertDoesNotThrow to test that no exceptions are thrown during this code block

	        assertDoesNotThrow(() -> {
	        	//This is the method being tested to see if it can handle valid input without throwing an exception.
	            medicineService.addMedicine(newMedicine);
	        });
	    }

	 
	    @Test
	    void testCreateMedicineWithInvalidInput() {
	    	//n instance of the MedicineService class is created. 
	        MedicineService medicineService = new MedicineService();
	        Exception exception = assertThrows(Exception.class, () -> {
	            medicineService.addMedicine(null);
	        });
	        String expectedMessage = "Medicine Object cannot be null";
	        String actualMessage = exception.getMessage();
	        assertEquals(expectedMessage, actualMessage);
	    }
	    
	    @Test
	    void testCreateMedicineWithNameNull() {
	        MedicineService medicineService = new MedicineService();
	        Medicine newMedicine = new Medicine();
	        newMedicine.setMedicineName(null);
	        newMedicine.setMedicineRupees(50);
	        newMedicine.setUserID(4);
	        newMedicine.setMedicineUrl("https://example.com/paracetamol");
	        // assertThrows to test that a ValidatorException is thrown during this code block

	        Exception exception = assertThrows(ValidatorException.class, () -> {
	               // Call the addMedicine method of the medicineService, passing the newMedicine object
	            medicineService.addMedicine(newMedicine);
	        });
	        String expectedMessage = "Medicine Name cannot be null or empty";
	        
	        String actualMessage = exception.getMessage();
	        //    // Use assertEquals to compare the expected and actual exception messages
	        assertEquals(expectedMessage, actualMessage);
	    }
	    
	    @Test
	    void testCreateMedicineWithNegativeRupees() {
	        MedicineService medicineService = new MedicineService();
	        Medicine newMedicine = new Medicine();
	        newMedicine.setMedicineName("Paracetamol");
	        newMedicine.setMedicineRupees(-50);
	        newMedicine.setUserID(4);
	        newMedicine.setMedicineUrl("https://example.com/paracetamol");
	        Exception exception = assertThrows(ValidatorException.class, () -> {
	            medicineService.addMedicine(newMedicine);
	        });
	        String expectedMessage = "Medicine rupees can not be zero or less than zero";
	        String actualMessage = exception.getMessage();
	        assertEquals(expectedMessage, actualMessage);
	    }
}

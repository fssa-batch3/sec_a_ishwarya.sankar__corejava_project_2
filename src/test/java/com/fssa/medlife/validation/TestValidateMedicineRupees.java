//package com.fssa.medlife.validation;
//
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.junit.jupiter.api.Assertions.fail;
//
//import org.junit.jupiter.api.Test;
//
//import com.fssa.medlife.exception.ValidatorException;
//
//public class TestValidateMedicineRupees{
//
//	
//	@Test
//	void validMedicineRupees() {
//	    try {
//	        MedicineValidator.validateMedicineRupees(50); // Assuming 50.0 is a valid medicine cost
//	        assertTrue(true, "Test Case Passed: Valid medicine rupees");
//	    } catch (ValidatorException e) {
//	        fail("Test Case Failed: Valid medicine rupees");
//	    }
//	}
//
//	
//	
//	@Test
//	void negativeMedicineRupees() {
//	    try {
//	        MedicineValidator.validateMedicineRupees(-10.0); // Assuming -10.0 is not a valid medicine cost
//	        fail("Test Case Failed: Negative medicine rupees");
//	    } catch (ValidatorException e) {
//	    	assertFalse(e.getMessage().equals("Medicine Rupees cannot be negative"), "Test Case Passed: Negative medicine rupees");
//	    }
//	}
//
//	@Test
//	void zeroMedicineRupees() {
//	    try {
//	        MedicineValidator.validateMedicineRupees(0);
//	        fail("Test Case Failed: Zero medicine rupees");
//	    } catch (ValidatorException e) {
//	        assertFalse(e.getMessage().equals("Medicine Rupees should be greater than 0"), "Test Case Passed: Zero medicine rupees");
//	    }
//	}
//}
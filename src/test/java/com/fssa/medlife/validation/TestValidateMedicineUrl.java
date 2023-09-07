package com.fssa.medlife.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.medlife.exception.ValidatorException;

import exception.InvalidMedicineException;

public class TestValidateMedicineUrl {
	@Test
	void validMedicineUrl() {
	    try {
	        assertTrue(MedicineValidator.validateMedicineUrl("https://www.example.com/medicine"));
	        System.out.println("Valid medicine URL test passed.");
	    } catch ( InvalidMedicineException e) {
	        e.printStackTrace();
	        fail("Test Case Failed: Valid medicine URL");
	    }
	}

	
	
	@Test
	void nullMedicineUrl() {
	    try {
	    	assertTrue(MedicineValidator.validateMedicineUrl(null));
	        System.out.println("Invalid null medicine URL test passed.");
	    } catch (  InvalidMedicineException e) {
	        e.printStackTrace();
	    }
	}

	@Test
	void emptyMedicineUrl() {
	    try {
	    	assertTrue(MedicineValidator.validateMedicineUrl(""));
	        System.out.println("Invalid empty medicine URL test passed.");
	    } catch (  InvalidMedicineException e) {
	    	 
	        e.printStackTrace();
	      
	    }
	}

	@Test
	void invalidMedicineUrl() {
	    try {
	        assertTrue(MedicineValidator.validateMedicineUrl("invalidurl"));
	        System.out.println("Invalid medicine URL format test passed.");
	    } catch (InvalidMedicineException e) {
	    	 fail();
	        e.printStackTrace();
	        
	       
	    }
	}

	@Test
	void validMedicineUrlWithParameters() {
	    try {
	        assertTrue(MedicineValidator.validateMedicineUrl("https://www.example.com/medicine?id=123"));
	        System.out.println("Valid medicine URL with parameters test passed.");
	    } catch ( InvalidMedicineException e) {
	    	
	        e.printStackTrace();
	      
	    }
	}
}

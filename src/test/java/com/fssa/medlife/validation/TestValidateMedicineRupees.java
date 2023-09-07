package com.fssa.medlife.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.medlife.exception.ValidatorException;

import exception.InvalidMedicineException;
import exception.InvalidUserException;

public class TestValidateMedicineRupees{

	  @Test
	     void testValidMedicineName() {
	        try {
	            assertTrue(MedicineValidator.validateMedicineName("Himalaya Syrup"));
	            System.out.println("Valid password test passed.");
	        } catch (InvalidMedicineException e) {
	            e.printStackTrace();
	            fail("Caught InvalidUserException for a valid password.");
	        }
	    }
	  @Test
	  void testInvalidMedicineNameTooShort() {
	      try {
	          assertTrue(MedicineValidator.validateMedicineName("Ab")); // Name is too short
	          System.out.println("Invalid medicine name (too short) test passed.");
	        
	      } catch (InvalidMedicineException e) {
	    	  fail();
	          e.printStackTrace();
	      }
	  }

	  @Test
	  void testInvalidMedicineNameTooLong() {
	      try {
	    	  assertTrue(MedicineValidator.validateMedicineName("ThisIsAReallyLongMedicineNameThatExceedsTheMaxLength")); // Name is too long
	          System.out.println("Invalid medicine name (too long) test passed.");
	         
	      } catch (InvalidMedicineException e) {
	    	  fail();
	          e.printStackTrace();
	      }
	  }

	  
	  @Test
	  void testInvalidMedicineNameWithSpecialCharacters() {
	      try {
	    	  assertTrue(MedicineValidator.validateMedicineName("Medicine@Name")); // Name contains special characters
	          System.out.println("Invalid medicine name (with special characters) test passed.");
	          
	      } catch (InvalidMedicineException e) {
	    	  fail();
	          e.printStackTrace();
	      }
	  }

	  @Test
	  void testInvalidMedicineNameWithNumbers() {
	      try {
	          assertTrue(MedicineValidator.validateMedicineName("Medicine123")); // Name contains numbers
	          System.out.println("Invalid medicine name (with numbers) test passed.");
	        
	      } catch (InvalidMedicineException e) {
	    	  fail();
	          e.printStackTrace();
	      }
	  }
}

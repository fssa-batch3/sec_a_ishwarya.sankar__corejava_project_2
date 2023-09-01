//package com.fssa.medlife.validation;
//
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.junit.jupiter.api.Assertions.fail;
//
//import org.junit.jupiter.api.Test;
//
//import com.fssa.medlife.exception.ValidatorException;
//
//public class TestValidateMedicineUrl {
//	 @Test
//	    void validMedicineUrl() {
//	        try {
//	        	MedicineValidator.validateMedicineUrl("https://www.example.com/medicine");
//	            assertTrue(true, "Test Case Passed: Valid medicine URL");
//	        } catch (ValidatorException e) {
//	            fail("Test Case Failed: Valid medicine URL");
//	        }
//	    }
//	 
//
//	    @Test
//	    void nullMedicineUrl() {
//	        try {
//	        	MedicineValidator.validateMedicineUrl(null);
//	            fail("Test Case Failed: Medicine URL is null");
//	        } catch (ValidatorException e) {
//	            assertTrue(e.getMessage().equals("Medicine URL cannot be null or empty"), "Test Case Passed: Medicine URL is null");
//	        }
//	    }
//
//	    @Test
//	    void emptyMedicineUrl() {
//	        try {
//	        	MedicineValidator.validateMedicineUrl("");
//	            fail("Test Case Failed: Medicine URL is empty");
//	        } catch (ValidatorException e) {
//	            assertTrue(e.getMessage().equals("Medicine URL cannot be null or empty"), "Test Case Passed: Medicine URL is empty");
//	        }
//	    }
//
//	    @Test
//	    void invalidMedicineUrl() {
//	        try {
//	        	MedicineValidator.validateMedicineUrl("invalidurl");
//	            fail("Test Case Failed: Invalid medicine URL format");
//	        } catch (ValidatorException e) {
//	            assertTrue(e.getMessage().equals("Invalid Medicine URL format"), "Test Case Passed: Invalid medicine URL format");
//	        }
//	    }
//
//	    @Test
//	    void validMedicineUrlWithParameters() {
//	        try {
//	        	MedicineValidator.validateMedicineUrl("https://www.example.com/medicine?id=123");
//	            assertTrue(true, "Test Case Passed: Valid medicine URL with parameters");
//	        } catch (ValidatorException e) {
//	            fail("Test Case Failed: Valid medicine URL with parameters");
//	        }
//	    }
//}

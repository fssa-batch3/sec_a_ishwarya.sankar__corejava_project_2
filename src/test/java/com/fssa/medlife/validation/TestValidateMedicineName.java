//package com.fssa.medlife.validation;
//
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.junit.jupiter.api.Assertions.fail;
//
//import org.junit.jupiter.api.Test;
//
//import com.fssa.medlife.exception.ValidatorException;
//
//class MedicineValidatorTest {
//
//    @Test
//    void validMedicineName() {
//        try {
//        	MedicineValidator.validateMedicineName("Paracetamol");
//            assertTrue(true, "Test Case Passed: Valid medicine name");
//        } catch (ValidatorException e) {
//            fail("Test Case Failed: Valid medicine name");
//        }
//    }
//    
//
//    
//    @Test
//    void shortMedicineName() {
//        try {
//        	MedicineValidator.validateMedicineName("Ty");
//            fail("Test Case Failed: Medicine name has less than 3 characters");
//        } catch (ValidatorException e) {
//            assertTrue(e.getMessage().equals("Medicine Name should be at least 3 characters long"), "Test Case Passed: Medicine name has less than 3 characters");
//        }
//    }
//    
//
//    @Test
//    void nonAlphabeticMedicineName() {
//        try {
//        	MedicineValidator.validateMedicineName("123Medicine");
//            fail("Test Case Failed: Medicine name contains non-alphabetic characters");
//        } catch (ValidatorException e) {
//            assertTrue(e.getMessage().equals("Medicine Name should only contain alphabetic characters"), "Test Case Passed: Medicine name contains non-alphabetic characters");
//        }
//    }
//
//    @Test
//    void validAlphabeticMedicineName() {
//        try {
//        	MedicineValidator.validateMedicineName("Aspirin");
//            assertTrue(true, "Test Case Passed: Medicine name with valid alphabetic characters");
//        } catch (ValidatorException e) {
//            fail("Test Case Failed: Medicine name with valid alphabetic characters");
//        }
//    }
//}
//

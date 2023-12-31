package com.fssa.medlife.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import exception.InvalidUserException;


public class TestValidatePassword {
	UserValidator userValidator = new UserValidator();

	  @Test
	     void testValidPassword() {
	        try {
	            assertTrue(userValidator.validatePassword("Password@123"));
	            System.out.println("Valid password test passed.");
	        } catch (InvalidUserException e) {
	            e.printStackTrace();
	            fail("Caught InvalidUserException for a valid password.");
	        }
	    }

	    @Test
	     void testInvalidPasswordWithoutNumbers() {
	        try {
	            assertFalse(userValidator.validatePassword("Password@"));
	            System.out.println("Invalid password without numbers test passed.");
	            fail();
	        } catch (InvalidUserException e) {
	            e.printStackTrace();
	        }
	    }
	    

	    @Test
	     void testInvalidPasswordWithoutSpecialCharacters() {
	        try {
	            assertFalse(userValidator.validatePassword("password123"));
	            System.out.println("Invalid password without special characters test passed.");
	            fail();
	        } catch (InvalidUserException e) {
	            e.printStackTrace();
	        }
	    }

	    @Test
	     void testInvalidPasswordWithoutCapitalLetters() {
	        try {
	            assertFalse(userValidator.validatePassword("password123"));
	            System.out.println("Invalid password without capital letters test passed.");
	            fail();
	        } catch (InvalidUserException e) {
	            e.printStackTrace();
	        }
	    }

	    @Test
	     void testInvalidPasswordWithoutAnyLetters() {
	        try {
	            assertFalse(userValidator.validatePassword(""));
	            System.out.println("Invalid password without Any letters test passed.");
	            fail();
	        } catch (InvalidUserException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    @Test
	     void testInvalidPasswordWithoutSmallLetters() {
	        try {
	            assertFalse(userValidator.validatePassword("PASSWORD@123"));
	            System.out.println("Invalid password without small letters test passed.");
	            fail();
	        } catch (InvalidUserException e) {
	            e.printStackTrace();
	        }
	    }

	    @Test
	     void testInvalidPasswordShorterLength() {
	        try {
	            assertFalse(userValidator.validatePassword("Pas@123"));
	            System.out.println("Invalid password shorter length test passed.");
	            fail();
	        } catch (InvalidUserException e) {
	            e.printStackTrace();
	        }
	    }
}

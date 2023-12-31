package com.fssa.medlife.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import exception.InvalidUserException;

public class TestValidatePhoneNumber {
	UserValidator userValidator = new UserValidator();

	@Test
	 void testValidPhoneNumber() {
		try {
			assertTrue(userValidator.validatePhoneNumber("+919876543210"));
			System.out.println("Valid phone number test passed.");
		} catch (InvalidUserException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	 void testValidPhoneNumberWithoutCountryCode() {
		try {
			assertTrue(userValidator.validatePhoneNumber("9876543210"));
			System.out.println("Valid phone number without country code test passed.");
		} catch (InvalidUserException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	 void testInvalidPhoneNumberWithInvalidCountryCode() {
		try {
			assertFalse(userValidator.validatePhoneNumber("+920987654321"));
			System.out.println("Invalid phone number with invalid country code test passed.");
			fail();
		} catch (InvalidUserException e) {
			e.printStackTrace();
		}
	}

	@Test
	 void testInvalidPhoneNumberWithInvalidLength() {
		try {
			assertFalse(userValidator.validatePhoneNumber("987654321"));
			System.out.println("Invalid phone number with invalid length test passed.");
			fail();
		} catch (InvalidUserException e) {
			e.printStackTrace();
		}
	}

	@Test
	 void testInvalidPhoneNumberWithNonNumericCharacters() {
		try {
			assertFalse(userValidator.validatePhoneNumber("9876abcd12"));
			System.out.println("Invalid phone number with non-numeric characters test passed.");
			fail();
		} catch (InvalidUserException e) {
			e.printStackTrace();
		}
	}
}

package com.fssa.medlife.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import exception.InvalidUserException;

public class TestValidateUserName {
	UserValidator userValidator = new UserValidator();
	@Test
	 void testValidUserName() {
		try {
			
			assertTrue(userValidator.validateName("ValidUserName"));
			System.out.println("Valid user name test passed.");
		} catch (InvalidUserException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	 void testInvalidUserNameStartingWithNumber() {
		try {
			assertFalse(userValidator.validateName("123InvalidUserName"));
			System.out.println("Invalid user name starting with a number test passed.");
			fail();
		} catch (InvalidUserException e) {
			e.printStackTrace();
		}
	}

	@Test
	 void testInvalidUserNameShorterLength() {
		try {
			assertFalse(userValidator.validateName("Ab"));
			System.out.println("Invalid user name shorter length test passed.");
			fail();
		} catch (InvalidUserException e) {
			e.printStackTrace();
		}
	}

	@Test
	 void testInvalidUserNameLongerLength() {
		try {
			assertFalse(userValidator.validateName("ThisIsAVeryLongUserNameThatExceedsTheLimit"));
			System.out.println("Invalid user name longer length test passed.");
			fail();
		} catch (InvalidUserException e) {
			e.printStackTrace();
		}
	}

	@Test
	 void testInvalidUserNameWithSpaces() {
		try {
			assertFalse(userValidator.validateName("Invalid User Name"));
			System.out.println("Invalid user name with spaces test passed.");
			fail();
		} catch (InvalidUserException e) {
			e.printStackTrace();
		}
	}

	
	@Test
	 void testInvalidUserNameWithSpecialCharacters() {
		try {
			assertFalse(userValidator.validateName("Invalid$UserName"));
			System.out.println("Invalid user name with special characters test passed.");
			fail();
		} catch (InvalidUserException e) {
			e.printStackTrace();
		}
	}
}

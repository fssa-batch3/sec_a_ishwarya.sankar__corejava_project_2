package com.fssa.medlife.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.medlife.model.User;
import com.fssa.medlife.service.exception.ServiceException;

public class TestUserRegisterFeature {
	@Test
	 void testRegistrationSuccess() {
		UserService userService = new UserService();
		// email is not repeating so give unique email
		//********************** Important ******************
		// change userID , Email
		//***************************************************
		
		User user1 = new User(14, "sankar14@gmail.com", "ishusankar", "Ishu@123", "8072404562", "Doctor");
		try {
			assertTrue(userService.registerUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	 void testRegistrationNullPassword() {
		UserService userService = new UserService();
		User user = new User(15, "JohnDoe", null, "john@example.com", "8565473543", "user");
		try {
			userService.registerUser(user);
			fail("Expected ServiceException for null password, but none was thrown.");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	 void testRegistrationNullUser() {
		UserService userService = new UserService();
		try {
			userService.registerUser(null);
			fail("Expected ServiceException for null user, but none was thrown.");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

}

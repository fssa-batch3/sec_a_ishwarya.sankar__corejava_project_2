package com.fssa.medlife.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.medlife.model.User;
import com.fssa.medlife.service.exception.ServiceException;

public class TestUserRegisterFeature {
	
	
	//
	@Test
	 void testRegistrationSuccess() {
		UserService userService = new UserService();
		
		// email is not repeating so give unique email
		//********************** Important ******************
		// change userID , Email
		//***************************************************
		
		User user1 = new User( "abinaya14@gmail.com", "Abinaya", "Abi15@", "9940947444", "doctor");
		try {
			assertTrue(userService.registerUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
	//
	@Test
	 void testRegistrationNullPassword() {
		UserService userService = new UserService();
		User user = new User( "JohnDoe", null, "john@example.com", "8565473543", "user");
		try {
			userService.registerUser(user);
			fail("Expected ServiceException for null password, but none was thrown.");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	//
	
	@Test
	 void testRegistrationNullUser() {
		UserService userService = new UserService();
		User user = new User( null, "JohnDoe", "john@example.com", "8565473543", "user");
		try {
			userService.registerUser(user);
			fail("Expected ServiceException for null user, but none was thrown.");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
//
	
}

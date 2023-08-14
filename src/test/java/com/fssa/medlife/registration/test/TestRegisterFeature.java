package com.fssa.medlife.registration.test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.medlife.registration.model.User;
import com.fssa.medlife.registration.serviceexception.ServiceException;
import com.fssa.medlife.registration.userservice.UserService;

public class TestRegisterFeature {
//
//	public static void main(String[] args) {
//	    // Assuming you have a database table named "users" with the following columns:
//	    // (userId, email, userName, password, phone_number, type)
//	    
//	    User user1 = new User(4, "isu123@gmail.com", "Ishwarya", "Ishu@123", "8072404562", "user");
//	    UserService userService = new UserService();
//	    
//	    try {
//	        userService.registerUser(user1);
//	        System.out.println("User registered successfully.");
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	        // Handle the exception appropriately
//	    }
//	}
//
//	
////	@Test
////    public void testRegistrationSuccess() {
////		public static void main(String[]args) {
////        UserService userService = new UserService();
////        User user1 = new User(4, "isu123@gmail.com", "Ishwarya", "Ishu@123", "8072404562", "user");
////        try {
////            assertTrue(userService.registerUser(user1));
////        } catch (ServiceException e) {
////            e.printStackTrace();
////            
////        }
////    }
//	public static void main(String[] args) {
//// (userId, email, userName, password, phone_number , type) VALUES (?, ?, ?, ?, ?, ?)";
//		User user1 = new User(4, "isu123@gmail.com", "Ishwarya", "Ishu@123", "8072404562", "user");
//		UserService userService = new UserService();
//		try {
//			userService.registerUser(user1);
//		} catch (Exception e) {
//			e.printStackTrace();
//			fail();
//		}
//	}

	@Test
	public void testValidUserRegistration() {
		  
	    User user1 = new User(4, "isu123@gmail.com", "Ishwarya", "Ishu@123", "8072404562", "user");
	    UserService userService = new UserService();
	    
	    try {
	       assertTrue( userService.registerUser(user1));
	        System.out.println("User registered successfully.");
	    } catch (Exception e) {
	        e.printStackTrace();
	      fail();
	    }
	}

//	    @Test
//	    public void testRegistrationEmailEmpty() {
//	        UserService userService = new UserService();
//	        User user1 = new User(2, "", "Babu", "Babu@123", "9876543123", "user");
//	        try {
//	            userService.registerUser(user1);
//	            fail();
//	        } catch (ServiceException e) {
//	            e.printStackTrace();
//	        }
//	    }
//
//	    @Test
//	    public void testRegistrationPhoneNumberInvalid() {
//	        UserService userService = new UserService();
//	        User user1 = new User(3, "babu@gmail.com", "Babu", "Babu@123", "987654h123", "user");
//	        try {
//	            userService.registerUser(user1);
//	            fail();
//	        } catch (ServiceException e) {
//	            e.printStackTrace();
//	        }
//	    }
//
//	    @Test
//	    public void testRegistrationEmptyPassword() {
//	        UserService userService = new UserService();
//	        User user = new User(4, "JohnDoe", "", "john@example.com", "8565473543", "user");
//	        try {
//	            userService.registerUser(user);
//	            fail("Expected ServiceException for empty password, but none was thrown.");
//	        } catch (ServiceException e) {
//	            e.printStackTrace();
//	        }
//	    }
//
//	    @Test
//	    public void testRegistrationNullPassword() {
//	        UserService userService = new UserService();
//	        User user = new User(5, "JohnDoe", null, "john@example.com", "8565473543", "user");
//	        try {
//	            userService.registerUser(user);
//	            fail("Expected ServiceException for null password, but none was thrown.");
//	        } catch (ServiceException e) {
//	            e.printStackTrace();
//	        }
//	    }
//
//	    @Test
//	    public void testRegistrationEmptyUsername() {
//	        UserService userService = new UserService();
//	        User user = new User(6, "", "P@ssw0rd", "john@example.com", "8565473543", "user");
//	        try {
//	            userService.registerUser(user);
//	            fail("Expected ServiceException for empty username, but none was thrown.");
//	        } catch (ServiceException e) {
//	            e.printStackTrace();
//	        }
//	    }
//
//	    @Test
//	    public void testRegistrationNullUser() {
//	        UserService userService = new UserService();
//	        try {
//	            userService.registerUser(null);
//	            fail("Expected ServiceException for null user, but none was thrown.");
//	        } catch (ServiceException e) {
//	            e.printStackTrace();
//	        }
//	    }
}

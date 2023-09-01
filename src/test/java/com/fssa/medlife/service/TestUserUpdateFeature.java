package com.fssa.medlife.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.fssa.medlife.model.User;
import com.fssa.medlife.service.exception.ServiceException;

  public class TestUserUpdateFeature {

	  @Test
	    void testUpdateSuccess() {
	        UserService userService = new UserService();
	        
	        // Create a User object with updated information
	        User updatedUser = new User("abinaya21@gmail.com", "Updated Name", "UpdatedPassword", "9876543210", "updatedOccupation", false);
	        
	        try {
	            // Call the updateUser method and check if it returns true
	            assertTrue(userService.updateUser(updatedUser, "abinaya21@gmail.com"));
	        } catch (ServiceException e) {
	            // If an exception is thrown, fail the test
	            e.printStackTrace();
	            fail();
	        }
	    }
	  


    

    @Test
     void testUpdateEmailNotFound() throws SQLException {
        UserService userService = new UserService();
        User user1 = new User("maha12@gmail.com", "MahaKanmani", "Navee@123", "8072444056", "user", false);
        try {
            // Assuming the user with email "maha12@gmail.com" does not exist in the system
            userService.updateUser(user1, "noemail@gmail.com");
            fail("Expected ServiceException for email not found, but none was thrown.");
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
     void testUpdateInvalidEmailFormat() throws SQLException {
        UserService userService = new UserService();
        User user1 = new User("maha12@gmail.com", "MahaKanmani", "Navee@123", "8072444056", "user", false);
        try {
            // Assuming "invalid_email_format" is not a valid email format
            userService.updateUser(user1, "invalidemailformat");
            fail("Expected ServiceException for invalid email format, but none was thrown.");
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
     void testUpdateMissingRequiredField() throws SQLException {
        UserService userService = new UserService();
        // Leaving the name field empty
        User user1 = new User( "maha12@gmail.com", "", "Navee@123", "8072444056", "user", false);
        try {
            userService.updateUser(user1, "maha12@gmail.com");
            fail("Expected ServiceException for missing required field, but none was thrown.");
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}


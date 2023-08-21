package com.fssa.medlife.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.fssa.medlife.dao.*;
import com.fssa.medlife.exception.*;
import com.fssa.medlife.model.*;
import com.fssa.medlife.service.exception.ServiceException;
import com.fssa.medlife.validation.*;

  public class TestUserUpdateFeature {

    @Test
     void testUpdateSuccess() throws SQLException {
        UserService userService = new UserService();
        User user1 = new User(3, "maha122@gmail.com", "Mahasenthil", "Naveena@123", "9888844056", "user", false);
        try {
            assertTrue(userService.updateUser(user1, "maha12@gmail.com"));
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
     void testUpdateEmailNotFound() throws SQLException {
        UserService userService = new UserService();
        User user1 = new User(1, "maha12@gmail.com", "MahaKanmani", "Navee@123", "8072444056", "user", false);
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
        User user1 = new User(1, "maha12@gmail.com", "MahaKanmani", "Navee@123", "8072444056", "user", false);
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
        User user1 = new User(1, "maha12@gmail.com", "", "Navee@123", "8072444056", "user", false);
        try {
            userService.updateUser(user1, "maha12@gmail.com");
            fail("Expected ServiceException for missing required field, but none was thrown.");
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}


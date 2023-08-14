package com.fssa.medlife.registration.test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.fssa.medlife.registration.daoexception.*;
import com.fssa.medlife.registration.model.*;
import com.fssa.medlife.registration.serviceexception.*;
import com.fssa.medlife.registration.userdao.*;
import com.fssa.medlife.registration.userservice.*;
import com.fssa.medlife.registration.validation.*;

public class TestUpdateFeature {

    @Test
    public void testUpdateSuccess() throws SQLException {
        UserService userService = new UserService();
        User user1 = new User(3, "maha122@gmail.com", "Mahasenthil", "Naveena@123", "9888844056", "user");
        try {
            assertTrue(userService.updateUser(user1, "maha12@gmail.com"));
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdateEmailNotFound() throws SQLException {
        UserService userService = new UserService();
        User user1 = new User(1, "maha12@gmail.com", "MahaKanmani", "Navee@123", "8072444056", "user");
        try {
            // Assuming the user with email "maha12@gmail.com" does not exist in the system
            userService.updateUser(user1, "noemail@gmail.com");
            fail("Expected ServiceException for email not found, but none was thrown.");
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdateInvalidEmailFormat() throws SQLException {
        UserService userService = new UserService();
        User user1 = new User(1, "maha12@gmail.com", "MahaKanmani", "Navee@123", "8072444056", "user");
        try {
            // Assuming "invalid_email_format" is not a valid email format
            userService.updateUser(user1, "invalidemailformat");
            fail("Expected ServiceException for invalid email format, but none was thrown.");
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdateMissingRequiredField() throws SQLException {
        UserService userService = new UserService();
        // Leaving the name field empty
        User user1 = new User(1, "maha12@gmail.com", "", "Navee@123", "8072444056", "user");
        try {
            userService.updateUser(user1, "maha12@gmail.com");
            fail("Expected ServiceException for missing required field, but none was thrown.");
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}


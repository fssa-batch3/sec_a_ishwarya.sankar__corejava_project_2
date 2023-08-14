package com.fssa.medlife.registration.test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.medlife.registration.daoexception.*;
import com.fssa.medlife.registration.model.*;
import com.fssa.medlife.registration.serviceexception.*;
import com.fssa.medlife.registration.userdao.*;
import com.fssa.medlife.registration.userservice.*;

public class TestLogin {

    @Test
    public void loginSuccess() {
        UserService userService = new UserService();
        String email = "maha122@gmail.com";
        String password = "Navee@123";
        User user1 = new User(email, password);
        try {
            assertTrue(userService.loginUser(user1, email));
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void loginFailed() {
        UserService userService = new UserService();
        String email = "ahkbkj@gmail.com";
        String password = "Password@796";
        User user2 = new User(email, password);
        try {
            userService.loginUser(user2, email);
            fail();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testLoginEmailCheck() {
        UserService userService = new UserService();
        String email = "invalidemail"; // Invalid email format
        String password = "Navee@123";
        User user1 = new User(email, password);
        try {
            userService.loginUser(user1, email); // Expecting login failure
            fail("Login with invalid email format should fail.");
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testLoginNullUser() {
        UserService userService = new UserService();
        try {
            userService.loginUser(null, "maha12@gmail.com"); // Expecting login failure
            fail();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}

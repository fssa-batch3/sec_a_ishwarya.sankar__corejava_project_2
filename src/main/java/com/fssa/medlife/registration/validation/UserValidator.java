package com.fssa.medlife.registration.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.medlife.registration.invaliduserexception.InvalidUserException;
import com.fssa.medlife.registration.model.User;

public class UserValidator {
    public static boolean validateUser(User user) throws InvalidUserException {
        if (user != null && validateUserID(user.getUserId()) && validateName(user.getUsername()) &&
                validatePassword(user.getPassword()) && validateEmail(user.getEmail()) && validatePhoneNumber(user.getPhonenumber())) {
            return true;
        } else {
            throw new InvalidUserException("User details not valid");
        }
    }

    public static boolean validateUserID(int userId) throws InvalidUserException {
        if (userId < 0) {
            throw new InvalidUserException("User ID is invalid: Negative value.");
        }

        String regexUserID = "^[0-9]+$";
        boolean match = Pattern.matches(regexUserID, Integer.toString(userId));

        if (match) {
            System.out.println("User ID is valid.");
        } else {
            throw new InvalidUserException("User ID is invalid: Only non-negative numbers are allowed.");
        }

        return match;
    }

    public static boolean validateName(String name) throws InvalidUserException {
        if (name == null) {
            throw new InvalidUserException("Name is null.");
        }

        String regex = "^[A-Za-z]\\w{2,29}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);
        boolean isMatch = matcher.matches();

        if (isMatch) {
            System.out.println("The user name is valid.");
        } else {
            throw new InvalidUserException("The user name is not valid");
        }

        return isMatch;
    }

    public static boolean validatePassword(String password) throws InvalidUserException {
        if (password == null) {
            throw new InvalidUserException("Password is null.");
        }

        String patternString = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[^\\s]).{8,}$";
        boolean isMatch = Pattern.matches(patternString, password);

        if (isMatch) {
            System.out.println("Valid password.");
        } else {
            throw new InvalidUserException("Invalid password.");
        }

        return isMatch;
    }

    public static boolean validateEmail(String email) throws InvalidUserException {
        if (email == null) {
            throw new InvalidUserException("Email is null.");
        }

        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        boolean isMatch = Pattern.matches(regex, email);

        if (isMatch) {
            System.out.println("The email address is: Valid");
        } else {
            throw new InvalidUserException("The email address is: Invalid");
        }
        return isMatch;
    }

    public static boolean validatePhoneNumber(String phoneNumber) throws InvalidUserException {
        if (phoneNumber == null) {
            throw new InvalidUserException("Phone number is null.");
        }

        String regex = "^(\\+?91|91)?[6-9]\\d{9}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        boolean isMatch = matcher.matches();

        if (isMatch) {
            System.out.println("The phone number is: Valid");
        } else {
            throw new InvalidUserException("The phone number is: Invalid");
        }

        return isMatch;
    }

    public static boolean validateDeleteUser(User user) throws InvalidUserException {
        if (user != null && user.getUserId() > 0 && validateEmail(user.getEmail())) {
            System.out.println("User deletion details are valid.");
            return true;
        } else {
            throw new InvalidUserException("Invalid user details for deletion");
        }
    }
}

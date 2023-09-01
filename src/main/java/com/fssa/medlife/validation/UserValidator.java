package com.fssa.medlife.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.medlife.model.User;
import exception.InvalidUserException;

public class UserValidator {

	public static boolean validateUser(User user) throws InvalidUserException {
	    // Check if the user object is not null and if all user details are valid
	    if (user != null &&
	        validateName(user.getUsername()) &&
	        validatePassword(user.getPassword()) &&
	        validateEmail(user.getEmail()) &&
	        validatePhoneNumber(user.getPhonenumber())) {
	        return true; // Return true if all details are valid
	    } else {
	        throw new InvalidUserException("User details not valid"); // Throw an exception if any detail is invalid
	    }
	}

	public static boolean validateUserID(int userID) throws InvalidUserException {
	    // Check if the user ID is less than 0 (negative value) and throw an exception if it is
	    if (userID < 0) {
	        throw new InvalidUserException("User ID is invalid: Negative value.");
	    }

	    // Check if the user ID matches the regex pattern for non-negative numbers
	    String regexUserID = "^[0-9]+$";
	    boolean match = Pattern.matches(regexUserID, Integer.toString(userID));

	    // Throw an exception if the user ID doesn't match the pattern
	    if (!match) {
	        throw new InvalidUserException("User ID is invalid: Only non-negative numbers are allowed.");
	    }

	    System.out.println("User ID is valid.");
	    return match; // Return true if the user ID is valid
	}

	public static boolean validateName(String name) throws InvalidUserException {
	    // Check if the name is not null and matches the regex pattern for a valid name
	    if (name == null) {
	        throw new InvalidUserException("User name is null");
	    }

	    String regex = "^[A-Za-z]\\w{2,29}$";
	    if (!Pattern.matches(regex, name)) {
	        throw new InvalidUserException("The User name is not valid");
	    }

	    System.out.println("The User name is valid.");
	    return true; // Return true if the name is valid
	}

	public static boolean validatePassword(String password) throws InvalidUserException {
	    // Check if the password is not null and matches the regex pattern for a valid password
	    if (password == null) {
	        throw new InvalidUserException("User password is null");
	    }

	    String patternString = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[^\\s]).{8,}$";
	    Pattern pattern = Pattern.compile(patternString);
	    if (!pattern.matcher(password).matches()) {
	        throw new InvalidUserException("User password is invalid");
	    }

	    System.out.println("Valid password.");
	    return true; // Return true if the password is valid
	}

	public static boolean validateEmail(String email) throws InvalidUserException {
	    // Check if the email is not null and matches the regex pattern for a valid email address
	    if (email == null) {
	        throw new InvalidUserException("Email address is null");
	    }

	    String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
	    if (!Pattern.matches(regex, email)) {
	        throw  new InvalidUserException("The email address is invalid");
	    }

	    System.out.println("The email address is valid.");
	    return true; // Return true if the email is valid
	}

	public static boolean validatePhoneNumber(String phoneNumber) throws InvalidUserException {
	    // Check if the phone number is not null and matches the regex pattern for a valid phone number
	    if (phoneNumber == null) {
	        throw new InvalidUserException("Phone number is null");
	    }

	    String regex = "^(\\+?91|91)?[6-9]\\d{9}$";
	    Pattern pattern = Pattern.compile(regex);
	    if (!pattern.matcher(phoneNumber).matches()) {
	        throw new InvalidUserException("The phone number is invalid");
	    }

	    System.out.println("The phone number is valid.");
	    return true; // Return true if the phone number is valid
	}

	public static boolean validateDeleteUser(User user) throws InvalidUserException {
	    // Check if the user object is not null and if the email is valid
	    if (user != null && validateEmail(user.getEmail())) {
	        System.out.println("User deletion details are valid.");
	        return true; // Return true if the deletion details are valid
	    } else {
	        throw new InvalidUserException("Invalid user details for deletion"); // Throw an exception if details are invalid
	    }
	}

}

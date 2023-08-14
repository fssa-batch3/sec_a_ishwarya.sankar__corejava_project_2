package Medlife.validation;
import Medlife.model.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import Medlife.model.User;
import Medlife.validation.exception.InvalidUserException;
import Medlife.validation.exception.*;
public class UserValidator {
	public static boolean ValidateUser(User user) throws InvalidUserException {
		if(user != null && validateName(user.getUsername()) && validateEmail(user.getEmail()) 
				&& validatePassword(user.getPassword())) {
			return true;
		} else {
			throw new InvalidUserException("User details not valid");
		}
	}

	public static boolean ValidateLoginUser(String email, String password) throws InvalidUserException {
		if( email!=null&& password!=null&&validateEmail(email)&&validatePassword(password)) {	
			return true;
		} else {
			
			throw new InvalidUserException("Login details are invalid");
		}
	}

	public static boolean validateName(String name) throws InvalidUserException{
		boolean match = false;
		try {
			String regex = "^[A-Za-z0-9_]{3,30}$";
			match = Pattern.matches(regex, name);
			if (match) {
				System.out.println("The user name is valid.");
			} else {
				System.out.println("user name is not valid");
			}
		} catch (Exception e) {
			System.out.println("user name is not valid");
		}
		return match;
	}

	public static boolean validatePassword(String password) throws InvalidUserException{
		boolean match = false;
		try {
			String pattern_string = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[^\\s]).{8,}$";
			match = Pattern.matches(pattern_string, password);
			if (match) {
				System.out.println("Valid password.");
			} else {
				System.out.println("Invalid password.");
			}
		} catch (PatternSyntaxException e) {
			System.out.println("Password is not valid");
					}

		return match;
	}

	public static boolean validateEmail(String email) throws InvalidUserException{
		boolean isMatch = false;
		try {
			String regex = "^.*@.*\\..*$";
			isMatch = Pattern.matches(regex, email);
			if (isMatch) {
				System.out.println("The email address is: Valid");
			} else {
				System.out.println("The email address is: Invalid");
			}
			return isMatch;
		} catch (PatternSyntaxException e) {
			System.out.println("email address is not valid");

		}
		return isMatch;

    }
}

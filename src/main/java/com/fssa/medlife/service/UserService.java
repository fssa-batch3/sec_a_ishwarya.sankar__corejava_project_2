package com.fssa.medlife.service;


import java.sql.SQLException;

import com.fssa.medlife.dao.UserDAO;
import com.fssa.medlife.model.User;
import com.fssa.medlife.service.exception.ServiceException;
import com.fssa.medlife.validation.UserValidator;

import exception.InvalidUserException;



public class  UserService {
	public boolean registerUser(User user) throws ServiceException {
	    // Create a new UserDAO instance to interact with the database
	    UserDAO userDAO = new UserDAO();

	    try {
	        // Check if a user with the same email already exists in the database
	        if (userDAO.isEmailExists(user.getEmail())) {
	            throw new ServiceException("User with this email already exists");
	        }

	        // Validate the user's information using UserValidator
	        UserValidator.validateUser(user);

	        // Attempt to register the user using the UserDAO
	        return userDAO.register(user);
	    } catch (InvalidUserException | SQLException e) {
	        // If there's an exception during registration, wrap it in a ServiceException and throw it
	        throw new ServiceException(e);
	    }
	}

	public boolean loginUser(User user, String email) throws ServiceException {
	    try {
	        // Validate the email and password provided
	        UserValidator.validateEmail(email);
	        UserValidator.validatePassword(user.getPassword());

	        // Create a new UserDAO instance to interact with the database
	        UserDAO userDAO = new UserDAO();

	        // Check if a user with the provided email exists in the database
	        if (!userDAO.isEmailExists(email)) {
	            throw new ServiceException("Before logging in, you have to register");
	        }

	        // Attempt to log in the user using the UserDAO
	        if (userDAO.login(user, email)) {
	            System.out.println(email + " Successfully logged in");
	            return true;
	        } else {
	            return false;
	        }
	    } catch (ServiceException e) {
	        // If there's a ServiceException, rethrow it
	        throw e;
	    } catch (Exception e) {
	        // If there's any other exception, wrap it in a ServiceException and throw it
	        throw new ServiceException(e.getLocalizedMessage());
	    }
	}

	public boolean updateUser(User user, String email) throws ServiceException {
	    // Create a new UserDAO instance to interact with the database
	    UserDAO userDAO = new UserDAO();

	    try {
	        // Check if a user with the provided email exists in the database
	        if (!userDAO.isEmailExists(email)) {
	            throw new ServiceException("User with this email does not exist");
	        }

	        // Validate the user's information using UserValidator
	        UserValidator.validateUser(user);

	        // Attempt to update the user's information using the UserDAO
	        return userDAO.updateUser(user);
	    } catch (InvalidUserException | SQLException e) {
	        // If there's an exception during the update, wrap it in a ServiceException and throw it
	        throw new ServiceException(e);
	    }
	}

	public boolean deleteUser(User user) throws ServiceException {
	    // Create a new UserDAO instance to interact with the database
	    UserDAO userDAO = new UserDAO();
	    try {
	        // Check if a user with the provided email exists in the database
	        if (!userDAO.isEmailExists(user.getEmail())) {
	            throw new ServiceException("User with this email does not exist");
	        }

	        // Validate the user's information for deletion using UserValidator
	        UserValidator.validateDeleteUser(user);

	        // Attempt to delete the user using the UserDAO
	        return userDAO.deleteUser(user);
	    } catch (InvalidUserException | SQLException e) {
	        // If there's an exception during deletion, wrap it in a ServiceException and throw it
	        throw new ServiceException(e);
	    }
	}

 }
	
	       
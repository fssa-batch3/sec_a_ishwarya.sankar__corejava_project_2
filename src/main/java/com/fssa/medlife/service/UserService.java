package com.fssa.medlife.service;

import java.sql.SQLException;
import java.util.List;

import com.fssa.medlife.dao.DetailsDAO;
import com.fssa.medlife.dao.UserDAO;
import com.fssa.medlife.exception.DAOException;
import com.fssa.medlife.model.Appointment;
import com.fssa.medlife.model.User;
import com.fssa.medlife.service.exception.ServiceException;
import com.fssa.medlife.validation.UserValidator;

import exception.InvalidUserException;

public class UserService {

	public UserService() {
		// Public constri
	}

	public boolean registerUser(User user) throws ServiceException {

		UserDAO userDAO = new UserDAO();
		UserValidator userValidator = new UserValidator();
		try {
			if (userDAO.isEmailExists(user.getEmail())) {
				throw new ServiceException("User with this email already exists");
			}

			userValidator.validateUser(user);

			return userDAO.register(user);

		} catch (InvalidUserException | SQLException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public User loginUser(String password, String email) throws ServiceException {
		UserValidator userValidator = new UserValidator();
		try {
			userValidator.validateEmail(email);
			userValidator.validatePassword(password);

			UserDAO userDAO = new UserDAO();

			if (!userDAO.isEmailExists(email)) {
				throw new ServiceException("Before logging in, you have to register");
			}

			return userDAO.login(password, email);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public boolean updateUser(User user, String email) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		UserValidator userValidator = new UserValidator();

		try {
			if (!userDAO.isEmailExists(email)) {
				throw new ServiceException("User with this email does not exist");
			}

			userValidator.validateUser(user);

			return userDAO.updateUser(user);
		} catch (InvalidUserException | SQLException e) {
			throw new ServiceException(e);
		}
	}

	public boolean deleteUser(User user) throws ServiceException {
		UserValidator userValidator = new UserValidator();

		UserDAO userDAO = new UserDAO();
		try {

			if (!userDAO.isEmailExists(user.getEmail())) {
				throw new ServiceException("User with this email does not exist");
			}

			userValidator.validateDeleteUser(user);

			return userDAO.deleteUser(user);
		} catch (InvalidUserException | SQLException e) {
			throw new ServiceException(e);
		}
	}

	/**
	 * Retrieves a user by their email address.
	 *
	 * @param email The email address of the user to retrieve.
	 * @return The User object if found, or null if not found.
	 * @throws ServiceException If an error occurs while retrieving the user.
	 */
	public User getUserByEmail(String email) throws ServiceException {
		UserValidator userValidator = new UserValidator();

		try {
			// Validate the email (if needed)
			userValidator.validateEmail(email);

			UserDAO userDAO = new UserDAO(); // Assuming you have a UserDAO implementation

			// Retrieve the user by email from the DAO
			return userDAO.getUserByEmail(email);
		} catch (InvalidUserException | DAOException e) {
			throw new ServiceException(e);
		}
	}
	
	// In your UserService class
	public String getUsernameByUserId(int userId) throws ServiceException {
	    try {
	        UserDAO userDAO = new UserDAO();
	        return userDAO.getUsernameByUserId(userId);
	    } catch (SQLException e) {
	        throw new ServiceException("Failed to retrieve username by user ID");
	    }
	}

	
	  public List<Appointment> getAppointmentsForUser(int userId) throws ServiceException {
		  UserDAO userDAO = new UserDAO();
	        try {
	            return userDAO.getAppointmentsForUser(userId);
	        } catch (DAOException e) {
	            throw new ServiceException("Error retrieving appointments for user");
	        }
	    }

	  public User findUserById(int userId) throws ServiceException {
			try {
				
				 UserDAO userDAO = new UserDAO();
				return userDAO.FindUserByUserId(userId);
			} catch (SQLException e) {
				throw new ServiceException(e);
			}
		}
	  
	  
	  
	  public static void main(String[] args) {
		    try {
		        int userIdToFind = 30; // Replace with the desired userId to find

		        UserDAO userDAO = new UserDAO();
		        User foundUser = userDAO.FindUserByUserId(userIdToFind);

		        if (foundUser != null) {
		            System.out.println("User found:");
		            System.out.println("User ID: " + foundUser.getUserId());
		            System.out.println("Username: " + foundUser.getUsername());
		            System.out.println("Email: " + foundUser.getEmail());
		            System.out.println("Type: " + foundUser.getType());
		            System.out.println("Phone Number: " + foundUser.getPhonenumber());
		        } else {
		            System.out.println("User not found for userId: " + userIdToFind);
		        }
		    } catch ( SQLException e) {
		        System.err.println("Error: " + e.getMessage());
		        e.printStackTrace();
		    }
		}

}

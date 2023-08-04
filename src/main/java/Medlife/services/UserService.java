package Medlife.services;
import Medlife.dao.exception.*;

import java.sql.SQLException;

import Medlife.dao.*;
import Medlife.dao.exception.DAOException;
import Medlife.model.User;
import Medlife.services.*;
import Medlife.services.exception.ServiceException;
import Medlife.validation.UserValidator;
import Medlife.validation.exception.InvalidUserException;
public class UserService {

	public static boolean registerUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
		if(UserValidator.ValidateUser(user)) { 
			if(userDAO.register(user)) {
				System.out.println(user.getUsername() + " Successfully Registered!");
				return true;
			} else {
				System.out.println("Registration not successful!");
				return false;
			}
		} else {
			return false;
		}
		} catch ( SQLException | InvalidUserException e) {
			throw new ServiceException(e);
		}
	}

	
	public static boolean loginUser(String email, String password) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
		UserValidator.ValidateLoginUser(email, password);
			if(userDAO.login(email,password)) {
				System.out.println(" Successfully login!");
				return true;
			} else {
				System.out.println("Login not successful!");
				return false;
			}
		
		} catch ( DAOException | InvalidUserException e) {
			throw new ServiceException(e);
		}
	}


	
	
}


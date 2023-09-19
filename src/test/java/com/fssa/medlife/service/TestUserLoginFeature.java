package com.fssa.medlife.service;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;
import com.fssa.medlife.model.User;
import com.fssa.medlife.service.exception.ServiceException;

public class TestUserLoginFeature {

	
	@Test
	public void loginSuccess() {
		UserService userService = new UserService();
		String email = "abinaya17@gmail.com";
		String password = "Ishu@145";
		User user1 = new User(email, password);
		try {
			assertNotNull(userService.loginUser(password, email));
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
			userService.loginUser(password, email);
			fail();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	

	
	@Test
	public void testLoginEmailCheck() {
		UserService userService = new UserService();
		String email = "invalidemail"; 
		String password = "Navee@123";
		User user1 = new User(email, password);
		try {
			userService.loginUser(password, email);
			fail("Login with invalid email format should fail.");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	
	
	@Test
	public void testLoginNullUser() {
		UserService userService = new UserService();
		try {
			userService.loginUser(null, "maha12@gmail.com"); 
			fail();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
	
	
}

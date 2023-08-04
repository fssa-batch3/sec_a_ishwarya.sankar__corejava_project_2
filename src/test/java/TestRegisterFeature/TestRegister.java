package TestRegisterFeature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import Medlife.model.User;
import Medlife.services.UserService;
import Medlife.services.exception.ServiceException;

public class TestRegister {
     
	public static void main(String[] args) {

		User user1 = new User("ishusankar","9500320194", "ishu@gmail.com","ishu@123");
		UserService userService = new UserService();
		try {
			userService.registerUser(user1);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testInvalidPassword() {

		UserService userService = new UserService();
		User user1 = new User("abipapu" ,"9500320194", "ishu@gmail.com","ishu@10023");
		try {
			UserService.registerUser(user1);
			fail();
		} catch (ServiceException e) {
			e.printStackTrace();
			assertEquals("User details not valid",e.getMessage());
		}
	}
	
	
}
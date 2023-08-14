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
     
	public static void main(String[] args) {}
//	
//	 @Test
//	    public void testValidUserRegistration() {
//	        UserService userService = new UserService();	
//	        User user = new User( 1,"naveena", "8072440456", "navee@example.com", "Password@123");	        
//	        try {
//	            assertTrue(userService.registerUser(user));
//	        } catch (ServiceException e) {
//	            e.printStackTrace();
//	            fail();
//	        }
//	    }
//	 
	 
	 
	
	

	@Test
	public void testInvalidPassword() {

		UserService userService = new UserService();
		User user1 = new User(2,"abipapu" ,"9500320194", "ishu@gmail.com","Simplepassword");
		User user2 = new User(3,"mullai" ,"9500320167", "mullai@gmail.com","ishu@145");
		try {
			UserService.registerUser(user1);
		} catch (ServiceException e) {
			e.printStackTrace();
		assertEquals("User details not valid",e.getMessage());
		}
	}
//
//	
//	@Test
//	public void testWeakPasswords() {
//	    UserService userService = new UserService();
//	    User user1 = new User(4,"John", "1234567890", "john@example.com", "weak");
//	    User user2 = new User(5,"Jane", "9876543210", "jane@example.com", "simplepassword");
//
//	    try {
//	        assertFalse(userService.registerUser(user1));
//	        assertFalse(userService.registerUser(user2));
//	    } catch (ServiceException e) {
//	        e.printStackTrace();
//	        fail();
//	    }
//	}
	
}

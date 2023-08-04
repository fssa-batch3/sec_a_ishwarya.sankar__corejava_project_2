package TestLoginUser;
import Medlife.services.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import Medlife.services.UserService;
import Medlife.services.exception.ServiceException;

public class TestLogin {
	@Test
	public void TestLoginsucess() {
		
		try {
			assertFalse(UserService.loginUser("ishu14@gmail.com","Ishu@10023"));
		}
		catch(ServiceException E) {
			E.printStackTrace();
		}
			
		
	}
	}



package Medlife.services;
import Medlife.model.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

import Medlife.dao.exception.*;
import Medlife.model.User;
import Medlife.services.exception.ServiceException;
import io.github.cdimascio.dotenv.Dotenv;

public class MedicineService {
	  public boolean Medicine(Medicine medicine) throws ServiceException {
	        try {
	            // Your existing code...
	            int rows = pst.executeUpdate();
	            
	            //Return Successful or not
	            if (rows == 1) {
	                return true;
	            } else {
	                throw new ServiceException("Failed to insert medicine into database.");
	            }
	        } catch (SQLException e) {
	            throw new ServiceException("Error while adding medicine to database.", e);
	        }
	    }

	    // Your other methods...

	    public static void main(String[] args) {
	        // Example of using the ServiceException
	        try {
	            MedicineService medicineService = new MedicineService();
	            Medicine medicine = new Medicine("Example Medicine", 100);
	            medicineService.Medicine(medicine);
	        } catch (ServiceException e) {
	            e.printStackTrace();
	            // Handle the exception or log it appropriately
	        }
	    }
}

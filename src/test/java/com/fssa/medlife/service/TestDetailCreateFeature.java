package com.fssa.medlife.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import com.fssa.medlife.service.*;

import com.fssa.medlife.model.*;
import com.fssa.medlife.service.exception.ServiceException;

public class TestDetailCreateFeature {
	  @Test
	    public void testAddDetailSuccess() {
		  DetailsService detailservice = new DetailsService();
		  Doctordetails doctordetails = new Doctordetails(78787656,"http://example.com", "MBBS", "Cardiologist", 10, "http://example.com",1);
	        
	        try {
	            assertTrue(detailservice.addDoctorDetails(doctordetails));
		        System.out.println("details created");

	        } catch (ServiceException e) {
	            e.printStackTrace();
	            fail();
	        }
	    }
	    
}

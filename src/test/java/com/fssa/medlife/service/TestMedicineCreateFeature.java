package com.fssa.medlife.service;



import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.medlife.model.Medicine;
import com.fssa.medlife.service.exception.ServiceException;

class TestMedicineCreateFeature {

	 @Test
	    void testAddMedicineSuccess() {
	        new MedicineService();
	        Medicine medicine = new Medicine("dolog", 50, 4, "https://example.com/paracetamol");

	        try {
	            assertTrue(MedicineService.addMedicine(medicine));
	            System.out.println("Medicine Addition Test Passed");
	        } catch (ServiceException e) {
	            e.printStackTrace();
	            fail();
	        }
	    }
	 

}
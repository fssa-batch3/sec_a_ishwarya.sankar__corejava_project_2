package com.fssa.medlife.service;



import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.medlife.model.Medicine;
import com.fssa.medlife.service.exception.ServiceException;

class TestMedicineCreateFeature {

	  @Test
	    public void testAddMedicineSuccess() {
	        MedicineService medicineService = new MedicineService();
	        Medicine medicine = new Medicine("Nilabhringadi", 100, "https://example.com");
	        
	        try {
	            assertTrue(medicineService.addMedicine(medicine));
	        } catch (ServiceException e) {
	            e.printStackTrace();
	            fail();
	        }
	    }
	    
	  
	  
	  
	    @Test
	    public void testAddMedicineNullName() {
	        MedicineService medicineService = new MedicineService();
	        Medicine medicine = new Medicine(null, 100, "http://example.com");
	        
	        try {
	            medicineService.addMedicine(medicine);
	            fail();
	        } catch (ServiceException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    @Test
	    public void testAddMedicineInvalidRupees() {
	        MedicineService medicineService = new MedicineService();
	        Medicine medicine = new Medicine("MedicineName", -10, "http://example.com");
	        
	        try {
	            medicineService.addMedicine(medicine);
	            fail();
	        } catch (ServiceException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    @Test
	    public void testAddMedicineNullUrl() {
	        MedicineService medicineService = new MedicineService();
	        Medicine medicine = new Medicine("MedicineName", 100, null);
	        
	        try {
	            medicineService.addMedicine(medicine);
	            fail();
	        } catch (ServiceException e) {
	            e.printStackTrace();
	        }
	    }
	    @Test
	    public void testAddMedicineEmptyName() {
	        MedicineService medicineService = new MedicineService();
	        Medicine medicine = new Medicine("", 100, "http://example.com");
	        
	        try {
	            medicineService.addMedicine(medicine);
	            fail();
	        } catch (ServiceException e) {
	            e.printStackTrace();
	        }
	    }

	    @Test
	    public void testAddMedicineZeroRupees() {
	        MedicineService medicineService = new MedicineService();
	        Medicine medicine = new Medicine("MedicineName", 0, "http://example.com");
	        
	        try {
	            medicineService.addMedicine(medicine);
	            fail();
	        } catch (ServiceException e) {
	            e.printStackTrace();
	        }
	    }

	    @Test
	    public void testAddMedicineEmptyUrl() {
	        MedicineService medicineService = new MedicineService();
	        Medicine medicine = new Medicine("MedicineName", 100, "");
	        
	        try {
	            medicineService.addMedicine(medicine);
	            fail();
	        } catch (ServiceException e) {
	            e.printStackTrace();
	        }
	    }

	    @Test
	    public void testAddMedicineDuplicateName() {
	        MedicineService medicineService = new MedicineService();
	        Medicine medicine1 = new Medicine("MedicineName", 100, "http://example.com");
	        Medicine medicine2 = new Medicine("MedicineName", 150, "http://example2.com");
	        
	        try {
	            assertTrue(medicineService.addMedicine(medicine1));
	        } catch (ServiceException e) {
	        	 fail();
	            e.printStackTrace();
	           
	        }
	    }
}
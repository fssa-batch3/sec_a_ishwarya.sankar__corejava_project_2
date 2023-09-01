package com.fssa.medlife.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.medlife.exception.DAOException;
import com.fssa.medlife.exception.ValidatorException;
import com.fssa.medlife.model.Medicine;
import com.fssa.medlife.service.exception.ServiceException;


public class TestMedicineDeleteFeature {
	 @Test
	    public void testDeleteMedicineSuccess() {
	        MedicineService medicineService = new MedicineService();
	       
	        try {
	            assertTrue(medicineService.deleteMedicine(1));
	        } catch (ServiceException e) {
	            e.printStackTrace();
	           
	        }
	    }
	    
	    @Test
	    public void testDeleteMedicineInvalidId() {
	        MedicineService medicineService = new MedicineService();
	        try {
	            assertTrue(medicineService.deleteMedicine(-1));
	        } catch (ServiceException e) {
	            e.printStackTrace();
	           
	        }
	    }
	      
}
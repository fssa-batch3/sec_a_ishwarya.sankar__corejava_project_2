package com.fssa.medlife.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.medlife.exception.DAOException;
import com.fssa.medlife.model.Medicine;
import com.fssa.medlife.service.exception.ServiceException;

public class TestMedicineDeleteFeature {
    
	 @Test

   	public void testDeleteMedicine() throws DAOException, ServiceException {
		 MedicineService medicineService = new MedicineService();
	        Medicine newMedicine = new Medicine();
	        MedicineService.deleteMedicine(7);
   	}
	 
	 
	 
}
package com.fssa.medlife.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

import com.fssa.medlife.exception.DAOException;
import com.fssa.medlife.model.Medicine;
import com.fssa.medlife.service.exception.ServiceException;


 class TestMedicineReadFeature {


	 @Test
	    void testReadAllMedicine() throws DAOException {
	        MedicineService medicineService = new MedicineService();
	        List<Medicine> medicineList = medicineService.getAll();
	        assertNotNull(medicineList);
	    }

	 
	    @Test
	    void testReadMedicineById() throws DAOException, ServiceException {
	    	MedicineService medicineService = new MedicineService();
	        List<Medicine> medicineList = medicineService.getAll();
	        assertFalse(medicineList.isEmpty());
	    }
	
		}
	
 

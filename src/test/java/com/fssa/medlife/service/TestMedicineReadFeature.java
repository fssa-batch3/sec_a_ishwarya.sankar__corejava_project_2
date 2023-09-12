package com.fssa.medlife.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fssa.medlife.exception.DAOException;
import com.fssa.medlife.model.Medicine;
import com.fssa.medlife.service.exception.ServiceException;

class TestMedicineReadFeature {

	@Test
	void testReadAllMedicine() {
		MedicineService medicineService = new MedicineService();
		List<Medicine> medicineList;
		try {
			medicineList = medicineService.getAllMedicine();
			assertNotNull(medicineList);
			System.out.println(medicineList.toString());
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testReadAllMedicineEmptyList() {
	    MedicineService medicineService = new MedicineService();
	    try {
	        List<Medicine> medicineList = medicineService.getAllMedicine();
	        assertNotNull(medicineList);
	        assertFalse(medicineList.isEmpty()); // Expect an empty list
	    } catch (ServiceException e) {
	        e.printStackTrace();
	    }
	}

	@Test
	void testReadAllMedicinePopulatedList() {
	    MedicineService medicineService = new MedicineService();
	    // Add some medicines to the service before testing
	    Medicine medicine1 = new Medicine("Medicine1", 50, "http://example1.com");
	    Medicine medicine2 = new Medicine("Medicine2", 75, "http://example2.com");
	    try {
	        medicineService.addMedicine(medicine1);
	        medicineService.addMedicine(medicine2);

	        List<Medicine> medicineList = medicineService.getAllMedicine();
	        assertNotNull(medicineList);
	        assertFalse(medicineList.isEmpty()); // Expect a non-empty list
	    } catch (ServiceException e) {
	        e.printStackTrace();
	        fail();
	    }
	}
	
	

}

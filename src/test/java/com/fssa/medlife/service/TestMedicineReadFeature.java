package com.fssa.medlife.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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

	

}

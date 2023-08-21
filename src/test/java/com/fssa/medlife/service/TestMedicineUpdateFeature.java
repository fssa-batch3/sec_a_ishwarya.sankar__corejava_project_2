package com.fssa.medlife.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.fssa.medlife.model.Medicine;
import com.fssa.medlife.service.exception.ServiceException;

public class TestMedicineUpdateFeature {

	@Test
	void testUpdateSuccess() {
		MedicineService medicineService = new MedicineService();
		Medicine medicine1 = new Medicine("Aspirin", 50, 1);
		try {
			assertTrue(medicineService.updateMedicine(medicine1));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testUpdateMedicineNotFound() throws SQLException {
		MedicineService medicineService = new MedicineService();
		Medicine medicine1 = new Medicine("Paracetamol", 30);
		try {
			// Assuming the medicine with the name "Paracetamol" does not exist in the
			// system
			medicineService.updateMedicine(medicine1);
			fail("Expected ServiceException for medicine not found, but none was thrown.");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testUpdateInvalidNameFormat() throws SQLException {
		MedicineService medicineService = new MedicineService();
		Medicine medicine1 = new Medicine("Ibuprofen", 25);
		try {
			// Assuming "new_name_format" is not a valid medicine name format
			medicineService.updateMedicine(medicine1);
			fail("Expected ServiceException for invalid medicine name format, but none was thrown.");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testUpdateNegativePrice() throws SQLException {
		MedicineService medicineService = new MedicineService();
		Medicine medicine1 = new Medicine("Cough Syrup", 15);
		try {
			// Updating with a negative price
			medicineService.updateMedicine(medicine1);
			fail("Expected ServiceException for negative medicine price, but none was thrown.");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}

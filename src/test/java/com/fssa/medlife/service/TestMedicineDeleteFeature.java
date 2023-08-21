package com.fssa.medlife.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.medlife.model.Medicine;
import com.fssa.medlife.service.exception.ServiceException;

public class TestMedicineDeleteFeature {

    @Test
    void testDeleteMedicineSuccess() {
        MedicineService medicineService = new MedicineService();
        // Assuming a medicine with the name "Aspirin" exists in the database
        try {
            Medicine medicine = new Medicine (1);
            boolean isDeleted = medicineService.deleteMedicine(medicine);
            assertTrue(isDeleted, "Medicine deletion failed.");
        } catch (ServiceException e) {
            e.printStackTrace();
            fail("Exception occurred while deleting the medicine.");
        }
    }

    @Test
    void testDeleteNonExistingMedicine() {
        MedicineService medicineService = new MedicineService();
        // Assuming a medicine with the name "NonExistingMedicine" does not exist in the database
        try {
            Medicine medicine = new Medicine("NonExistingMedicine", 30);
            medicineService.deleteMedicine(medicine);
            fail("Medicine with non-existing name should not be deleted, but method succeeded.");
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testDeleteMedicineWithInvalidName() {
        MedicineService medicineService = new MedicineService();
        Medicine medicine = new Medicine("InvalidMedicine", 25);
        try {
            boolean isDeleted = medicineService.deleteMedicine(medicine);
            assertFalse(isDeleted, "Medicine should not be deleted.");
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}

package com.fssa.medlife.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.fssa.medlife.exception.DAOException;
import com.fssa.medlife.exception.ValidatorException;
import com.fssa.medlife.model.Medicine;
import com.fssa.medlife.service.exception.ServiceException;


class TestMedicineUpdateFeature {
    @Test
    void testUpdateMedicine() throws ServiceException, DAOException {
        MedicineService medicineService = new MedicineService();
        Medicine updatedMedicine = new Medicine();
        updatedMedicine.setMedicineName("Updated Medicine Name");
        updatedMedicine.setMedicineRupees(100);
        updatedMedicine.setMedicineUrl("https://example.com/updated-medicine");

        assertDoesNotThrow(() -> {
            medicineService.updateMedicine(29, updatedMedicine);
        });
    }
    
    
    
    @Test
    void testUpdateMedicineWithValidInput() {
        MedicineService medicineService = new MedicineService();
        Medicine updatedMedicine = new Medicine();
        updatedMedicine.setMedicineName("Updated Paracetamol");
        updatedMedicine.setMedicineRupees(75);
        updatedMedicine.setMedicineUrl("https://example.com/updated-paracetamol");
        
        assertDoesNotThrow(() -> {
            medicineService.updateMedicine(3, updatedMedicine);
        });
    }

    @Test
    void testUpdateMedicineWithInvalidInput() {
        MedicineService medicineService = new MedicineService();
        Medicine updatedMedicine = new Medicine();
        // Invalid medicine details
        
        assertThrows(ValidatorException.class, () -> {
            medicineService.updateMedicine(1, updatedMedicine);
        });
    }
}

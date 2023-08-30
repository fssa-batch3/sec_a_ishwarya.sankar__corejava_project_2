package com.fssa.medlife.service;

import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;
import com.fssa.medlife.model.Medicine;
import com.fssa.medlife.service.exception.ServiceException;


class TestMedicineUpdateFeature {
 
    
    
    @Test
    void testUpdateMedicineWithValidInput() {
        MedicineService medicineService = new MedicineService();
        Medicine updatedMedicine = new Medicine();
        updatedMedicine.setMedicineName("Updated Paracetamol");
        updatedMedicine.setMedicineRupees(75);
        updatedMedicine.setUserID(4);
        updatedMedicine.setMedicineUrl("https://example.com/updated-paracetamol");
        
        try {
            medicineService.updateMedicine(3, updatedMedicine);
        } catch (Exception e) {
            fail("An exception occurred: " + e.getMessage());
        }
        }
    
    
   

    @Test
  
    void testUpdateMedicineWithInvalidInput() {
        MedicineService medicineService = new MedicineService();
        Medicine updatedMedicine = new Medicine();
        // Invalid medicine details
        
        try {
            medicineService.updateMedicine(1, updatedMedicine);
            fail("Expected an exception, but none was thrown.");
        
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
    }
 
    
    

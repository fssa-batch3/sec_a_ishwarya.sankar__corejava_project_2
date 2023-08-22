package com.fssa.medlife.service;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fssa.medlife.model.Medicine;

import com.fssa.medlife.service.exception.ServiceException;


public class TestMedicineFeature {

    private MedicineService medicineService;

    @Test
    void testAddMedicineSuccess() {
        Medicine medicine = new Medicine("Medicine", 100,1);
        try {
            assertTrue(medicineService.addMedicine(medicine));
        } catch (ServiceException | SQLException e) {
            ((Throwable) e).printStackTrace();
            fail();
        }
    }

    @Test
    void testAddMedicineWithInvalidDetails() {
        Medicine medicine = new Medicine("", -50,12);
        assertThrows(ServiceException.class, () -> medicineService.addMedicine(medicine));
    }

    @Test
    void testAddNullMedicine() {
        assertThrows(ServiceException.class, () -> medicineService.addMedicine(null));
    }
}

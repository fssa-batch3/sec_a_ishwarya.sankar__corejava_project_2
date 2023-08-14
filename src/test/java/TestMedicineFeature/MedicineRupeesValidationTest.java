package TestMedicineFeature;


import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import Medlife.validation.MedicineValidator;
import Medlife.validation.exception.InvalidMedicineException;
 class MedicineRupeesValidationTest {

    @Test
     void testValidRupees() {
        try {
            assertTrue(MedicineValidator.validateMedicineRupees(5000));
        } catch (InvalidMedicineException e) {
            fail("5000 rupees should be valid.");
        }
    }

    @Test
    void testInvalidRupees_Negative() throws InvalidMedicineException {
        MedicineValidator.validateMedicineRupees(-100);
    }

    @Test
 void testInvalidRupees_Zero() throws InvalidMedicineException {
        MedicineValidator.validateMedicineRupees(0);
    }

    @Test
     void testInvalidRupees_AboveLimit() throws InvalidMedicineException {
        MedicineValidator.validateMedicineRupees(15000);
    }

    @Test
 void testInvalidRupees_NotIncrementOf100() throws InvalidMedicineException {
        MedicineValidator.validateMedicineRupees(1234);
    }
}

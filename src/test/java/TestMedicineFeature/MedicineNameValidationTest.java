package TestMedicineFeature;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import Medlife.validation.MedicineValidator;
import Medlife.validation.exception.InvalidMedicineException;

public class MedicineNameValidationTest {
	  @Test
	    public void testValidName() {
	        try {
	            assertTrue(MedicineValidator.validateMedicineName("Paracetamol 500mg"));
	        } catch (InvalidMedicineException e) {
	            fail("Valid medicine name should pass.");
	        }
	    }

	    @Test
	    public void testInvalidName_SpecialCharacters() throws InvalidMedicineException {
	        MedicineValidator.validateMedicineName("Cough Syrup @#$%");
	    }

	    @Test
	    public void testInvalidName_TooShort() throws InvalidMedicineException {
	        MedicineValidator.validateMedicineName("Rx");
	    }

	    @Test
	    public void testInvalidName_TooLong() throws InvalidMedicineException {
	        MedicineValidator.validateMedicineName("ThisIsAReallyLongMedicineNameThatExceedsTheLimit");
	    }
}

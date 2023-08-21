package com.fssa.medlife.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.fssa.medlife.model.Medicine;

 class TestValidateMedicineName {
	 @Test
	    void testValidMedicineName() {
	        Medicine medicine = new Medicine("Aspirin", 50);
	        assertEquals("Aspirin", medicine.getMedicineName());
	    }

	    @Test
	    void testMedicineNameWithSpaces() {
	        Medicine medicine = new Medicine("Painkiller");
	        assertEquals("   Painkiller   ", medicine.getMedicineName());
	    }

	    @Test
	    void testLongMedicineName() {
	        Medicine medicine = new Medicine("Gastrointestinal Anti-inflammatory and Antispasmodic");
	        assertEquals("Gastrointestinal Anti-inflammatory and Antispasmodic", medicine.getMedicineName());
	    }

	    @Test
	    void testMedicineNameWithSpecialCharacters() {
	        Medicine medicine = new Medicine("Allergy-C");
	        assertEquals("Allergy-C", medicine.getMedicineName());
	    }

	    @Test
	    void testEmptyMedicineName() {
	        Medicine medicine = new Medicine("", 30);
	        assertEquals("", medicine.getMedicineName());
	    }
}

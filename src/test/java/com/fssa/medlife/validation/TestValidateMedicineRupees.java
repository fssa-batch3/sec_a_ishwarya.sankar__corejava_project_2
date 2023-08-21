package com.fssa.medlife.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.fssa.medlife.model.Medicine;

public class TestValidateMedicineRupees{
@Test
void testValidMedicineRupees() {
    Medicine medicine = new Medicine("SomeMedicine", 75);
    assertEquals(75, medicine.getMedicineRupees());
}

@Test
void testMedicineRupeesWithZeroValue() {
    Medicine medicine = new Medicine("CheapMedicine", 0);
    assertEquals(0, medicine.getMedicineRupees());
}

@Test
void testMedicineRupeesWithNegativeValue() {
    Medicine medicine = new Medicine("DebtMedicine", -50);
    assertEquals(-50, medicine.getMedicineRupees());
}

@Test
void testMedicineRupeesWithSpecialCharacters() {
    Medicine medicine = new Medicine("Expensive-Medicine", 2000);
    assertEquals(2000, medicine.getMedicineRupees());
}
}
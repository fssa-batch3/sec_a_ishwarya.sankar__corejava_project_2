package com.fssa.medlife.validation;

import java.util.function.BooleanSupplier;

import com.fssa.medlife.model.Medicine;

import exception.InvalidMedicineException;

public class MedicineValidator {
	
	public static boolean validateMedicine(Medicine medicine) throws InvalidMedicineException {
        if (medicine == null) {
            throw new InvalidMedicineException("Medicine is null");
        }

        if (!validateMedicineName(medicine.getMedicineName())) {
            throw new InvalidMedicineException("Medicine name is not valid");
        }

        if (!validateMedicineRupees(medicine.getMedicineRupees())) {
            throw new InvalidMedicineException("Medicine rupees are not valid");
        }

        if (!validateMedicineUrl(medicine.getMedicineUrl())) {
            throw new InvalidMedicineException("Medicine URL is not valid");
        }

        // Additional validations for other attributes can be added here
        
        return true;
    }

    public static boolean validateMedicineName(String medicineName) throws InvalidMedicineException {
        if (medicineName == null || medicineName.trim().isEmpty()) {
            throw new InvalidMedicineException("Invalid medicine name");
        }
        return true;
    }

    public static boolean validateMedicineRupees(int medicineRupees) throws InvalidMedicineException {
        if (medicineRupees <= 0) {
            throw new InvalidMedicineException("Invalid medicine rupees");
        }
        return true;
    }

    public static boolean validateMedicineUrl(String medicineUrl) throws InvalidMedicineException {
        if (medicineUrl == null || medicineUrl.trim().isEmpty()) {
            throw new InvalidMedicineException("Invalid medicine URL");
        }

        // Additional URL format validation logic can be added here
        
        return true;
    }

	public static BooleanSupplier validateMedicine(String string) {
		// TODO Auto-generated method stub
		return null;
	}
    
    // Other validation methods for additional attributes can be added here
}


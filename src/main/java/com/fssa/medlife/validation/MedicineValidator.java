package com.fssa.medlife.validation;



import com.fssa.medlife.model.Medicine;

import exception.InvalidMedicineException;






public class MedicineValidator {
    
    public static boolean validateMedicine(Medicine medicine) throws InvalidMedicineException {
        if (medicine != null && validateMedicineName(medicine.getMedicineName()) && validateMedicineRupees(medicine.getMedicineRupees())
                && validateUserID(medicine.getUserID()) && validateMedicineUrl(medicine.getMedicineUrl())) {
            return true;
        } else {
            throw new InvalidMedicineException("Medicine details are not valid");
        }
    }
    
    public static boolean validateMedicineName(String medicineName) throws InvalidMedicineException {
        if (medicineName == null || medicineName.trim().isEmpty()) {
            throw new InvalidMedicineException("Medicine name is null or empty");
        }
        // You can add more validation rules for the medicine name if needed
        return true;
    }
    
    public static boolean validateMedicineRupees(int medicineRupees) throws InvalidMedicineException {
        if (medicineRupees <= 0) {
            throw new InvalidMedicineException("Medicine rupees are invalid: Should be greater than 0");
        }
        return true;
    }
    
    public static boolean validateUserID(int userID) throws InvalidMedicineException {
        if (userID <= 0) {
            throw new InvalidMedicineException("User ID is invalid: Should be greater than 0");
        }
        return true;
    }
    
    public static boolean validateMedicineUrl(String medicineUrl) throws InvalidMedicineException {
        // You can add validation rules for the medicine URL if needed
        return true;
    }
}

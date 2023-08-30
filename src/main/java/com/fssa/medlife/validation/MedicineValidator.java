package com.fssa.medlife.validation;

import com.fssa.medlife.exception.ValidatorException;
import com.fssa.medlife.model.Medicine;

public class MedicineValidator {
	
	private static final String NAME_PATTERN = "^[A-Za-z\\s]{3,}$";
//validates a Medicine object. If the provided medicine object is null, it throws a ValidatorException
	public static void validateMedicine(Medicine medicine) throws ValidatorException {
		if (medicine == null) {
			throw new ValidatorException("Medicine Object cannot be null");
		}
		validateMedicineName(medicine.getMedicineName());
		validateMedicineRupees(medicine.getMedicineRupees());
	}
	

	public static void validateMedicineName(String medicineName) throws ValidatorException {
		if (medicineName == null || "".equals(medicineName.trim())) {
			throw new ValidatorException("Medicine Name cannot be null or empty");
		}
		if (medicineName.length() < 3) {
			throw new ValidatorException("Medicine Name should be at least 3 characters long");
		}
		if (!medicineName.matches(NAME_PATTERN)) {
			throw new ValidatorException("Medicine Name should only contain alphabetic characters");
		}

		
	}

	public static void validateMedicineRupees(double d) throws ValidatorException{
		if (d <= 0) {
			throw new ValidatorException("Medicine rupees can not be zero or less than zero");
		}
	}

	public static void validateId(int id) throws ValidatorException {
		if (id <= 0) {
			throw new ValidatorException("Id can not be zero or less than zero");
		}
	}

	public static void validateMedicineUrl(String medicineUrl) throws ValidatorException {
		if (medicineUrl == null || "".equals(medicineUrl.trim())) {
			throw new ValidatorException("Medicine Name cannot be null or empty");
		}
	}
}

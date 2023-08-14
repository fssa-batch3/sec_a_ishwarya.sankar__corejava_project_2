package Medlife.validation;

import java.util.regex.Pattern;

import Medlife.model.Medicine;
import Medlife.validation.exception.InvalidMedicineException;

public class MedicineValidator {
	
	
	 public static boolean validateMedicine(Medicine medicine) throws InvalidMedicineException {
	        if (medicine != null && validateMedicineName(medicine.getMedicineName()) &&
	                validateMedicineRupees(medicine.getMedicineRupees()) &&
	                validateMedicineUrl(medicine.getMedicineUrl())) {
	            return true;
	        } else {
	            throw new InvalidMedicineException("Medicine details not valid.");
	        }
	    }
	
	
	
	
	public static boolean validateMedicineRupees(int rupees) throws InvalidMedicineException {
		boolean isValid = false;
		try {
			if (rupees > 0 && rupees <= 10000) {
				isValid = true;
				System.out.println("Medicine rupees is valid.");
			} else {
				throw new InvalidMedicineException("Medicine rupees is not valid.");
			}
		} catch (Exception e) {

		}
		return isValid;
	}

	public static boolean validateMedicineName(String name) throws InvalidMedicineException {
		boolean match = false;
//        try {
		String regex = "^[A-Za-z0-9_]{3,30}$";
		match = Pattern.matches(regex, name);
		if (match) {
			System.out.println("The medicine name is valid.");
		} else {
			throw new InvalidMedicineException("Medicine name is not valid.");
		}

//        } catch (Exception e) {
//            System.out.println("Medicine name is not valid.");
//        }
		return match;
	}

	public static boolean validateMedicineUrl(String url) throws InvalidMedicineException {
		boolean match = false;
		try {
			String regex = "^(https?|ftp)://[^\\s/$.?#].[^\\s]*$"; // Basic URL regex
			match = Pattern.matches(regex, url);
			if (match) {
				System.out.println("The medicine URL is valid.");
			} else {
				throw new InvalidMedicineException("Medicine url is not valid.");
			}
		} catch (Exception e) {
			System.out.println("Medicine URL is not valid.");
		}
		return match;
	}
}

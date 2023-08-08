package Medlife.validation;

import java.util.regex.Pattern;

public class MedicineValidator {
	 public static boolean validateMedicineRupees(int rupees) {
	        boolean isValid = false;
	        try {
	            if (rupees > 0 && rupees <= 1000000) {
	                isValid = true;
	                System.out.println("Medicine rupees is valid.");
	            } else {
	                System.out.println("Medicine rupees is not valid.");
	            }
	        } catch (Exception e) {
	            System.out.println("Medicine rupees is not valid.");
	        }
	        return isValid;
	    }

    public static boolean validateMedicineName(String name) {
        boolean match = false;
        try {
            String regex = "^[A-Za-z0-9_]{3,30}$";
            match = Pattern.matches(regex, name);
            if (match) {
                System.out.println("The medicine name is valid.");
            } else {
                System.out.println("Medicine name is not valid.");
            }
        } catch (Exception e) {
            System.out.println("Medicine name is not valid.");
        }
        return match;
    }


  public static boolean validateMedicineUrl(String url) {
      boolean match = false;
      try {
          String regex = "^(https?|ftp)://[^\\s/$.?#].[^\\s]*$"; // Basic URL regex
          match = Pattern.matches(regex, url);
          if (match) {
              System.out.println("The medicine URL is valid.");
          } else {
              System.out.println("Medicine URL is not valid.");
          }
      } catch (Exception e) {
          System.out.println("Medicine URL is not valid.");
      }
      return match;
  }
  }
    


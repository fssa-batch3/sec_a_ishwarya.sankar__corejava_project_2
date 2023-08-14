package Medlife.services;

import java.sql.SQLException;

import Medlife.dao.MedicineDAO;
import Medlife.model.Medicine;
import Medlife.services.exception.ServiceException;
import Medlife.validation.MedicineValidator;
import Medlife.validation.exception.InvalidMedicineException;

public class MedicineService {
	public static boolean MedicineUser(Medicine medicine) throws ServiceException {
		MedicineDAO medicineDAO = new MedicineDAO();
		try {
		if(MedicineValidator.validateMedicineName(medicine.getMedicineName())) { 
			if(medicineDAO.Medicine(medicine)) {
				System.out.println(medicine.getMedicineName() + " Successfully Created!");
				return true;
			} else {
				System.out.println("Not successful Created!");
				return false;
			}
		} else {
			return false;
		}
		} catch ( SQLException | InvalidMedicineException e) {
			throw new ServiceException(e);
		}
		
	}
	 
	// update 
		public static boolean MedicineUpdate(Medicine medicine) throws ServiceException {
			MedicineDAO medicineDAO = new MedicineDAO();
			try {
			if(MedicineValidator.validateMedicineName(medicine.getMedicineName())) { 
				if(medicineDAO.UpdateMedicine(medicine)) {
					System.out.println(medicine.getMedicineName() + " Successfully Updated!");
					return true;
				} else {
					System.out.println("Not successful Updated!");
					return false;
				}
			} else {
				return false;
			}
			} catch ( SQLException | InvalidMedicineException e) {
				throw new ServiceException(e);
			}
			
		}
		
		// DELETE
		public static boolean MedicineDelete(Medicine medicine) throws ServiceException {
			MedicineDAO medicineDAO = new MedicineDAO();
			try {
				if(medicineDAO.DeleteMedicine(medicine)) {
					System.out.println(" Successfully Deleted!");
					return true;
				} else {
					System.out.println("Not successful Updated!");
					return false;
				}
			} catch ( SQLException e) {
				throw new ServiceException(e);
			}
			
		}
		 
}

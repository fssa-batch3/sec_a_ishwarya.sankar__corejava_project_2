package com.fssa.medlife.service;

import java.sql.SQLException;
import java.util.function.BooleanSupplier;

import com.fssa.medlife.dao.MedicineDAO;
import com.fssa.medlife.model.Medicine;
import com.fssa.medlife.service.exception.ServiceException;
import com.fssa.medlife.validation.MedicineValidator;

import exception.InvalidMedicineException;

public class MedicineService {
	private MedicineDAO medicineDAO = new MedicineDAO();

    public boolean addMedicine(Medicine medicine) throws ServiceException, SQLException {
        try {

            MedicineValidator.validateMedicine(medicine);
            return medicineDAO.addMedicine(medicine);
        } catch (InvalidMedicineException e) {
            throw new ServiceException(e);
        }
    }

	
	// read
	
		// update 
		public static boolean updateMedicine(Medicine medicine) throws ServiceException {
			MedicineDAO medicineDAO = new MedicineDAO();
			try {
			if(MedicineValidator.validateMedicineName(medicine.getMedicineName())) { 
				if(medicineDAO.updateMedicine(medicine)) {
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
		public static boolean deleteMedicine(Medicine medicine) throws ServiceException {
			MedicineDAO medicineDAO = new MedicineDAO();
			try {
				if(medicineDAO.deleteMedicine(medicine)) {
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


		public BooleanSupplier updateMedicine(Medicine medicine1, String string, int i) {
			// TODO Auto-generated method stub
			return null;
		}
		 
}

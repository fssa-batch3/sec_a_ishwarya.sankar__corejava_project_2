package com.fssa.medlife.service;

import java.sql.SQLException;
import java.util.List;
import java.util.function.BooleanSupplier;

import com.fssa.medlife.dao.MedicineDAO;
import com.fssa.medlife.exception.DAOException;
import com.fssa.medlife.exception.ValidatorException;
import com.fssa.medlife.model.Medicine;
import com.fssa.medlife.model.User;
import com.fssa.medlife.service.exception.ServiceException;
import com.fssa.medlife.validation.MedicineValidator;

import exception.InvalidMedicineException;

public class MedicineService {

	/**
    * Adds a new medicine to the database.
    *
    * @param medicine The Medicine object to be added.
    * @return true if the medicine is successfully added, false otherwise.
    * @throws ServiceException if there is an issue with the service operation.
    */

//    
	public static boolean addMedicine(Medicine medicine) throws ServiceException {
		   MedicineDAO medicineDAO = new MedicineDAO();
		try {
			MedicineValidator.validateMedicine(medicine);
			if (medicineDAO.addMedicine(medicine)) {
				return true;
				
			} else {
				System.err.println("Creating failed");
				
				return false; 
			}
			
		} catch (InvalidMedicineException | DAOException e) {

			throw new ServiceException(e);
			
		}

		
	}
	/**
     * Retrieves a list of all medicines from the database.
     *
     * @return A list of Medicine objects representing all medicines in the database.
     * @throws ServiceException if there is an issue with the service operation.
     */
	
	
	//get all
	public List<Medicine> getAllMedicine() throws ServiceException {
		
		try {
			MedicineDAO medicineDAO = new MedicineDAO();

			return medicineDAO.getAllMedicines(); 
		} catch (DAOException e) {

			throw new ServiceException(e);
		}

	}
	   /**
     * Updates an existing medicine in the database.
     *
     * @param medicine The updated Medicine object.
     * @param id       The ID of the medicine to be updated.
     * @return true if the medicine is successfully updated, false otherwise.
     * @throws ServiceException if there is an issue with the service operation.
     */
//update 
	public boolean updateMedicine(Medicine medicine,int id) throws ServiceException {
		MedicineDAO medicineDAO = new MedicineDAO();
		try {
			MedicineValidator.validateMedicine(medicine);
			if (medicineDAO.updateMedicine(medicine,id)) {
				
				return true;
			} else {
				System.err.println("Update failed");
				return false;
			}

			
		} catch (InvalidMedicineException | DAOException e) {

			throw new ServiceException(e);
		}
	}
	  /**
     * Deletes a medicine from the database by its ID.
     *
     * @param id The ID of the medicine to be deleted.
     * @return true if the medicine is successfully deleted, false otherwise.
     * @throws ServiceException if there is an issue with the service operation.
     */
	
	// delete
	public boolean deleteMedicine(int id) throws ServiceException {
		MedicineDAO medicineDAO = new MedicineDAO();
		try {
			if (medicineDAO.deleteMedicine(id)) {
				return true;
			} else {
				System.err.println("Deletion failed for product with ID " + id + ".");
				return false;
			}

		} catch (DAOException e) {

			throw new ServiceException (e);
		}
	}
	
	public Medicine findMedicineById(int id) throws ServiceException {
	    try {
	        MedicineDAO medicineDAO = new MedicineDAO();
	        Medicine medicine = medicineDAO.findMedicineById(id);

	        if (medicine != null) {
	            return medicine;
	        } else {
	            System.err.println("Medicine not found");
	            return null;
	        }
	    } catch (DAOException e) {
	        throw new ServiceException(e);
	    }
	}

	
	
	
}

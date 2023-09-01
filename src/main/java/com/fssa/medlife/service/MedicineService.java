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

//    public static boolean addMedicine(Medicine medicine) throws ServiceException {
//        MedicineDAO medicineDAO = new MedicineDAO();
//        try {
//            MedicineValidator.validateMedicine(medicine);
//            medicineDAO.checkMedicineName(medicine.getMedicineName());
//            medicineDAO.addMedicine(medicine);
//            return true;
//        } catch (InvalidMedicineException | DAOException e) {
//            throw new ServiceException(e);
//        }
//    }
//
//    public void updateMedicine(int id, Medicine medicine) throws ServiceException {
//     
//        try {
//            MedicineValidator.validateMedicine(medicine);
//            MedicineDAO meddao = new MedicineDAO();
//            meddao.checkMedicineIdExists(id);
//            meddao.updateMedicine(id, medicine);
//        } catch (ValidatorException | DAOException e) {
//            throw new ServiceException(e);
//        }
//    }
//
//    public static boolean deleteMedicine(int id) throws ServiceException {
//        MedicineDAO medicineDAO = new MedicineDAO();
//        try {
//            MedicineValidator.validateId(id);
//            return medicineDAO.deleteMedicine(id);
//        } catch (ValidatorException | DAOException e) {
//            throw new ServiceException(e);
//        }
//    }
//
//    public List<Medicine> getAll() throws ServiceException {
//        MedicineDAO medicineDAO = new MedicineDAO();
//        try {
//            return medicineDAO.findAllMedicine();
//        } catch (DAOException e) {
//            throw new ServiceException(e);
//        }
//    }
//
//    public Medicine findById(int id) throws ServiceException {
//        try {
//            MedicineValidator.validateId(id);
//            MedicineDAO medicineDAO = new MedicineDAO();
//            medicineDAO.checkMedicineIdExists(id);
//            return medicineDAO.findById(id);
//        } catch (ValidatorException | DAOException e) {
//            throw new ServiceException(e);
//        }
//    }
//
//    public void deleteMedicine(Medicine medicineToDelete) {
//    }
//
//    public Set<Medicine> findAllMedicine() {
//        return null;
//    }
//}
	public static boolean addMedicine(Medicine medicine) throws ServiceException {
		   MedicineDAO medicineDAO = new MedicineDAO();
		try {
			MedicineValidator.validateMedicine(medicine);// Validate the product using ProductValidator
			// Check if the product creation in the DAO was successful
			if (medicineDAO.addMedicine(medicine)) {
				return true;
			} else {
				System.err.println("Creating failed");
				return false; 
			}
			// Catch exceptions related to invalid products or DAO issues and throw a
			// ServiceException

		} catch (InvalidMedicineException | DAOException e) {

			throw new ServiceException(e);
		}

	}
	
	//get all
	public List<Medicine> getAllMedicine() throws ServiceException {
		
		try {
			MedicineDAO medicineDAO = new MedicineDAO();

			return medicineDAO.getAllMedicines(); 
		} catch (DAOException e) {

			throw new ServiceException(e);
		}

	}
//update 
	public boolean updateMedicine(Medicine medicine,int id) throws ServiceException {
		MedicineDAO medicineDAO = new MedicineDAO();
		try {
			MedicineValidator.validateMedicine(medicine);// Validate the product using ProductValidator
			// Check if the product update in the DAO was successful and provide feedback
			if (medicineDAO.updateMedicine(medicine,id)) {
				
				return true;
			} else {
				System.err.println("Update failed");
				return false;
			}

			// Catch exceptions related to invalid products or DAO issues and throw a
			// ServiceException
		} catch (InvalidMedicineException | DAOException e) {

			throw new ServiceException(e);
		}
	}
	
	// delete
	public boolean deleteMedicine(int id) throws ServiceException {
		MedicineDAO medicineDAO = new MedicineDAO();
		try {
			// Check if the product deletion in the DAO was successful and provide feedback
			if (medicineDAO.deleteMedicine(id)) {
				return true;
			} else {
				System.err.println("Deletion failed for product with ID " + id + ".");
				return false;
			}

		} catch (DAOException e) {

			throw new ServiceException (e);// Catch exceptions related to DAO issues and throw a
															// ServiceException
		}
	}
	
//	public static boolean addMedicine(Medicine medicine) throws ServiceException {
//        try {
//            MedicineValidator.validateMedicine(medicine);
//            MedicineDAO medicineDAO = new MedicineDAO();
//            return medicineDAO.addMedicine(medicine);
//        } catch (InvalidMedicineException | SQLException e) {
//            throw new ServiceException(e);
//        }
//    }

//	public List<Medicine> getAllMedicine() throws ServiceException {
//        try {
//        	 MedicineDAO medicineDAO = new MedicineDAO();
//             return medicineDAO.getAllMedicines();
//        } catch (SQLException e) {
//            throw new ServiceException(e);
//        }
//    }
    
//    public  boolean updateMedicine(Medicine medicine,int id) throws ServiceException {
//        try {
//        	MedicineValidator.validateMedicine(medicine); // Use the instance you created
//        	  MedicineDAO medicineDAO = new MedicineDAO();
//            return medicineDAO.updateMedicine(medicine,id);
//        } catch (InvalidMedicineException | SQLException e) {
//            throw new ServiceException(e);
//        }
//    } 

  
//    public boolean deleteMedicine(int id) throws ServiceException {
//        try {
//        	MedicineDAO medicineDAO = new MedicineDAO();
//            return medicineDAO.deleteMedicine(id);
//        } catch (SQLException e) {
//            throw new ServiceException(e);
//        }
//    }


	
	
}

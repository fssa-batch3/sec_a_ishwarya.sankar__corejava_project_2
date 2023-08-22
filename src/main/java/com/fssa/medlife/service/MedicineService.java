package com.fssa.medlife.service;

import java.util.Set;
import com.fssa.medlife.dao.MedicineDAO;
import com.fssa.medlife.exception.DAOException;
import com.fssa.medlife.exception.ValidatorException;
import com.fssa.medlife.model.Medicine;
import com.fssa.medlife.service.exception.ServiceException;
import com.fssa.medlife.validation.MedicineValidator;

public class MedicineService {
	
	public void addMedicine(Medicine medicine) throws DAOException, ValidatorException {
		MedicineDAO medicineDAO = new MedicineDAO();
			MedicineValidator.validateMedicine(medicine);
			medicineDAO.checkMedicineName(medicine.getMedicineName());
			medicineDAO.addMedicine(medicine);

	}

	// update
	public static void updateMedicine(int id, Medicine medicine) throws DAOException, ServiceException{
		MedicineDAO medicineDAO = new MedicineDAO();
		try {
			MedicineValidator.validateMedicine(medicine);
			MedicineDAO meddao = new MedicineDAO();
			meddao.checkMedicineIdExists(id);
			meddao.updateMedicine(id,medicine);
		} catch (ValidatorException e) {
			throw new ServiceException(e);
		}

	}

	// DELETE
	public static void deleteMedicine(int id) throws DAOException, ServiceException{
		MedicineDAO medicineDAO = new MedicineDAO();
		try {
			MedicineValidator.validateId(id);
			medicineDAO.checkMedicineIdExists(id);
			medicineDAO.deleteMedicine(id);
		} catch (ValidatorException e) {
			throw new ServiceException(e);
		}

	}

	//READ
	public Set<Medicine> getAll() throws DAOException {
		MedicineDAO medicineDAO = new MedicineDAO();
		Set<Medicine> medList = medicineDAO.findAllMedicine();
		for (Medicine med : medList) {
			System.out.println(med);
		}
		return medList;
	}

	public static Medicine findById(int id) throws ServiceException, DAOException {
		try {
		MedicineValidator.validateId(id);
		MedicineDAO medicineDAO = new MedicineDAO();
		medicineDAO.checkMedicineIdExists(id);
		return medicineDAO.findById(id);
		}catch (ValidatorException e) {
			throw new ServiceException(e);
		}
	}

}

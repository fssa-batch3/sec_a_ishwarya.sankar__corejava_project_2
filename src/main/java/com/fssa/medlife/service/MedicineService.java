package com.fssa.medlife.service;

import java.util.List;
import java.util.Set;

import com.fssa.medlife.dao.MedicineDAO;
import com.fssa.medlife.exception.DAOException;
import com.fssa.medlife.exception.ValidatorException;
import com.fssa.medlife.model.Medicine;
import com.fssa.medlife.service.exception.ServiceException;
import com.fssa.medlife.validation.MedicineValidator;

public class MedicineService {

    public static boolean addMedicine(Medicine medicine) throws ServiceException {
        MedicineDAO medicineDAO = new MedicineDAO();
        try {
            MedicineValidator.validateMedicine(medicine);
            medicineDAO.checkMedicineName(medicine.getMedicineName());
            medicineDAO.addMedicine(medicine);
            return true;
        } catch (ValidatorException | DAOException e) {
            throw new ServiceException(e);
        }
    }

    public void updateMedicine(int id, Medicine medicine) throws ServiceException {
     
        try {
            MedicineValidator.validateMedicine(medicine);
            MedicineDAO meddao = new MedicineDAO();
            meddao.checkMedicineIdExists(id);
            meddao.updateMedicine(id, medicine);
        } catch (ValidatorException | DAOException e) {
            throw new ServiceException(e);
        }
    }

    public static boolean deleteMedicine(int id) throws ServiceException {
        MedicineDAO medicineDAO = new MedicineDAO();
        try {
            MedicineValidator.validateId(id);
            return medicineDAO.deleteMedicine(id);
        } catch (ValidatorException | DAOException e) {
            throw new ServiceException(e);
        }
    }

    public List<Medicine> getAll() throws ServiceException {
        MedicineDAO medicineDAO = new MedicineDAO();
        try {
            return medicineDAO.findAllMedicine();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public Medicine findById(int id) throws ServiceException {
        try {
            MedicineValidator.validateId(id);
            MedicineDAO medicineDAO = new MedicineDAO();
            medicineDAO.checkMedicineIdExists(id);
            return medicineDAO.findById(id);
        } catch (ValidatorException | DAOException e) {
            throw new ServiceException(e);
        }
    }

    public void deleteMedicine(Medicine medicineToDelete) {
        // TODO Auto-generated method stub
    }

    public Set<Medicine> findAllMedicine() {
        // TODO Auto-generated method stub
        return null;
    }
}

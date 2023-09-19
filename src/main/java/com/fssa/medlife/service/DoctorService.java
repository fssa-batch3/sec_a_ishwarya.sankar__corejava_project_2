package com.fssa.medlife.service;

import java.sql.SQLException;
import java.util.List;

import com.fssa.medlife.dao.DoctorDAO;
import com.fssa.medlife.exception.DAOException;
import com.fssa.medlife.model.Appointment;
import com.fssa.medlife.model.Doctor;
import com.fssa.medlife.service.exception.ServiceException;

public class DoctorService {
	
	    public boolean addDoctor(Doctor doctor) throws ServiceException {
	        try {
	        	System.out.println(doctor);
	            DoctorDAO doctorDAO = new DoctorDAO();
	            return doctorDAO.addDoctor(doctor);
	        } catch (DAOException e) {
	            throw new ServiceException(e);
	        }
	    }

	    public List<Doctor> getAllDoctors() throws ServiceException, ClassNotFoundException {
	        try {
	            DoctorDAO doctorDAO = new DoctorDAO();
	            return doctorDAO.getAllDoctors();
	        } catch (SQLException e) {
	            throw new ServiceException(e);
	        }
	    }

	    public boolean updateDoctor(Doctor doctor) throws ServiceException, ClassNotFoundException {
	        try {
	            DoctorDAO doctorDAO = new DoctorDAO();
	            return doctorDAO.updateDoctor(doctor);
	        } catch (SQLException e) {
	            throw new ServiceException(e);
	        }
	    }

	    public boolean deleteDoctor(String doctorName) throws ServiceException, ClassNotFoundException {
	        try {
	            DoctorDAO doctorDAO = new DoctorDAO();
	            return doctorDAO.deleteDoctor(doctorName);
	        } catch (SQLException e) {
	            throw new ServiceException(e);
	        }
	    }
	    public List<Appointment> getAppointmentsForDoctor(int id) throws ServiceException {
	        DoctorDAO doctorDAO = new DoctorDAO();
	        try {
	            return doctorDAO.getAppointmentsForDoctor(id); // Assuming you have a method for this in DoctorDAO
	        } catch (DAOException e) {
	            throw new ServiceException("Failed to retrieve doctor appointments");
	        }
	    }
}

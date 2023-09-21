package com.fssa.medlife.service;

import java.util.List;

import com.fssa.medlife.dao.AppointmentDAO;
import com.fssa.medlife.exception.DAOException;
import com.fssa.medlife.model.Appointment;
import com.fssa.medlife.service.exception.ServiceException;
import com.fssa.medlife.validation.AppointmentValidator;

import exception.InvalidAppointmentException;
import exception.InvalidUserException;

public class AppointmentService {

	  private AppointmentValidator appointmentValidator = new AppointmentValidator();
	  public boolean createAppointment(Appointment appointment) throws ServiceException {
		    AppointmentDAO appointmentDAO = new AppointmentDAO();
		    try {
		        appointmentValidator.validateAppointment(appointment);
		        if (appointmentDAO.createAppointment(appointment)) {
		            return true;
		        } else {
		            System.err.println("Creating appointment failed");
		            return false;
		        }
		    } catch (InvalidAppointmentException | DAOException e) {
		        throw new ServiceException(e);
		    }
		}

	    public List<Appointment> getAllUserAppointments(int userId) throws ServiceException {
	        try {
		        AppointmentDAO appointmentDAO = new AppointmentDAO();
	            return appointmentDAO.getAllUserAppointments(userId);
	        } catch (DAOException e) {
	            throw new ServiceException("Failed to retrieve user appointments");
	        }
	    }
	    
	    public List<Appointment> getAllDoctorAppointments(int doctorId) throws ServiceException {
	        try {
	            AppointmentDAO appointmentDAO = new AppointmentDAO();
	            return appointmentDAO.getAllDoctorAppointments(doctorId);
	        } catch (DAOException e) {
	            throw new ServiceException("Failed to retrieve doctor appointments");
	        }
	    }

//	    public List<Appointment> getAllAppointments() throws ServiceException {
//	        try {
//	            AppointmentDAO appointmentDAO = new AppointmentDAO();
//	            return appointmentDAO.getAllAppointments();
//	        } catch (DAOException e) {
//	            throw new ServiceException(e);
//	        }
//	    }
	   

	    public boolean updateAppointment(Appointment appointment) throws ServiceException {
	        AppointmentDAO appointmentDAO = new AppointmentDAO();
	        try {
	            appointmentValidator.validateAppointment(appointment);
	            if (appointmentDAO.updateAppointment(appointment)) {
	                return true;
	            } else {
	                System.err.println("Updating appointment failed");
	                return false;
	            }
	        } catch (InvalidAppointmentException | DAOException e) {
	            throw new ServiceException(e);
	        }
	    }

	    public boolean deleteAppointment(int userId) throws ServiceException {
	        AppointmentDAO appointmentDAO = new AppointmentDAO();
	        try {
	            if (appointmentDAO.deleteAppointment(userId)) {
	                return true;
	            } else {
	                System.err.println("Deleting appointment failed for user ID " + userId + ".");
	                return false;
	            }
	        } catch (DAOException e) {
	            throw new ServiceException(e);
	        }
	    }

}

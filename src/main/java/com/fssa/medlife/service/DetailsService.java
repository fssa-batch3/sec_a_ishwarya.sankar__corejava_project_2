package com.fssa.medlife.service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.fssa.medlife.dao.DetailsDAO;
import com.fssa.medlife.exception.DAOException;
import com.fssa.medlife.model.Doctordetails;
import com.fssa.medlife.service.exception.ServiceException;
import com.fssa.medlife.utils.ConnectionUtil;

public class DetailsService {
	
	
	public boolean addDoctorDetails(Doctordetails doctor) throws ServiceException {
	    DetailsDAO detailDAO = new DetailsDAO();
	    try {
	        return detailDAO.addDoctorDetails(doctor);
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new ServiceException("Failed to add doctor details");
	    }
	}
	
	public List<Doctordetails> listDoctorDetails() throws ServiceException {
	    DetailsDAO detailDAO = new DetailsDAO();
	    try {
	        return detailDAO.listDoctorDetails();
	    } catch (DAOException e) {
	        e.printStackTrace();
	        throw new ServiceException("Failed to list doctor details");
	    }
	}

	
	

    public List<Doctordetails> listDoctorDetailsById(int id) throws ServiceException {
        try {
        	DetailsDAO detailDAO = new DetailsDAO();

            return detailDAO.listDoctorDetails(id);
        } catch (DAOException e) {
            throw new ServiceException("Error fetching doctor details");
        }
    }
    
	 public List<Doctordetails> listDoctorDetailsByUserId(int userId) throws ServiceException {
		    DetailsDAO detailDAO = new DetailsDAO();

	        try {
	            return detailDAO.listDoctorDetailsByUserId(userId);
	        } catch (DAOException e) {
	            throw new ServiceException("Error fetching doctor details by userId");
	        }
	    }
	
	 
	   public boolean isUserIdPresent(int userId) throws ServiceException {
		    DetailsDAO detailDAO = new DetailsDAO();
		    return detailDAO.isUserIdPresent(userId);
		}
	   
	 
	   
	   
	   
}

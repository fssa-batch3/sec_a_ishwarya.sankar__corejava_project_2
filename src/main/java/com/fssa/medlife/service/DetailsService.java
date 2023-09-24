package com.fssa.medlife.service;
import java.util.List;

import com.fssa.medlife.dao.DetailsDAO;
import com.fssa.medlife.exception.DAOException;
import com.fssa.medlife.model.Doctordetails;
import com.fssa.medlife.service.exception.ServiceException;

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

}

package com.surveybuilder.service;

import java.util.List;

import com.surveybuilder.enitity.Admin;
import com.surveybuilder.exception.ResourceNotFoundException;

public interface AdminService {
	public Admin createAdminService(Admin s);
	public Admin viewAdminByIdService(long id);
	public Admin updateAdminService(Admin s, long id) throws ResourceNotFoundException;
	public boolean deleteAdminByIdService(long id) throws ResourceNotFoundException;
	public List<Admin> listAllAdminService();
	
}

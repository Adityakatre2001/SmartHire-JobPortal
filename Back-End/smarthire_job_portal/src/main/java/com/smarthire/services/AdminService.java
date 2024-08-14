package com.smarthire.services;


import java.util.List;

import com.smarthire.dtos.CompanyDTO;
import com.smarthire.dtos.UserDTO;


public interface AdminService {
	    
	    // User Management
	    UserDTO createUser(UserDTO userDTO);
	    UserDTO updateUser(Long userId, UserDTO userDTO);
	    void deleteUser(Long userId);
	    UserDTO getUserById(Long userId);
	    List<UserDTO> getAllUsers();
	    
	    
	    // Company Management
	    CompanyDTO createCompany(CompanyDTO companyDTO);
	    CompanyDTO updateCompany(Long companyId, CompanyDTO companyDTO);
	    void deleteCompany(Long companyId);
	    CompanyDTO getCompanyById(Long companyId);
	    List<CompanyDTO> getAllCompanies();
	    
	   

	   
	}



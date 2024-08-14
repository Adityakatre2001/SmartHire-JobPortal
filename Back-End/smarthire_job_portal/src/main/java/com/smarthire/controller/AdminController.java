package com.smarthire.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smarthire.dtos.CompanyDTO;
import com.smarthire.dtos.UserDTO;
import com.smarthire.services.AdminService;

	@RestController
	@RequestMapping("/admin")
	public class AdminController {

	    @Autowired
	    private AdminService adminService;

	    // User Endpoints

	    @PostMapping("/users")
	    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
	        UserDTO createdUser = adminService.createUser(userDTO);
	        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
	    }

	    @PutMapping("/users/{userId}")
	    public ResponseEntity<UserDTO> updateUser(@PathVariable Long userId, @RequestBody UserDTO userDTO) {
	        UserDTO updatedUser = adminService.updateUser(userId, userDTO);
	        return ResponseEntity.ok(updatedUser);
	    }

	    @DeleteMapping("/users/{userId}")
	    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
	        adminService.deleteUser(userId);
	        return ResponseEntity.noContent().build();
	    }

	    @GetMapping("/users/{userId}")
	    public ResponseEntity<UserDTO> getUserById(@PathVariable Long userId) {
	        UserDTO user = adminService.getUserById(userId);
	        return ResponseEntity.ok(user);
	    }

	    @GetMapping("/users")
	    public ResponseEntity<List<UserDTO>> getAllUsers() {
	        List<UserDTO> users = adminService.getAllUsers();
	        return ResponseEntity.ok(users);
	    }

	    // Company Endpoints

	    @PostMapping("/companies")
	    public ResponseEntity<CompanyDTO> createCompany(@RequestBody CompanyDTO companyDTO) {
	        CompanyDTO createdCompany = adminService.createCompany(companyDTO);
	        return new ResponseEntity<>(createdCompany, HttpStatus.CREATED);
	    }

	    @PutMapping("/companies/{companyId}")
	    public ResponseEntity<CompanyDTO> updateCompany(@PathVariable Long companyId, @RequestBody CompanyDTO companyDTO) {
	        CompanyDTO updatedCompany = adminService.updateCompany(companyId, companyDTO);
	        return ResponseEntity.ok(updatedCompany);
	    }

	    @DeleteMapping("/companies/{companyId}")
	    public ResponseEntity<Void> deleteCompany(@PathVariable Long companyId) {
	        adminService.deleteCompany(companyId);
	        return ResponseEntity.noContent().build();
	    }

	    @GetMapping("/companies/{companyId}")
	    public ResponseEntity<CompanyDTO> getCompanyById(@PathVariable Long companyId) {
	        CompanyDTO company = adminService.getCompanyById(companyId);
	        return ResponseEntity.ok(company);
	    }

	    @GetMapping("/companies")
	    public ResponseEntity<List<CompanyDTO>> getAllCompanies() {
	        List<CompanyDTO> companies = adminService.getAllCompanies();
	        return ResponseEntity.ok(companies);
	    }
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


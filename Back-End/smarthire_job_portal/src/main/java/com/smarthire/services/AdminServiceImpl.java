
package com.smarthire.services;

import java.util.List;
import java.util.stream.Collectors;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smarthire.dtos.CompanyDTO;
import com.smarthire.dtos.UserDTO;
import com.smarthire.entities.Company;
import com.smarthire.entities.User;
import com.smarthire.repository.CompanyRepository;
import com.smarthire.repository.UserRepository;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CompanyRepository companyRepository;

    // User Management

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserDTO.class);
    }

    @Override
    public UserDTO updateUser(Long userId, UserDTO userDTO) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));
        modelMapper.map(userDTO, user); // Update existing user with new values
        User updatedUser = userRepository.save(user);
        return modelMapper.map(updatedUser, UserDTO.class);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public UserDTO getUserById(Long userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
            .map(user -> modelMapper.map(user, UserDTO.class))
            .collect(Collectors.toList());
    }

    // Company Management

    @Override
    public CompanyDTO createCompany(CompanyDTO companyDTO) {
        Company company = modelMapper.map(companyDTO, Company.class);
        Company savedCompany = companyRepository.save(company);
        return modelMapper.map(savedCompany, CompanyDTO.class);
    }

    @Override
    public CompanyDTO updateCompany(Long companyId, CompanyDTO companyDTO) {
        Company company = companyRepository.findById(companyId)
            .orElseThrow(() -> new RuntimeException("Company not found"));
        modelMapper.map(companyDTO, company); // Update existing company with new values
        Company updatedCompany = companyRepository.save(company);
        return modelMapper.map(updatedCompany, CompanyDTO.class);
    }

    @Override
    public void deleteCompany(Long companyId) {
        companyRepository.deleteById(companyId);
    }

    @Override
    public CompanyDTO getCompanyById(Long companyId) {
        Company company = companyRepository.findById(companyId)
            .orElseThrow(() -> new RuntimeException("Company not found"));
        return modelMapper.map(company, CompanyDTO.class);
    }

    @Override
    public List<CompanyDTO> getAllCompanies() {
        return companyRepository.findAll().stream()
            .map(company -> modelMapper.map(company, CompanyDTO.class))
            .collect(Collectors.toList());
    }
}






























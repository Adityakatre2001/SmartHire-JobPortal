package com.smarthire.services;

import com.smarthire.dtos.CompanyDTO;
import com.smarthire.entities.Company;
import com.smarthire.repository.CompanyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;



@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CompanyRepository companyRepository;

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
        modelMapper.map(companyDTO, company);
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


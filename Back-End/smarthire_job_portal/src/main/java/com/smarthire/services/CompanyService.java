package com.smarthire.services;

import com.smarthire.dtos.CompanyDTO;

import java.util.List;

public interface CompanyService {
    CompanyDTO createCompany(CompanyDTO companyDTO);
    CompanyDTO updateCompany(Long companyId, CompanyDTO companyDTO);
    void deleteCompany(Long companyId);
    CompanyDTO getCompanyById(Long companyId);
    List<CompanyDTO> getAllCompanies();
}

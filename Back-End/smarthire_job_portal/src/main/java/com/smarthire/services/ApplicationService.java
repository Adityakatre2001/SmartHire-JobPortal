package com.smarthire.services;

import java.util.List;

import com.smarthire.dtos.ApplicantDTO;

public interface ApplicationService {
    ApplicantDTO createApplication(ApplicantDTO applicationDTO);
    ApplicantDTO updateApplication(Long applicationId, ApplicantDTO applicationDTO);
    void deleteApplication(Long applicationId);
    ApplicantDTO getApplicationById(Long applicationId);
    List<ApplicantDTO> getAllApplications();
}


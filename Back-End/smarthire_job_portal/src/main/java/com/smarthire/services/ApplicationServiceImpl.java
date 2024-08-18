
package com.smarthire.services;

import java.util.List;
import java.util.stream.Collectors;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smarthire.dtos.ApplicantDTO;
import com.smarthire.entities.JobApplication;
import com.smarthire.repository.ApplicationRepository;

@Service
@Transactional
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ApplicationRepository applicationRepository;

    @Override
    public ApplicantDTO createApplication(ApplicantDTO applicantDTO) {
        // Convert DTO to Entity
        JobApplication jobApplication = modelMapper.map(applicantDTO, JobApplication.class);
        // Save Entity
        JobApplication savedJobApplication = applicationRepository.save(jobApplication);
        // Convert saved Entity to DTO
        return modelMapper.map(savedJobApplication, ApplicantDTO.class);
    }

    @Override
    public ApplicantDTO updateApplication(Long applicationId, ApplicantDTO applicantDTO) {
        // Find existing Entity
        JobApplication jobApplication = applicationRepository.findById(applicationId)
                .orElseThrow(() -> new RuntimeException("Application not found"));
        // Update Entity
        modelMapper.map(applicantDTO, jobApplication);
        // Save updated Entity
        JobApplication updatedJobApplication = applicationRepository.save(jobApplication);
        // Convert updated Entity to DTO
        return modelMapper.map(updatedJobApplication, ApplicantDTO.class);
    }

    @Override
    public void deleteApplication(Long applicationId) {
        applicationRepository.deleteById(applicationId);
    }

    @Override
    public ApplicantDTO getApplicationById(Long applicationId) {
        // Find existing Entity
        JobApplication jobApplication = applicationRepository.findById(applicationId)
                .orElseThrow(() -> new RuntimeException("Application not found"));
        // Convert Entity to DTO
        return modelMapper.map(jobApplication, ApplicantDTO.class);
    }

    @Override
    public List<ApplicantDTO> getAllApplications() {
        return applicationRepository.findAll().stream()
                .map(jobApplication -> modelMapper.map(jobApplication, ApplicantDTO.class))
                .collect(Collectors.toList());
    }
}


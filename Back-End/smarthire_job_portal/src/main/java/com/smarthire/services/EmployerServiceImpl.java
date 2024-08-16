

package com.smarthire.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smarthire.dtos.ApplicantDTO;
import com.smarthire.dtos.JobPostDTO;
import com.smarthire.entities.JobPosting;
import com.smarthire.repository.ApplicationRepository;
import com.smarthire.repository.JobPostingRepository;

@Service
@Transactional
public class EmployerServiceImpl implements EmployerService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private JobPostingRepository jobPostingRepository;

    @Autowired
    private ApplicationRepository applicationRepository;

    @Override
    public JobPostDTO createJobPosting(JobPostDTO jobPostingDTO) {
        JobPosting jobPosting = modelMapper.map(jobPostingDTO, JobPosting.class);
        JobPosting savedJobPosting = jobPostingRepository.save(jobPosting);
        return modelMapper.map(savedJobPosting, JobPostDTO.class);
    }

    @Override
    public JobPostDTO updateJobPosting(Long jobId, JobPostDTO jobPostingDTO) {
        JobPosting jobPosting = jobPostingRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job Posting not found"));
        modelMapper.map(jobPostingDTO, jobPosting);
        JobPosting updatedJobPosting = jobPostingRepository.save(jobPosting);
        return modelMapper.map(updatedJobPosting, JobPostDTO.class);
    }

    @Override
    public void deleteJobPosting(Long jobId) {
        jobPostingRepository.deleteById(jobId);
    }

    @Override
    public JobPostDTO getJobPostingById(Long jobId) {
        JobPosting jobPosting = jobPostingRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job Posting not found"));
        return modelMapper.map(jobPosting, JobPostDTO.class);
    }

    @Override
    public List<JobPostDTO> getAllJobPostings() {
        return jobPostingRepository.findAll().stream()
                .map(jobPosting -> modelMapper.map(jobPosting, JobPostDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ApplicantDTO> getApplicationsForJob(Long jobId) {
        JobPosting jobPosting = jobPostingRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job Posting not found"));
        return applicationRepository.findByJobPosting(jobPosting).stream()
                .map(application -> modelMapper.map(application, ApplicantDTO.class))
                .collect(Collectors.toList());
    }
}















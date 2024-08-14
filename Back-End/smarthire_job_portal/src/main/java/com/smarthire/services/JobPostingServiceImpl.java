package com.smarthire.services;

import com.smarthire.dtos.JobPostDTO;
import com.smarthire.entities.JobPosting;
import com.smarthire.repository.JobPostingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobPostingServiceImpl implements JobPostingService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private JobPostingRepository jobPostingRepository;

    @Override
    public JobPostDTO createJobPosting(JobPostDTO jobPostDTO) {
        JobPosting jobPosting = modelMapper.map(jobPostDTO, JobPosting.class);
        JobPosting savedJobPosting = jobPostingRepository.save(jobPosting);
        return modelMapper.map(savedJobPosting, JobPostDTO.class);
    }

    @Override
    public JobPostDTO updateJobPosting(Long jobId, JobPostDTO jobPostDTO) {
        JobPosting jobPosting = jobPostingRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job Posting not found"));
        modelMapper.map(jobPostDTO, jobPosting);
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
}

package com.smarthire.services;

import java.util.List;

import com.smarthire.dtos.JobPostDTO;

public interface JobPostingService {
    JobPostDTO createJobPosting(JobPostDTO jobPostingDTO);
    JobPostDTO updateJobPosting(Long jobId, JobPostDTO jobPostingDTO);
    void deleteJobPosting(Long jobId);
    JobPostDTO getJobPostingById(Long jobId);
    List<JobPostDTO> getAllJobPostings();
}


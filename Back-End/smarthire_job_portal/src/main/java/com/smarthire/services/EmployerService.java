package com.smarthire.services;

import java.util.List;

import com.smarthire.dtos.ApplicantDTO;
import com.smarthire.dtos.JobPostDTO;

public interface EmployerService {
    JobPostDTO createJobPosting(JobPostDTO jobPostingDTO);
    JobPostDTO updateJobPosting(Long jobId, JobPostDTO jobPostingDTO);
    void deleteJobPosting(Long jobId);
    JobPostDTO getJobPostingById(Long jobId);
    List<JobPostDTO> getAllJobPostings();
    List<ApplicantDTO> getApplicationsForJob(Long jobId);
}

package com.smarthire.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smarthire.entities.JobApplication;
import com.smarthire.entities.JobPosting;

@Repository
public interface ApplicationRepository extends JpaRepository<JobApplication, Long> {
    // Find applications by user ID
    List<JobApplication> findByUser_UserId(Long userId);

    // Find applications by job posting ID
    List<JobApplication> findByJobPosting_JobId(Long jobPostingId);
    
    List<JobApplication> findByJobPosting(JobPosting jobPosting);
   
}
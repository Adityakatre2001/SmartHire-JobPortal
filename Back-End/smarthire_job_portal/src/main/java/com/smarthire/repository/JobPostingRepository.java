package com.smarthire.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smarthire.entities.JobPosting;

@Repository
public interface JobPostingRepository extends JpaRepository<JobPosting, Long> {
    // Find job postings by employer ID
    List<JobPosting> findByEmployer_CompanyId(Long employerId);
}


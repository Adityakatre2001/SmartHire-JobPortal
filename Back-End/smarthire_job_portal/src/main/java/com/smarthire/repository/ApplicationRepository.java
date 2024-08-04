package com.smarthire.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smarthire.entites.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
    // Find applications by user ID
    List<Application> findByUser_UserId(Long userId);

    // Find applications by job posting ID
    List<Application> findByJobPosting_JobId(Long jobPostingId);
   
}


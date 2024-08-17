package com.smarthire.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smarthire.dtos.ApplicantDTO;
import com.smarthire.dtos.JobPostDTO;
import com.smarthire.services.EmployerService;

@RestController
@RequestMapping("/employers")
@CrossOrigin("*")
public class EmployerController {

    @Autowired
    private EmployerService employerService;

    // Job Posting Management
    @PostMapping("/jobs")
    public ResponseEntity<JobPostDTO> createJobPosting(@RequestBody JobPostDTO jobPostingDTO) {
        JobPostDTO createdJobPosting = employerService.createJobPosting(jobPostingDTO);
        return ResponseEntity.ok(createdJobPosting);
    }

    @PutMapping("/jobs/{jobId}")
    public ResponseEntity<JobPostDTO> updateJobPosting(@PathVariable Long jobId, @RequestBody JobPostDTO jobPostingDTO) {
        JobPostDTO updatedJobPosting = employerService.updateJobPosting(jobId, jobPostingDTO);
        return ResponseEntity.ok(updatedJobPosting);
    }

    @DeleteMapping("/jobs/{jobId}")
    public ResponseEntity<Void> deleteJobPosting(@PathVariable Long jobId) {
        employerService.deleteJobPosting(jobId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/jobs/{jobId}")
    public ResponseEntity<JobPostDTO> getJobPostingById(@PathVariable Long jobId) {
        JobPostDTO jobPostingDTO = employerService.getJobPostingById(jobId);
        return ResponseEntity.ok(jobPostingDTO);
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<JobPostDTO>> getAllJobPostings() {
        List<JobPostDTO> jobPostings = employerService.getAllJobPostings();
        return ResponseEntity.ok(jobPostings);
    }

    // Application Management
    @GetMapping("/jobs/{jobId}/applications")
    public ResponseEntity<List<ApplicantDTO>> getApplicationsForJob(@PathVariable Long jobId) {
        List<ApplicantDTO> applications = employerService.getApplicationsForJob(jobId);
        return ResponseEntity.ok(applications);
    }
}




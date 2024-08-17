package com.smarthire.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "application")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobApplication {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long applicationId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)//User(Applicant) 1---->*Applications
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)//User(Employer)1 ---> * JobPost
    @JoinColumn(name = "jobId", nullable = false)
    private JobPosting jobPosting;

    @NotNull
    @Size(max = 50)
    @Column(nullable = false, length = 50)
    private JobApplicationStatus status;
    
    @NotNull
    @Column(name = "application_date", nullable = false)
    private LocalDate applicationDate;
}

package com.smarthire.entities;

import java.time.LocalDate;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.*;

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

    @ManyToOne(cascade = CascadeType.ALL)//User(Applicant) 1---->*Applications
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)//User(Employer)1 ---> * JobPost
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

package com.smarthire.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Map;
import java.util.HashMap;
import lombok.*;

@Entity
@Table(name = "job_posting")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobPosting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobId;

    @NotNull
    @Column(name = "post_date", nullable = false, updatable = false)
    private LocalDate postDate;

    @Size(max = 5000)
    @Column(length = 5000)
    private String jobDescription;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company employer;
    
    @NotNull
    private Double salary;

    @NotNull
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String jobTitle;

    @NotNull
    @Size(max = 255)
    @Column(nullable = false, length = 255)
    private String jobLocation;

    @Column(name = "close_date")
    private LocalDate closeDate;

    @OneToMany(mappedBy = "jobPosting", cascade = CascadeType.ALL, orphanRemoval = true)
    @MapKey(name = "applicationId")  
    private Map<Long, JobApplication> applications = new HashMap<>();
}

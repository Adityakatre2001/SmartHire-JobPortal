package com.smarthire.entites;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "job_posting")
@Getter
@Setter
@AllArgsConstructor
@ToString
public class JobPosting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobId;

    @NotNull
    //@Temporal(TemporalType.DATE)
    @UpdateTimestamp
    @Column(name = "post_date", nullable = false)
    private LocalDate postDate;

    @Size(max = 5000)
    @Column(length = 5000)
    private String jobDescription;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "employer_id", nullable = false)
    private Company employer;

    @NotNull
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String jobTitle;

    @NotNull
    @Size(max = 255)
    @Column(nullable = false, length = 255)
    private String jobLocation;

    //@Temporal(TemporalType.DATE)
    @UpdateTimestamp
    @Column(name = "close_date")
    private LocalDate closeDate;

    @OneToMany(mappedBy = "jobPosting", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Application> applications;

    // Constructors, getters, and setters

	/*
	 * public JobPosting() { }
	 * 
	 * public JobPosting(LocalDate postDate, String jobDescription, Company
	 * employer, String jobTitle, String jobLocation, LocalDate closeDate) {
	 * this.postDate = postDate; this.jobDescription = jobDescription; this.employer
	 * = employer; this.jobTitle = jobTitle; this.jobLocation = jobLocation;
	 * this.closeDate = closeDate; }
	 */

    // Getters and setters

	/*
	 * public Long getJobId() { return jobId; }
	 * 
	 * public void setJobId(Long jobId) { this.jobId = jobId; }
	 * 
	 * public Date getPostDate() { return postDate; }
	 * 
	 * public void setPostDate(Date postDate) { this.postDate = postDate; }
	 * 
	 * public String getJobDescription() { return jobDescription; }
	 * 
	 * public void setJobDescription(String jobDescription) { this.jobDescription =
	 * jobDescription; }
	 * 
	 * public Company getEmployer() { return employer; }
	 * 
	 * public void setEmployer(Company employer) { this.employer = employer; }
	 * 
	 * public String getJobTitle() { return jobTitle; }
	 * 
	 * public void setJobTitle(String jobTitle) { this.jobTitle = jobTitle; }
	 * 
	 * public String getJobLocation() { return jobLocation; }
	 * 
	 * public void setJobLocation(String jobLocation) { this.jobLocation =
	 * jobLocation; }
	 * 
	 * public Date getCloseDate() { return closeDate; }
	 * 
	 * public void setCloseDate(Date closeDate) { this.closeDate = closeDate; }
	 * 
	 * public List<Application> getApplications() { return applications; }
	 * 
	 * public void setApplications(List<Application> applications) {
	 * this.applications = applications; }
	 * 
	 * @Override public String toString() { return "JobPosting{" + "jobId=" + jobId
	 * + ", postDate=" + postDate + ", jobDescription='" + jobDescription + '\'' +
	 * ", employer=" + employer + ", jobTitle='" + jobTitle + '\'' +
	 * ", jobLocation='" + jobLocation + '\'' + ", closeDate=" + closeDate + '}'; }
	 */
}

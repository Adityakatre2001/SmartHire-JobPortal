package com.smarthire.entites;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "application")
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicationId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    private JobPosting jobPosting;

    @NotNull
    @Size(max = 50)
    @Column(nullable = false, length = 50)
    private String status;

    @NotNull
    @UpdateTimestamp
    @Column(name = "application_date", nullable = false)
    private LocalDate applicationDate;

    // Constructors, getters, and setters

	/*
	 * public Application() { }
	 * 
	 * public Application(User user, JobPosting jobPosting, String status, Date
	 * applicationDate) { this.user = user; this.jobPosting = jobPosting;
	 * this.status = status; this.applicationDate = applicationDate; }
	 */

    // Getters and setters

	/*
	 * public Long getApplicationId() { return applicationId; }
	 * 
	 * public void setApplicationId(Long applicationId) { this.applicationId =
	 * applicationId; }
	 * 
	 * public User getUser() { return user; }
	 * 
	 * public void setUser(User user) { this.user = user; }
	 * 
	 * public JobPosting getJobPosting() { return jobPosting; }
	 * 
	 * public void setJobPosting(JobPosting jobPosting) { this.jobPosting =
	 * jobPosting; }
	 * 
	 * public String getStatus() { return status; }
	 * 
	 * public void setStatus(String status) { this.status = status; }
	 * 
	 * public Date getApplicationDate() { return applicationDate; }
	 * 
	 * public void setApplicationDate(Date applicationDate) { this.applicationDate =
	 * applicationDate; }
	 * 
	 * @Override public String toString() { return "Application{" + "applicationId="
	 * + applicationId + ", user=" + user + ", jobPosting=" + jobPosting +
	 * ", status='" + status + '\'' + ", applicationDate=" + applicationDate + '}';
	 * }
	 */
}

package com.smarthire.entities;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "job_posting")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "employer")
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
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "companyId", nullable = false)
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

	@OneToMany(mappedBy = "jobPosting", cascade = CascadeType.ALL)
	@MapKey(name = "applicationId")  
	private Map<Long, JobApplication> applications = new HashMap<>();
}

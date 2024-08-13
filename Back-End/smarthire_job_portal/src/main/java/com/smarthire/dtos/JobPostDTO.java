package com.smarthire.dtos;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobPostDTO {
    
    @JsonProperty(access = Access.READ_ONLY)
    private Long jobId;

    @NotNull
    private LocalDate postDate;

    @Size(max = 5000)
    private String jobDescription;

    @NotNull
    @JsonProperty(access = Access.WRITE_ONLY)
    private Long companyId; // Reference to CompanyDTO

    @NotNull
    private Double salary;

    @NotNull
    @Size(max = 100)
    private String jobTitle;

    @NotNull
    @Size(max = 255)
    private String jobLocation;

    private LocalDate closeDate;

}

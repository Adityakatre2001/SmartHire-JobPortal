package com.smarthire.dtos;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class JobApplicationDTO {
	
	@NotNull
	@JsonProperty(access = Access.READ_ONLY)
	 private Long applicationId;

	    @NotNull
	    @JsonProperty(access = Access.READ_ONLY)
	    private Long userId; // Referencing to UserDTO

	    @NotNull
	    @JsonProperty(access = Access.READ_ONLY)
	    private Long jobId; // Referencing  to JobPostingDTO

	    @NotNull
	    @Size(max = 50)
	    private String status;

	    @NotNull
	    private LocalDate applicationDate;

}

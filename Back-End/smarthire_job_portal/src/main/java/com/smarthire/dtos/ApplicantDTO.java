package com.smarthire.dtos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicantDTO {

	  	@NotNull
	  	@JsonProperty(access = Access.READ_ONLY)
	    private Long userId;

	    @NotNull
	    @Size(max = 50)
	    private String username;

	    @NotNull
	    @Size(max = 100)
	    private String email;

	    @NotNull
	    @Size(max = 20)
	    private String role; 
}

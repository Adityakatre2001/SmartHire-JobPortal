package com.smarthire.dtos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyDTO {


	@NotNull
	@JsonProperty(access = Access.READ_ONLY)
	private Long companyId;

    @NotNull
    @Size(max = 100)
    private String companyName;

    @NotNull
    @Size(max = 50)
    private String industry;

    @NotNull
    @Size(max = 255)
    private String location;

    @Size(max = 5000)
    private String description;
}

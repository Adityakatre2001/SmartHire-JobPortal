package com.smarthire.dtos;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminDTO {

	@NotNull
	@JsonProperty(access = Access.READ_ONLY)
    private Long userId;
    
    private String email;
    private String password;
    

}
package com.smarthire.dtos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProfileDTO
 {
	@JsonProperty(access = Access.READ_ONLY)
    private Long profileId;

    @NotNull
    @JsonProperty(access = Access.WRITE_ONLY)
    private Long userId; // Reference to UserDTO

    @NotNull
    @Size(max = 50)
    private String contact;

    private byte[] resume;

    private List<String> skills;

    @Size(max = 5000)
    private String summary;

    @Size(max = 5000)
    private String experience;

    
}


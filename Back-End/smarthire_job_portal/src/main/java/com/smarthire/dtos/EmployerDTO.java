package com.smarthire.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployerDTO {
	

		private Long userId;
	    private String username;
	    private String email;
	    private String companyName; // Assume this is relevant to employers
	    private String role; // e.g., "EMPLOYER"
}

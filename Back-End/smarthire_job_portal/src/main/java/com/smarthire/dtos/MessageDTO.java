package com.smarthire.dtos;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageDTO {
	

	 	@JsonProperty(access = Access.READ_ONLY)
	    private Long messageId;

	    @NotNull
	    @JsonProperty(access = Access.WRITE_ONLY)
	    private Long senderId; // Reference to UserDTO

	    @NotNull
	    @JsonProperty(access = Access.WRITE_ONLY)
	    private Long receiverId; // Reference to UserDTO

	    @NotNull
	    @Size(max = 5000)
	    private String messageContent;

	    @NotNull
	    private LocalDateTime messageTime;
}

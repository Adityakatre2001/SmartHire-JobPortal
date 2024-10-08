package com.smarthire.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smarthire.dtos.ApiResponse;
import com.smarthire.dtos.ApplicantDTO;
import com.smarthire.dtos.AuthDTO;
import com.smarthire.dtos.UserDTO;
import com.smarthire.services.ApplicationService;
import com.smarthire.services.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserService userService;
	
    @Autowired
    private ApplicationService applicationService;

    @PostMapping("/signin")
	public ResponseEntity<?> userSignIn(@RequestBody AuthDTO dto) {
		try {
			UserDTO respDto = userService.authenticateUser(dto);
			return ResponseEntity.ok(respDto);

		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}
    // Application Management
    @PostMapping("/applications")
    public ResponseEntity<ApplicantDTO> createApplication(@RequestBody ApplicantDTO applicationDTO) {
        ApplicantDTO createdApplication = applicationService.createApplication(applicationDTO);
        return ResponseEntity.ok(createdApplication);
    }

    @PutMapping("/applications/{applicationId}")
    public ResponseEntity<ApplicantDTO> updateApplication(@PathVariable Long applicationId, @RequestBody ApplicantDTO applicationDTO) {
        ApplicantDTO updatedApplication = applicationService.updateApplication(applicationId, applicationDTO);
        return ResponseEntity.ok(updatedApplication);
    }

    @DeleteMapping("/applications/{applicationId}")
    public ResponseEntity<Void> deleteApplication(@PathVariable Long applicationId) {
        applicationService.deleteApplication(applicationId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/applications/{applicationId}")
    public ResponseEntity<ApplicantDTO> getApplicationById(@PathVariable Long applicationId) {
        ApplicantDTO applicationDTO = applicationService.getApplicationById(applicationId);
        return ResponseEntity.ok(applicationDTO);
    }

    @GetMapping("/applications")
    public ResponseEntity<List<ApplicantDTO>> getAllApplications() {
        List<ApplicantDTO> applications = applicationService.getAllApplications();
        return ResponseEntity.ok(applications);
    }
}

package com.smarthire.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smarthire.dtos.UserDTO;
import com.smarthire.entities.User;
import com.smarthire.services.UserService;

@RestController
@RequestMapping("/users")
public class AdminController {
	
	@Autowired
	private UserService _userservice;
	
	@GetMapping
	public List<User> getAll(){
		return _userservice.getAll();
	}

	 @PostMapping
	 public User addUser(@RequestBody UserDTO userDTO) {
	        return _userservice.addUser(userDTO);
	 }
	
}

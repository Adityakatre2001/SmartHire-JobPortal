package com.smarthire.services;

import java.util.List;

import com.smarthire.dtos.UserDTO;
import com.smarthire.entities.User;

public interface UserService {
	
	List<User> getAll();

	User addUser(UserDTO userDTO);

}

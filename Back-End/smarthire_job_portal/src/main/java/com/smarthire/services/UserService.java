package com.smarthire.services;

import java.util.List;

import com.smarthire.dtos.UserDTO;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);
    UserDTO updateUser(Long userId, UserDTO userDTO);
    void deleteUser(Long userId);
    UserDTO getUserById(Long userId);
    List<UserDTO> getAllUsers();
}

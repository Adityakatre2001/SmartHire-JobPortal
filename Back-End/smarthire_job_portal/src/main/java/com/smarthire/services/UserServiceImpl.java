//package com.smarthire.services;

//import java.util.List;
//import java.util.stream.Collectors;
//
//import javax.transaction.Transactional;
//
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.smarthire.dtos.UserDTO;
//import com.smarthire.entities.User;
//import com.smarthire.repository.UserRepository;
//
//@Transactional
//@Service
//public class UserServiceImpl implements UserService {
//
//	@Autowired 
//	private UserRepository userrepo;
//
//	@Autowired
//	private ModelMapper mapper;
//	@Override
//	public List<User> getAll() {
//		// TODO Auto-generated method stub
//		return  userrepo.findAll().stream().collect(Collectors.toList());
//	}
//
//	@Override
//	public User addUser(UserDTO userDTO) {
//		User user = mapper.map(userDTO, User.class);
//		return userrepo.save(user);
//
//	}
//	
//	
//	
//
//}


//*******************************************

package com.smarthire.services;

import com.smarthire.dtos.UserDTO;
import com.smarthire.entities.User;
import com.smarthire.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserDTO.class);
    }

    @Override
    public UserDTO updateUser(Long userId, UserDTO userDTO) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        modelMapper.map(userDTO, user);
        User updatedUser = userRepository.save(user);
        return modelMapper.map(updatedUser, UserDTO.class);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public UserDTO getUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }
}






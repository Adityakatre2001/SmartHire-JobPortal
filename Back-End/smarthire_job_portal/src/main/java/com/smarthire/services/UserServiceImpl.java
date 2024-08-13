package com.smarthire.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smarthire.dtos.UserDTO;
import com.smarthire.entities.User;
import com.smarthire.repository.UserRepository;

@Transactional
@Service
public class UserServiceImpl implements UserService {

	@Autowired 
	private UserRepository userrepo;

	@Autowired
	private ModelMapper mapper;
	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return  userrepo.findAll().stream().collect(Collectors.toList());
	}

	@Override
	public User addUser(UserDTO userDTO) {
		User user = mapper.map(userDTO, User.class);
		return userrepo.save(user);

	}
	
	
	

}

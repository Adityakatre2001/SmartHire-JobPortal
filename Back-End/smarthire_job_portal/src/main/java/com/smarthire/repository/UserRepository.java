package com.smarthire.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smarthire.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
	Optional<User> findByEmail(String email);

	Optional<User> findByEmailAndPassword(String email, String password);
}


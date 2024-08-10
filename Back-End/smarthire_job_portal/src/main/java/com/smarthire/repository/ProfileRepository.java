package com.smarthire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smarthire.entities.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    // Custom query methods can be added here if needed
}

package com.smarthire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smarthire.entities.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    // Custom query methods can be added here if needed
}

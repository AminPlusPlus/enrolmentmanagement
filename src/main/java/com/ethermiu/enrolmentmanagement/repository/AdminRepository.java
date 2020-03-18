package com.ethermiu.enrolmentmanagement.repository;

import com.ethermiu.enrolmentmanagement.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface AdminRepository extends JpaRepository<Admin, String> {
    Optional<Admin> findByUsernameAndPassword(String username, String password);
}

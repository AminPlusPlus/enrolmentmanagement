package com.ethermiu.enrolmentmanagement.service.impl;

import com.ethermiu.enrolmentmanagement.domain.Admin;
import com.ethermiu.enrolmentmanagement.repository.AdminRepository;
import com.ethermiu.enrolmentmanagement.service.LoginService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {
    AdminRepository adminRepository;

    public boolean isValidUser(String username, String password) {
        if (username == null || password == null) return false;
        Optional<Admin> adminOptional = adminRepository.findByUsernameAndPassword(username, password);
        if (adminOptional.isEmpty()) return false;
        return true;
    }

}

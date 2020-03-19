package com.ethermiu.enrolmentmanagement;

import com.ethermiu.enrolmentmanagement.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class EnrolmentManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnrolmentManagementApplication.class, args);
    }
}

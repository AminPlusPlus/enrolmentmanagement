package com.ethermiu.enrolmentmanagement;

import com.ethermiu.enrolmentmanagement.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

@SpringBootApplication()
public class EnrolmentManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnrolmentManagementApplication.class, args);


    }

}

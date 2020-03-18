package com.ethermiu.enrolmentmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication()
@ComponentScan ({"com.ethermiu.enrolmentmanagement", "com.ethermiu.enrolmentmanagement.service"})
//@ ("com.server.repository") // this fix the problem
//@ComponentScan("com.ethermiu.enrolmentmanagement")
public class EnrolmentManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnrolmentManagementApplication.class, args);
    }
}

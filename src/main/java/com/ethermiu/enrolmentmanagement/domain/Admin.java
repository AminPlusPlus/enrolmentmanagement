package com.ethermiu.enrolmentmanagement.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Admin {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private String roles;


}

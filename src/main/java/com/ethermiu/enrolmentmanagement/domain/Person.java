package com.ethermiu.enrolmentmanagement.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor
public  class Person {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String username;
    private String password;

}

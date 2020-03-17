package com.ethermiu.enrolmentmanagement.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Student extends Person {

    private String studentId;
    private String email;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    List<Address> addresses = new ArrayList<>();

    //@ManyToMany(mappedBy = "studentList")
    //private Section section;


}

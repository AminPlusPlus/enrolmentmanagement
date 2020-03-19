package com.ethermiu.enrolmentmanagement.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    @ManyToMany(mappedBy = "studentList")
    private List<Section> sections;

    @ManyToOne
    @JoinColumn(name = "entry_id")
    private Entry entry;
}

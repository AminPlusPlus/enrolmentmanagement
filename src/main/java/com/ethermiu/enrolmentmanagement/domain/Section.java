package com.ethermiu.enrolmentmanagement.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Section {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;
    @ManyToOne
    @JoinColumn(name = "offering_id")
    private Offering offering;

    @ManyToMany
    @JoinTable(name = "Enrollment",
        joinColumns = { @JoinColumn(name = "section_id") },
        inverseJoinColumns = { @JoinColumn(name = "student_id") } )
    List<Student> studentList = new ArrayList<Student>();


}

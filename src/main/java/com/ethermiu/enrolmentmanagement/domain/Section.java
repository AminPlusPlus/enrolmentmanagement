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
@Table(name = "secton")

public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonIgnore
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
    List<Student> studentList = new ArrayList<>();


}

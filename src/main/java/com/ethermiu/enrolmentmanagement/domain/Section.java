package com.ethermiu.enrolmentmanagement.domain;

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
    @GeneratedValue
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "offering_id")
    private Offering offering;
    @ManyToMany(mappedBy = "sections",cascade = CascadeType.ALL)
    List<Student> studentList = new ArrayList<>();

    public Section(Faculty faculty, Offering offering) {
        this.faculty = faculty;
        this.offering = offering;
    }
}

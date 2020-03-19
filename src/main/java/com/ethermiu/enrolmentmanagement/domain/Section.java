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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "offering_id")
    private Offering offering;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "Enrollment",
            joinColumns = { @JoinColumn(name = "section_id") },
            inverseJoinColumns = { @JoinColumn(name = "student_id") } )
    List<Student> studentList = new ArrayList<Student>();

    public Section(Faculty f,Offering of){
        this.faculty=f;
        this.offering=of;
    }
    public  void addStudent(Student student){
        studentList.add(student);
    }

}

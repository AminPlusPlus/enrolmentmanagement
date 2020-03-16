package com.ethermiu.enrolmentmanagement.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
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


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Offering getOffering() {
        return offering;
    }

    public void setOffering(Offering offering) {
        this.offering = offering;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

}

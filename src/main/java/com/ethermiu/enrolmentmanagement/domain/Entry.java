package com.ethermiu.enrolmentmanagement.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Entry {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private Date startDate;
    private Date enrollmentStartDate;
    private Date enrollmentEndDate;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "entry_id")
    private List<Student> students = new ArrayList<>();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEnrollmentStartDate() {
        return enrollmentStartDate;
    }

    public void setEnrollmentStartDate(Date enrollmentStartDate) {
        this.enrollmentStartDate = enrollmentStartDate;
    }

    public Date getEnrollmentEndDate() {
        return enrollmentEndDate;
    }

    public void setEnrollmentEndDate(Date enrollmentEndDate) {
        this.enrollmentEndDate = enrollmentEndDate;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }


}

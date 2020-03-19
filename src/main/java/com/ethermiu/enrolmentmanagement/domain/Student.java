package com.ethermiu.enrolmentmanagement.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
//I made a change  changed in  the Student domain class i made Student the owner of the section.
@Entity
@Data
@NoArgsConstructor
public class Student extends Person {


    @Size(max = 10,message = "size must be 10 or below")
    private String studentId;
    @Email
    private String email;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    List<Address> addresses = new ArrayList<>();


    @ManyToMany(mappedBy = "studentList",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Section> sections= new ArrayList<Section>();

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "entry_id")
    private Entry entry;

    public void addSection(Section sec){
        sections.add(sec);
    }

    public String getStudentId() {
        return studentId;
    }

    public String getEmail() {
        return email;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public List<Section> getSections() {
        return sections;
    }

    public Entry getEntry() {
        return entry;
    }
}

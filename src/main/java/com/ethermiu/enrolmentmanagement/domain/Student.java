package com.ethermiu.enrolmentmanagement.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
//I made a change  changed in  the Student domain class i made Student the owner of the section.
@Entity
@Data
@NoArgsConstructor
public class Student extends Person {

    @Column(length = 16)
    @NotEmpty
    @Size(min=5, max = 9, message= "size must be between 5 and 9")
    private String studentId;
    @Email
    private String email;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    List<Address> addresses = new ArrayList<>();


    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "Enrollment",
            joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "section_id")})
    private List<Section> sections;

    @ManyToOne
    @JoinColumn(name = "entry_id")
    private Entry entry;

    public void addSection(Section sec){
        sections.add(sec);
    }
}

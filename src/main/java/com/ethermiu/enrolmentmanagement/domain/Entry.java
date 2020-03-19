package com.ethermiu.enrolmentmanagement.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Entry {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private Date startDate;
    private Date enrollmentStartDate;
    private Date enrollmentEndDate;

//    @OneToMany(mappedBy = "entry")
//    private List<Student> students = new ArrayList<>();


}

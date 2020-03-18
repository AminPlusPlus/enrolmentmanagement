package com.ethermiu.enrolmentmanagement.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Entry {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private LocalDate startDate;
    private LocalDate enrollmentStartDate;
    private LocalDate enrollmentEndDate;
    @OneToMany(mappedBy = "entry")
    private List<Student> students = new ArrayList<>();


}

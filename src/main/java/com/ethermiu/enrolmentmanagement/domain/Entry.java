package com.ethermiu.enrolmentmanagement.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    @OneToMany(mappedBy = "entry",cascade = CascadeType.PERSIST)
    private List<Student> students = new ArrayList<>();


}

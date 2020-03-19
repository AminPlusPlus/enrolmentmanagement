package com.ethermiu.enrolmentmanagement.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;


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

}

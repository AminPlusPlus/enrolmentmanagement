package com.ethermiu.enrolmentmanagement.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Block {
    @Id
    @GeneratedValue
    private Long id;
    private String code;
    private String name;
    private String semester;
    private int blockSequenceNumber;
    private LocalDate startDate;
    private LocalDate endDate;

//    @OneToMany(mappedBy = "block")
//    List<Offering> offeringList;
    }



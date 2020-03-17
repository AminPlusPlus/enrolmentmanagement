package com.ethermiu.enrolmentmanagement.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Block {
    @Id
    @GeneratedValue
    private int id;
    private String code;
    private String name;
    private String semester;
    private int blockSequenceNumber;
    private Date startDate;
    private Date endDate;

    @OneToMany(mappedBy = "block")
    List<Offering> offeringList;
    }
}


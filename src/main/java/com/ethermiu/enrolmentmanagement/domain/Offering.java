package com.ethermiu.enrolmentmanagement.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Offering {
    @Id
    @GeneratedValue
    private int id;
    private String code;
    //@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "block_id")
    private Block block;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

//    @OneToMany(mappedBy = "offering")
//    List<Section> sectionList = new ArrayList<>();

}

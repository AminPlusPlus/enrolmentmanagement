package com.ethermiu.enrolmentmanagement.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Offering {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    @ManyToOne
    @JoinColumn(name = "block_id")
    private Block block;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    @JsonIgnore
    @OneToMany(mappedBy = "offering",cascade = CascadeType.ALL)
    Set<Section> sectionList = new HashSet<>();


    public Offering() {
    }

    public Offering(String code, Block block, Course course, Set<Section> section) {
        this.code = code;
        this.block = block;
        this.course = course;
        this.sectionList =  section;
    }
}

package com.ethermiu.enrolmentmanagement.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Faculty extends Person {

    private String title;
    @JsonIgnore
    @OneToMany(mappedBy = "faculty")
    private List<Section> sections = new ArrayList<>();

   }

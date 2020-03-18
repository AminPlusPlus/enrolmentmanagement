package com.ethermiu.enrolmentmanagement.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Faculty extends Person {

    private String title;
    @OneToMany(mappedBy = "faculty",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Section> sections = new ArrayList<>();

   }

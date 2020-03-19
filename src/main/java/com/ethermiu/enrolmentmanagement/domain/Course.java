package com.ethermiu.enrolmentmanagement.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@Getter
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue
    private Long id;
    private String code;
    private String name;
    private String description;

    public Long getId() {
        return id;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
    private List<Offering> offeringList;

}




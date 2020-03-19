package com.ethermiu.enrolmentmanagement.domain;

import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
public class Sect {
    Long facultyid;
    Long offeringid;

    public Long getFacultyid() {
        return facultyid;
    }

    public Long getOfferingid() {
        return offeringid;
    }
}

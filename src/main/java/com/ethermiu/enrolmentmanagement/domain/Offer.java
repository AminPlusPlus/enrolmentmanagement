package com.ethermiu.enrolmentmanagement.domain;


import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
public class Offer {
    private String code;
    private Long  blockId;
    private Long courseId;

    public String getCode() {
        return code;
    }

    public Long getBlockId() {
        return blockId;
    }

    public Long getCourseId() {
        return courseId;
    }

}

package com.ethermiu.enrolmentmanagement.service;

import com.ethermiu.enrolmentmanagement.domain.Course;
import com.ethermiu.enrolmentmanagement.domain.Section;

import java.util.List;

public interface SectionService {
    List<Section> getAllSection();
    Section findById(Long id);
    Section save(Section section);
    Section update(Section section);
    void deleteById(Long id);
    Boolean existById(Long id);

}

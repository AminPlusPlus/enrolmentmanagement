package com.ethermiu.enrolmentmanagement.service;

import com.ethermiu.enrolmentmanagement.domain.Course;
import com.ethermiu.enrolmentmanagement.domain.Faculty;
import com.ethermiu.enrolmentmanagement.domain.Offering;
import com.ethermiu.enrolmentmanagement.domain.Section;

import java.util.List;
import java.util.Map;

public interface SectionService {
    List<Section> getAllSection();
    Section findById(Long id);
    Section createSection(Faculty f, Offering offering);
    Section update(Section section);
    void deleteById(Long id);
    Boolean existById(Long id);

}

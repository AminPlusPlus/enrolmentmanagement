package com.ethermiu.enrolmentmanagement.service;

import com.ethermiu.enrolmentmanagement.domain.Course;
import com.ethermiu.enrolmentmanagement.domain.Section;

import java.util.List;
import java.util.Map;

public interface SectionService {
    List<Section> getAllSection();
    Section findById(Long id);
    boolean createSection(Map<String, Long> sectiondata);
    Section update(Section section);
    void deleteById(Long id);
    Boolean existById(Long id);

}

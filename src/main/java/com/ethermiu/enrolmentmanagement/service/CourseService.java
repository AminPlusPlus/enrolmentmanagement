package com.ethermiu.enrolmentmanagement.service;

import com.ethermiu.enrolmentmanagement.domain.Course;

import java.util.List;

public interface CourseService {
    List<Course> findAll();
    Course findById(Long id);
    Course save(Course course);
    Course update(Course course);
    void deleteById(Long id);
    Boolean existById(Long id);


}

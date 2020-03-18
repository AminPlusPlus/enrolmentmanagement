package com.ethermiu.enrolmentmanagement.service;

import com.ethermiu.enrolmentmanagement.domain.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    List<Course> findAll();
    Course findById(Long id);
    Course save(Course course);
    void remove(Course course);
    Course update(Course course);
    void deleteById(Long id);
    Boolean existById(Long id);


}

package com.ethermiu.enrolmentmanagement.service;

import com.ethermiu.enrolmentmanagement.domain.Course;

import java.util.List;

public interface CourseService {
    List<Course> findAll();
    Course save(Course course);
}

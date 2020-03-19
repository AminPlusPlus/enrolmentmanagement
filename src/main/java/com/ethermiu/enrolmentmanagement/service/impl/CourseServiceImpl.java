package com.ethermiu.enrolmentmanagement.service.impl;

import com.ethermiu.enrolmentmanagement.domain.Course;
import com.ethermiu.enrolmentmanagement.repository.CourseRepository;
import com.ethermiu.enrolmentmanagement.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll() ;
    }

    @Override
    public Course findById(Long id) {
        return courseRepository.findById(id).get();
    }

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course update(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void deleteById(Long id)  {
        courseRepository.deleteById(id);
    }

    @Override
    public Boolean existById(Long id) {
        return courseRepository.existsById(id);
    }
}

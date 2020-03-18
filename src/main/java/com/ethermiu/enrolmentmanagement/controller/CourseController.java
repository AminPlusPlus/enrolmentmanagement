package com.ethermiu.enrolmentmanagement.controller;

import com.ethermiu.enrolmentmanagement.domain.Course;
import com.ethermiu.enrolmentmanagement.service.CourseService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @ApiOperation(value = "Get all courses")
    @GetMapping
    public List<Course> findAll() {
        return courseService.findAll();
    }

    @ApiOperation(value = "Add Course")
    @PostMapping(value = "/addCourse",consumes = "application/json", produces = "application/json")
    public Course saveCourse(@RequestBody Course course) {
        return courseService.save(course);
    }


}

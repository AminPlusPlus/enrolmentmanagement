package com.ethermiu.enrolmentmanagement.controller;

import com.ethermiu.enrolmentmanagement.domain.Course;
import com.ethermiu.enrolmentmanagement.service.CourseService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


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

    @ApiOperation(value = "Get course by id")
    @GetMapping(value = "/{id}")
    public Course findAll(@PathVariable Long id) { ;


        return courseService.findById(id);
    }


    @ApiOperation(value = "Add Course")
    @PostMapping(consumes = "application/json", produces = "application/json")
    public Course saveCourse(@RequestBody Course course) {
        return courseService.save(course);
    }

    @ApiOperation(value = "Update Course")
    @PutMapping(consumes = "application/json", produces = "application/json")
    public Course update(@RequestBody Course course) {
        return courseService.update(course);
    }
    @ApiOperation(value = "Delete Course")
    @DeleteMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Map<String,String>>  deleteCourse (@RequestBody Course course){

        Long courseId = course.getId();
        if(courseService.existById(courseId))
            courseService.deleteById(courseId);
        Map<String,String> message = new HashMap<>();
        message.put("message","User doesn't exist");
        return new ResponseEntity(message,HttpStatus.BAD_REQUEST);
    }

    @ApiOperation(value = "Delete Course By Id")
    @DeleteMapping(value = "{id}")
    public ResponseEntity<Map<String,String>> deleteById(@PathVariable Long id) {
        if(courseService.existById(id))
           courseService.deleteById(id);

        Map<String,String> message = new HashMap<>();
        message.put("message","User doesn't exist");

     return new ResponseEntity(message,HttpStatus.BAD_REQUEST);
    }


}

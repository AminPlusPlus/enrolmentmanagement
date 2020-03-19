package com.ethermiu.enrolmentmanagement.controller;

import com.ethermiu.enrolmentmanagement.domain.*;
import com.ethermiu.enrolmentmanagement.exception.NoSuchResourceException;
import com.ethermiu.enrolmentmanagement.repository.FacultyRepository;
import com.ethermiu.enrolmentmanagement.repository.OfferingRepository;
import com.ethermiu.enrolmentmanagement.service.StudentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {
    @Autowired
    StudentService service;
    @Autowired
    OfferingRepository repository;
    @Autowired
    FacultyRepository facultyRepository;


    @ApiOperation(value = "Create a student", notes =
            "provide a student data without id")
    @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
    public Student createStudent(@Valid @RequestBody Student student) {
        return service.create(student);
    }

    @ApiOperation(value = "Update Student")
    @PutMapping(consumes = "application/json", produces = "application/json")
    public Student update(@RequestBody Student student) {
        return service.update(student);
    }
    @ApiOperation(value = "Get Feature Courses of a student", notes =
            "provide student id", response = ArrayList.class)
    @GetMapping("/{id}/featureCourses")
    public List<Course> getFeatureCourses(@PathVariable("id") Long id) {
        return service.getFeatureCourses(id);
    }

    @ApiOperation(value = "get all students", notes = "" +
            "", response = ResponseEntity.class)
    @GetMapping
    public List<Student> getAll() {
        return service.getAllStudent();
    }

    @ApiOperation(value = "get a student by Id", notes = "" +
            "provide an Id to look up the Data", response = ResponseEntity.class)
    @GetMapping("/{id}")
    public Student getBiId(@PathVariable("id") Long id) {
        try {
            return service.getStudentById(id).get();
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad Request");
        }
    }

    @ApiOperation(value = "Delete Student by Id", notes = "" +
            "provide an Id to Delete A student", response = ResponseEntity.class)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        try {
            service.delete(service.getStudentById(id).get());
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad Request");
        }
        return new ResponseEntity<>("Student deleted", HttpStatus.OK);
    }

    @ApiOperation(value = "Add Enrolment", notes = "" +
            "provide an Id and section Id to add enrolment", response = ResponseEntity.class)
    @GetMapping("/{id}/addEnrollment/{sectionId}")
    public ResponseEntity<String> addEnrollment(@PathVariable("id") Long id, @PathVariable("sectionId") Long sectionId) {
        try {
            service.addEnrolment(id, sectionId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad Request");
        }
        return new ResponseEntity<>("Enrolment added Successfully", HttpStatus.OK);
    }

    @ExceptionHandler(value = NoSuchResourceException.class)
    public Exception handle(Exception e) {
        return e;
    }


}


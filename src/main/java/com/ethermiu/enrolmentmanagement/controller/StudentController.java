package com.ethermiu.enrolmentmanagement.controller;

import com.ethermiu.enrolmentmanagement.domain.Faculty;
import com.ethermiu.enrolmentmanagement.domain.Offering;
import com.ethermiu.enrolmentmanagement.domain.Section;
import com.ethermiu.enrolmentmanagement.domain.Student;
import com.ethermiu.enrolmentmanagement.exception.NoSuchResourceException;
import com.ethermiu.enrolmentmanagement.repository.FacultyRepository;
import com.ethermiu.enrolmentmanagement.repository.OfferingRepository;
import com.ethermiu.enrolmentmanagement.repository.Sectionrepositry;
import com.ethermiu.enrolmentmanagement.service.StudentService;
import com.ethermiu.enrolmentmanagement.service.impl.StudentServiceImpl;
import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import javax.websocket.server.PathParam;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1/students")
public class StudentController {
    @Autowired
    StudentService service;
    @Autowired
    OfferingRepository repository;
    @Autowired
    FacultyRepository facultyRepository;


    @PostMapping("student")
    public ResponseEntity<String> createStudent(@RequestBody Student student) {
        try {
            service.create(student);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Bad Request");
        }
         return new ResponseEntity<>("Student Successfully created", HttpStatus.OK);

    }

    @PutMapping("/{id}/update")
    public ResponseEntity<String> updateStudent(@PathParam("id") Long id, @RequestBody Student student) {
        try {

            service.update(id, student);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Bad Request");
        }
        return new ResponseEntity<>("Student input updated Successfully", HttpStatus.OK);

    }

    @GetMapping("/getAll")
    public List<Student> getAll() {
        return service.getAllStudent();
    }

    @GetMapping("/{id}")
    public Student getBiId(@PathVariable("id") Long id) {
        try {
            return service.getStudentById(id);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Bad Request");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        try {
            service.delete(service.getStudentById(id));
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Bad Request");
        }
        return new ResponseEntity<>("Student deleted updated", HttpStatus.OK);
    }

    @PostMapping("/{id}/addEnrollment/{sectionId}")
    public ResponseEntity<String> addEnrollment(@PathVariable("id") Long id, @PathVariable("sectionId") Long sectionId) {

        try {
            service.addEnrolment(id, sectionId);
        } catch (Exception ex) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Bad Request", ex);
        }

        return new ResponseEntity<>("Enrolment added Successfully", HttpStatus.OK);
    }

    @ExceptionHandler(value = NoSuchResourceException.class)
    public Exception handle(Exception e) {
        return e;
    }
}


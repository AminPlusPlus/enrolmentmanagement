package com.ethermiu.enrolmentmanagement.controller;

import com.ethermiu.enrolmentmanagement.domain.Student;
import com.ethermiu.enrolmentmanagement.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("v1/faculty")
public class FacultyController {
    @Autowired
    FacultyService service;

    @GetMapping("/students")
    public List<Student> getStudents(){
        return service.getAllStudent();
    }

    @GetMapping("students/{id}")
    public Student getStudentById(@PathVariable("id") Long id){
        return service.getStudentById(id);
    }

}

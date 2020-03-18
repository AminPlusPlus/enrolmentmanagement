package com.ethermiu.enrolmentmanagement.controller;

import com.ethermiu.enrolmentmanagement.domain.Student;
import com.ethermiu.enrolmentmanagement.service.FacultyService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("v1/faculty")
public class FacultyController {
    @Autowired
    FacultyService service;
    @ApiOperation(value = "Get Students")
    @GetMapping("/students")
    public List<Student> getStudents(){
        return service.getAllStudent();
    }

    @ApiOperation(value = "Get Student By Id")
    @GetMapping("students/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") Long id){
        if (service.studentExist(id)) {
            Student student = service.getStudentById(id);
            return new ResponseEntity<Student>(student, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<String>("User doesn't exist", HttpStatus.BAD_REQUEST);
        }
    }

}

package com.ethermiu.enrolmentmanagement.controller;

import com.ethermiu.enrolmentmanagement.domain.Faculty;
import com.ethermiu.enrolmentmanagement.domain.Student;
import com.ethermiu.enrolmentmanagement.service.FacultyService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/faculties")
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
    public ResponseEntity<?> getStudentById(@PathVariable Long id){
        if (service.studentExist(id)) {
            Student student = service.getStudentById(id);
            return new ResponseEntity<>(student, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("User doesn't exist", HttpStatus.BAD_REQUEST);
        }
    }
    @ApiOperation(value = "Create a faculty", notes =
            "provide a faculty data without id")
    @PostMapping(consumes = "application/json", produces = "application/json")
    public Faculty createFaculty(@Valid @RequestBody Faculty faculty) {
        return service.create(faculty);
    }

    @ApiOperation(value = "Update Faculty")
    @PutMapping(consumes = "application/json", produces = "application/json")
    public Faculty update(@RequestBody Faculty faculty) {
        return service.update(faculty);
    }

    @ApiOperation(value = "get all faculties", notes = "" +
            "", response = ResponseEntity.class)
    @GetMapping
    public List<Faculty> getAll() {
        return service.getAllFaculty();
    }

    @ApiOperation(value = "get a faculty by Id", notes = "" +
            "provide an Id to look up the Data", response = ResponseEntity.class)
    @GetMapping("/faculties/{id}")
    public Faculty getBiId(@PathVariable Long id) {
        try {
            return service.getFacultyById(id).get();
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad Request");
        }
    }

    @ApiOperation(value = "Delete Faculty by Id", notes = "" +
            "provide an Id to Delete A Faculty", response = ResponseEntity.class)
    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            service.delete(service.getFacultyById(id).get());
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad Request");
        }
        return new ResponseEntity<>("Faculty deleted", HttpStatus.OK);
    }

}

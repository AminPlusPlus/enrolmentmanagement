package com.ethermiu.enrolmentmanagement.controller;

import com.ethermiu.enrolmentmanagement.domain.Student;
import com.ethermiu.enrolmentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {
    @Autowired
    StudentService service;

    @PostMapping("/save")
    public void createStudent(@RequestBody Student student){
        System.out.println(student.toString());
        service.create(student);
    }
    @PutMapping("/{id}/update")
    public void updateStudent(@PathParam("id") Long id,  @RequestBody Student student){
        service.update(id,student);
    }
    @GetMapping("/getAll")
    public List<Student> getAll(){
        return service.getAllStudent();
    }

    @GetMapping("/{id}")
    public Student getBiId(@PathVariable("id") Long id){
        return service.getStudentById(id);
    }

    @GetMapping("/{id}/delete")
    public void delete(@PathVariable("id") Long id){
        service.delete(service.getStudentById(id));
    }

}

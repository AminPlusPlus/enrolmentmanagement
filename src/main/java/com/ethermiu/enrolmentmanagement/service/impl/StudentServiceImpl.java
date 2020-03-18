package com.ethermiu.enrolmentmanagement.service.impl;

import com.ethermiu.enrolmentmanagement.domain.Student;
import com.ethermiu.enrolmentmanagement.repository.StudentRepository;
import com.ethermiu.enrolmentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public void create(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public void update(Long id,Student student) {
       Student student1 = studentRepository.getOne(id);
       if (student1==null){
           throw  new IllegalArgumentException("Not Able to Find student With this id");
       }
       else {
           student1=student;
           studentRepository.save(student1);
       }
    }

    @Override
    public void delete(Student student) {
        studentRepository.delete(student);
    }
    public void deleteAll() {
        studentRepository.deleteAll();
    }
}

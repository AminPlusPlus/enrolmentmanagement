package com.ethermiu.enrolmentmanagement.service.impl;

import com.ethermiu.enrolmentmanagement.domain.Faculty;
import com.ethermiu.enrolmentmanagement.domain.Student;
import com.ethermiu.enrolmentmanagement.repository.Facultyrepo;
import com.ethermiu.enrolmentmanagement.repository.StudentRepository;
import com.ethermiu.enrolmentmanagement.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyServiceImpl implements FacultyService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    Facultyrepo facultyrepo;

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).get();
    }
    public boolean studentExist(Long id) {
        return studentRepository.existsById(id);
    }

    @Override
    public Faculty getFacultyById(Long id) {
         return facultyrepo.findById(id).get();
    }

    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }
}

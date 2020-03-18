package com.ethermiu.enrolmentmanagement.service;

import com.ethermiu.enrolmentmanagement.domain.Student;

import java.util.List;

public interface FacultyService {
    public Student getStudentById(Long id);
    public List<Student> getAllStudent();
    public boolean studentExist(Long id);
}

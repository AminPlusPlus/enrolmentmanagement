package com.ethermiu.enrolmentmanagement.service;

import com.ethermiu.enrolmentmanagement.domain.Student;

import java.util.List;

public interface FacultyService {
     Student getStudentById(Long id);
     List<Student> getAllStudent();
     boolean studentExist(Long id);
}

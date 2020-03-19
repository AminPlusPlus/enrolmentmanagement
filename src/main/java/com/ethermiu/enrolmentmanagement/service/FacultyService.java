package com.ethermiu.enrolmentmanagement.service;

import com.ethermiu.enrolmentmanagement.domain.Faculty;
import com.ethermiu.enrolmentmanagement.domain.Student;

import java.util.List;
import java.util.Optional;

public interface FacultyService {
     public Student getStudentById(Long id);

     public List<Student> getAllStudent();

     public boolean studentExist(Long id);

     public Faculty create(Faculty faculty);
     public Optional<Faculty> getFacultyById(Long id);
     public List<Faculty> getAllFaculty();
     public Faculty update(Faculty faculty);
     public void delete(Faculty faculty);
}
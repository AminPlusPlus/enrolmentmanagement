package com.ethermiu.enrolmentmanagement.service;

import com.ethermiu.enrolmentmanagement.domain.Student;

import java.util.List;

public interface StudentService {
    public void create(Student student);
    public Student getStudentById(Long id);
    public List<Student> getAllStudent();
    void update(Long id, Student student);
    void delete(Student student);
}

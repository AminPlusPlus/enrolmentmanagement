package com.ethermiu.enrolmentmanagement.service;

import com.ethermiu.enrolmentmanagement.domain.Course;
import com.ethermiu.enrolmentmanagement.domain.Offering;
import com.ethermiu.enrolmentmanagement.domain.Section;
import com.ethermiu.enrolmentmanagement.domain.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Student create(Student student);
    Optional<Student> getStudentById(Long id);
    List<Student> getAllStudent();
    Student update( Student student);
    void delete(Student student);
    List<Offering> getStuOffering(Long id);
    void updateEnrolment(Long id, Section section);
    void addEnrolment(Long id ,Long sectionId);
    List<Course> getFeatureCourses(Long id);

    }

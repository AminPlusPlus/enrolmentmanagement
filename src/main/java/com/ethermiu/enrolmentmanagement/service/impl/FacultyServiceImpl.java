package com.ethermiu.enrolmentmanagement.service.impl;

import com.ethermiu.enrolmentmanagement.domain.Faculty;
import com.ethermiu.enrolmentmanagement.domain.Student;

import com.ethermiu.enrolmentmanagement.repository.FacultyRepository;
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
    FacultyRepository facultyRepository;
    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).get();
    }
    @Override
    public boolean studentExist(Long id) {
        return studentRepository.existsById(id);
    }

    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }
    @Override
    public Faculty create(Faculty faculty) {
        return facultyRepository.save(faculty);
    }
    @Override
    public Optional<Faculty> getFacultyById(Long id) {
        return facultyRepository.findById(id);
    }

    @Override
    public List<Faculty> getAllFaculty() {
        return facultyRepository.findAll();
    }

    @Override
    public Faculty update(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    @Override
    public void delete(Faculty faculty) {
        facultyRepository.delete(faculty);
    }




}

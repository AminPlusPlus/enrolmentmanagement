package com.ethermiu.enrolmentmanagement.service.impl;

import com.ethermiu.enrolmentmanagement.domain.Offering;
import com.ethermiu.enrolmentmanagement.domain.Section;
import com.ethermiu.enrolmentmanagement.domain.Student;
import com.ethermiu.enrolmentmanagement.repository.OfferingRepository;
import com.ethermiu.enrolmentmanagement.repository.StudentRepository;
import com.ethermiu.enrolmentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    OfferingRepository offeringRepository;

    @Override
    public void create(Student student) {
        studentRepository.save(student);
    }

    public void addEnrolment(Long id, Section section) {
        Student student = studentRepository.getOne(id);

        for (Section sec : student.getSections()) {
            if (compareBlockDate(sec, section) == -1) {
                throw new IllegalStateException("Block already Enrolled!");
            }
            if (sec.getOffering().getBlock().getCode().equals(section.getOffering().getBlock().getCode()))
                throw new IllegalStateException("Course already Enrolled!");
        }

        if (section.getOffering().getBlock().getStartDate().compareTo(LocalDate.now()) < 0) {
            throw new IllegalStateException("You cannot Enroll past Block!");
        }

        if (student.getSections().size() > 4) {
            student.addSection(section);
            studentRepository.flush();
        } else throw new IllegalStateException("You cannot Enroll more than 4 times!");
    }

    public int compareBlockDate(Section sec, Section section) {
        if (sec.getOffering().getBlock().getEndDate().compareTo(section.getOffering().getBlock().getStartDate()) < 0) {
            return 1;
        } else if (sec.getOffering().getBlock().getEndDate().compareTo(section.getOffering().getBlock().getStartDate()) > 0) {
            if (sec.getOffering().getCourse().getCode().equals(section.getOffering().getCourse().getCode()))
                return -1;
        }
        return -1;
    }

    @Override
    public List<Offering> getStuOffering(Long id){
        return offeringRepository.findStudentOffering(id);
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
    public void update(Long id, Student student) {
        Student student1 = studentRepository.getOne(id);
        if (student1 == null) {
            throw new IllegalArgumentException("Not Able to Find student With this id");
        } else {
            student1 = student;
            studentRepository.save(student1);
        }
    }

    @Override
    public void updateEnrolment(Long id, Section section){

    }
    @Override
    public void delete(Student student) {
        studentRepository.delete(student);
    }

}

package com.ethermiu.enrolmentmanagement.service.impl;

import com.ethermiu.enrolmentmanagement.domain.Offering;
import com.ethermiu.enrolmentmanagement.domain.Section;
import com.ethermiu.enrolmentmanagement.domain.Student;
import com.ethermiu.enrolmentmanagement.repository.OfferingRepository;
import com.ethermiu.enrolmentmanagement.repository.Sectionrepositry;
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
    @Autowired
    Sectionrepositry sectionrepositry;

    @Override
    public void create(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void addEnrolment(Long id, Long sectionId) {
        Student student = studentRepository.getOne(id);
        Section newSection = sectionrepositry.getOne(sectionId);

        if (validateInput(student, newSection)) {
            student.addSection(newSection);
            studentRepository.flush();
        }
    }

    private boolean validateInput(Student student, Section newSection) {

        if (student.getSections().size() >= 4) {
            return false;
        }
        if(student.getEntry().getEnrollmentStartDate().compareTo(LocalDate.now())<0||
                LocalDate.now().compareTzo(student.getEntry().getEnrollmentEndDate())>0)
            return false;

        for (Section sec : student.getSections()) {

            if (sec.getOffering().getBlock().getId() == newSection.getOffering().getBlock().getId())
                return false;

            if (sec.getOffering().getCourse().getCode().equals(newSection.getOffering().getCourse().getCode()))
                return false;
        }

        if (newSection.getOffering().getBlock().getStartDate().compareTo(LocalDate.now()) < 0) {
            return false;
        }

        return true;
    }

    @Override
    public List<Offering> getStuOffering(Long id) {
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
    public void updateEnrolment(Long id, Section section) {

    }

    @Override
    public void delete(Student student) {
        studentRepository.delete(student);
    }


}

//        if (newSection.getOffering().getBlock().getStartDate().compareTo(student.getEntry().getEnrollmentStartDate()) < 0
//                || newSection.getOffering().getBlock().getEndDate().compareTo(student.getEntry().getEnrollmentEndDate()) > 0) {
//            return false;
//        }
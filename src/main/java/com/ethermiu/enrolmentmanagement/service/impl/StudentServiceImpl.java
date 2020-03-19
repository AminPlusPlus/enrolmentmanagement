package com.ethermiu.enrolmentmanagement.service.impl;

import com.ethermiu.enrolmentmanagement.domain.Course;
import com.ethermiu.enrolmentmanagement.domain.Offering;
import com.ethermiu.enrolmentmanagement.domain.Section;
import com.ethermiu.enrolmentmanagement.domain.Student;
import com.ethermiu.enrolmentmanagement.repository.OfferingRepository;
import com.ethermiu.enrolmentmanagement.repository.Sectionrepositry;
import com.ethermiu.enrolmentmanagement.repository.StudentRepository;
import com.ethermiu.enrolmentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

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
        System.out.println("am here");
        Student student = studentRepository.getOne(id);
        Section newSection = sectionrepositry.getOne(sectionId);
        int i = validateInput(student, newSection);

        if (i == 0) {
            newSection.addStudent(student);
            student.addSection(newSection);
            studentRepository.save(student);
        } else throwException(i);
    }


    @Override
    public List<Offering> getStuOffering(Long id) {
        return offeringRepository.findStudentOffering(id);
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public void update(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void updateEnrolment(Long id, Section section) {

    }

    @Override
    public List<Course> getFeatureCourses(Long id) {
        Student student = studentRepository.findById(id).get();
        List<Course> featureCourses = new ArrayList<>();
        List<Section> sections = sectionrepositry.findSectionByStudentList(id);

        for (Section section : sections) {
            if (LocalDate.now().compareTo(section.getOffering().getBlock().getStartDate()) < 0) {
                featureCourses.add(section.getOffering().getCourse());
            }

        }
        return featureCourses;
    }


    @Override
    public void delete(Student student) {
        studentRepository.delete(student);
    }

    private int validateInput(Student student, Section newSection) {

        if (student.getSections().size() >= 4) {
            return 1;
        }
        if (student.getEntry().getEnrollmentStartDate().compareTo(LocalDate.now()) > 0 ||
                student.getEntry().getEnrollmentEndDate().compareTo(LocalDate.now()) < 0)
            return 2;

        for (Section sec : student.getSections()) {

            if (sec.getOffering().getBlock().getId() == newSection.getOffering().getBlock().getId())
                return 3;

            if (sec.getOffering().getCourse().getCode().equals(newSection.getOffering().getCourse().getCode()))
                return 4;
        }

        if (newSection.getOffering().getBlock().getStartDate().compareTo(LocalDate.now()) < 0) {
            return 5;
        }

        return 0;
    }


    public void throwException(int code) {
        switch (code) {
            case 1:
                throw new IllegalStateException("Maximum Enrolment Reached");
            case 2:
                throw new IllegalStateException("At this time section Enrolment is not possible");
            case 3:
                throw new IllegalStateException("Block is already reserved");
            case 4:
                throw new IllegalStateException("Course is reserved");
            case 5:
                throw new IllegalStateException("Block passed");
        }
    }
}

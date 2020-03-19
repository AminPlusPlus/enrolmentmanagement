package com.ethermiu.enrolmentmanagement.repository;

import com.ethermiu.enrolmentmanagement.domain.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Sectionrepositry extends JpaRepository <Section,Long> {
    @Query("select s from Section s join s.studentList stu where stu.id=:id")
    public List<Section> findSectionByStudentList(Long id);
}

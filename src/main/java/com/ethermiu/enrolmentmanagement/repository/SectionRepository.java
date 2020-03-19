package com.ethermiu.enrolmentmanagement.repository;

import com.ethermiu.enrolmentmanagement.domain.Course;
import com.ethermiu.enrolmentmanagement.domain.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepository extends JpaRepository<Section,Long> {
}

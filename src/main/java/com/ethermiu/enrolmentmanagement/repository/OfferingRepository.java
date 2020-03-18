package com.ethermiu.enrolmentmanagement.repository;

import com.ethermiu.enrolmentmanagement.domain.Offering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferingRepository extends JpaRepository<Offering,Long> {
    @Query(value = "from Offering o inner join o.sectionList sec where sec.studentList=:id")
    List<Offering> findStudentOffering(Long id);
}

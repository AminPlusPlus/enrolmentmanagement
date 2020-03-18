package com.ethermiu.enrolmentmanagement.repository;


import com.ethermiu.enrolmentmanagement.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}

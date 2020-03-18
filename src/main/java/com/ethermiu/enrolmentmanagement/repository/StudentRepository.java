package com.ethermiu.enrolmentmanagement.repository;


import com.ethermiu.enrolmentmanagement.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findStudentByLastName(String lastName);
    @Query("select distinct s from Student s inner join s.entry e where e.id=:id")
    Student findStudentByUsername(@Param(value="username") Long id);
}

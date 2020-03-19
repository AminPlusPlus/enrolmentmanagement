package com.ethermiu.enrolmentmanagement.repository;

import com.ethermiu.enrolmentmanagement.domain.Faculty;
import org.hibernate.dialect.LobMergeStrategy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Facultyrepo extends JpaRepository<Faculty, Long> {

}
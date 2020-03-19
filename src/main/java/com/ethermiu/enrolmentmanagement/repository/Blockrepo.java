package com.ethermiu.enrolmentmanagement.repository;

import com.ethermiu.enrolmentmanagement.domain.Block;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface Blockrepo extends JpaRepository<Block, Long> {
    @Modifying
    @Query("delete from Block b where b.code=:code")
    public void deleteByCode(@Param("code") String code);
}

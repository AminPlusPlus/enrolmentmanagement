package com.ethermiu.enrolmentmanagement.repository;

import com.ethermiu.enrolmentmanagement.domain.Block;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public abstract class Blockrepo implements CrudRepository<Block, Integer> {

}

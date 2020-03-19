package com.ethermiu.enrolmentmanagement.service;

import com.ethermiu.enrolmentmanagement.domain.Block;

import java.util.List;


public interface Blockservice {

     Block insertData(Block input);
     List<Block> getallBlocks();
     void deleteById(Long id);
     void deleteByCode(String code);
     Block update(Block block);
     boolean isExistById(Long id);
     Block findById(Long id);
}

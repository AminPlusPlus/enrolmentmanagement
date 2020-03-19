package com.ethermiu.enrolmentmanagement.service;

import com.ethermiu.enrolmentmanagement.domain.Block;

import java.util.List;


public interface Blockservice {

    public Block insertData(Block input);
    public List<Block> getallBlocks();
    public boolean deleteById(Long id);
    public void deleteByCode(String code);

    public Block update(Block block);
}

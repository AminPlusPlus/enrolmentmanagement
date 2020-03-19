package com.ethermiu.enrolmentmanagement.service.impl;

import com.ethermiu.enrolmentmanagement.domain.Block;
import com.ethermiu.enrolmentmanagement.repository.Blockrepo;
import com.ethermiu.enrolmentmanagement.service.Blockservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlockServiceImpl implements Blockservice {
    @Autowired
    Blockrepo blockrepo;
    @Override
    public Block insertData(Block input) {
        return blockrepo.save(input);
    }

    @Override
    public List<Block> getallBlocks() {
        return blockrepo.findAll();
    }

    @Override
    public void deleteById(Long id) {
           blockrepo.deleteById(id);
    }

    @Override
    public void deleteByCode(String code) {
        blockrepo.deleteByCode(code);
    }

    @Override
    public Block update(Block block) {
       return blockrepo.save(block);
    }

    @Override
    public boolean isexistByid(Long id) {
        return blockrepo.existsById(id);
    }


}

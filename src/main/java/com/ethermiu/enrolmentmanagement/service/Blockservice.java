package com.ethermiu.enrolmentmanagement.service;

import com.ethermiu.enrolmentmanagement.domain.Block;
import com.ethermiu.enrolmentmanagement.repository.Blockrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Blockservice {
    @Autowired
    private Blockrepo blockrepo;

    public Block insertData(Block input) {
        return blockrepo.save(input);
    }
}

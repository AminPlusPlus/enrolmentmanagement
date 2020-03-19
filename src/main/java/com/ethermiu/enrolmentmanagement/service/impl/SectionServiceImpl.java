package com.ethermiu.enrolmentmanagement.service.impl;

import com.ethermiu.enrolmentmanagement.domain.Section;
import com.ethermiu.enrolmentmanagement.repository.SectionRepository;
import com.ethermiu.enrolmentmanagement.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SectionServiceImpl implements SectionService {
    @Autowired
    private SectionRepository sectionRepository;
    @Override
    public List<Section> getAllSection() {
        return sectionRepository.findAll();
    }

    @Override
    public Section findById(Long id) {
        return sectionRepository.findById(id).get();
    }

    @Override
    public boolean createSection(Map<String, Long> sectiondata) {
        return false;
    }

    @Override
    public Section update(Section section) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        sectionRepository.deleteById(id);
    }

    @Override
    public Boolean existById(Long id) {
        return sectionRepository.existsById(id);
    }
}

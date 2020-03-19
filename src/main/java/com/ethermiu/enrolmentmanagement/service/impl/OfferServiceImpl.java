package com.ethermiu.enrolmentmanagement.service.impl;

import com.ethermiu.enrolmentmanagement.domain.Block;
import com.ethermiu.enrolmentmanagement.domain.Course;
import com.ethermiu.enrolmentmanagement.domain.Offering;
import com.ethermiu.enrolmentmanagement.domain.Section;
import com.ethermiu.enrolmentmanagement.repository.OfferRepository;
import com.ethermiu.enrolmentmanagement.service.CourseService;
import com.ethermiu.enrolmentmanagement.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class OfferServiceImpl implements OfferService {

    @Autowired
    private OfferRepository offerRepository;

    @Override
    public List<Offering> getAll() {
        return offerRepository.findAll();
    }

    @Override
    public Offering createOffer(String code, Block block, Course course) {
        Offering offering = new Offering(code,block,course);
        return  offerRepository.save(offering);
    }

    @Override
    @Transactional
    public Offering updateBlock(Long offerId, Block block) {
        Offering offering = this.offerRepository.findById(offerId).get();
        offering.setBlock(block);
        return offering;
    }

    @Override
    @Transactional
    public Offering updateCourse(Long offerId, Course course) {
        Offering offering = this.offerRepository.findById(offerId).get();
        offering.setCourse(course);
        return offering;
    }

    @Override
    public Offering deleteOfferById(Long id) {
        Offering removeOffer = offerRepository.findById(id).get();
        this.offerRepository.deleteById(id);
        return  removeOffer;
    }

    @Override
    public Offering deleteOfferByCode(String code) {
        return this.offerRepository.deleteByCode(code);
    }

    @Override
    public Offering findById(Long id) {
        return offerRepository.findById(id).get();
    }

    @Override
    public Boolean existById(Long id) {
        return offerRepository.existsById(id);
    }
}

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
    public Offering createOffer(String code, Block block, Course course, Set<Section> section) {
        Offering offering = new Offering(code,block,course,section);
        return  offerRepository.save(offering);
    }

    @Override
    public Section addSection(Long idOffer, Section section) {
        //TODO: implement me
        return null;
    }

    @Override
    public Section removeSection(Long offerId, Long sectionId) {
        //TODO: implement me
        return null;
    }

    @Override
    public Offering deleteOfferById(Long id) {
        Offering removeOffer = offerRepository.findById(id).get();
        offerRepository.deleteById(id);
        return  removeOffer;
    }

    @Override
    public Offering deleteOfferByCode(String code) {
        //TODO: we need to impelement in repository custom querry
        return null;
    }
}

package com.ethermiu.enrolmentmanagement.service;

import com.ethermiu.enrolmentmanagement.domain.Block;
import com.ethermiu.enrolmentmanagement.domain.Course;
import com.ethermiu.enrolmentmanagement.domain.Offering;
import com.ethermiu.enrolmentmanagement.domain.Section;

import java.util.List;
import java.util.Set;

//offers/1/sections


public interface OfferService {
    List<Offering> getAll();
    Offering createOffer(String code, Block block, Course course, Set<Section> section);
    Section addSection(Long idOffer,Section section);
    Section removeSection(Long offerId ,Long sectionId);
    Offering deleteOfferById(Long id);
    Offering deleteOfferByCode(String code);
}

package com.ethermiu.enrolmentmanagement.service;

import com.ethermiu.enrolmentmanagement.domain.Block;
import com.ethermiu.enrolmentmanagement.domain.Course;
import com.ethermiu.enrolmentmanagement.domain.Offering;
import com.ethermiu.enrolmentmanagement.domain.Section;

import java.util.List;

public interface OfferService {
    List<Offering> getAll();
    Offering findById(Long id);
    Boolean existById(Long id);
    Offering createOffer(String code, Block block, Course course);
    Offering updateBlock(Long offerId,Block block);
    Offering updateCourse(Long offerId,Course course);
    Offering deleteOfferById(Long id);
    Offering deleteOfferByCode(String code);
}

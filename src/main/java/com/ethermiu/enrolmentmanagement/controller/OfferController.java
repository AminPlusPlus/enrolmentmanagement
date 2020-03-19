package com.ethermiu.enrolmentmanagement.controller;

import com.ethermiu.enrolmentmanagement.domain.Block;
import com.ethermiu.enrolmentmanagement.domain.Course;
import com.ethermiu.enrolmentmanagement.domain.Offering;
import com.ethermiu.enrolmentmanagement.domain.Section;
import com.ethermiu.enrolmentmanagement.service.CourseService;
import com.ethermiu.enrolmentmanagement.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("api/v1/offers")
public class OfferController {

    @Autowired
    private OfferService offerService;
    @Autowired
    private CourseService courseService;


    @PostMapping(consumes = "application/json", produces = "application/json")
    public Offering createOffer(@RequestBody String code,
                                @RequestBody Long blockId,
                                @RequestBody Long courseId,
                                @RequestBody Long sectionId) {

        //TODO: fetchData
        //get course
        Course course = courseService.findById(courseId);

        return offerService.createOffer(code,block,course,section);
    }


}

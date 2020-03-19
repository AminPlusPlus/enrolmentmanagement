package com.ethermiu.enrolmentmanagement.controller;

import com.ethermiu.enrolmentmanagement.domain.*;
import com.ethermiu.enrolmentmanagement.service.Blockservice;
import com.ethermiu.enrolmentmanagement.service.CourseService;
import com.ethermiu.enrolmentmanagement.service.OfferService;
import com.ethermiu.enrolmentmanagement.service.SectionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/v1/offers")
public class OfferController {

    @Autowired
    private OfferService offerService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private Blockservice blockservice;


    @ApiOperation(value = "Create offer")
    @PostMapping(consumes = "application/json", produces = "application/json")
    public Offering createOffer(@RequestBody Offer offer) {
        //Fetching services
        Block block = blockservice.findById(offer.getBlockId());
        Course course = courseService.findById(offer.getCourseId());
        return offerService.createOffer(offer.getCode(),block,course);
    }


    @ApiOperation(value = "Get all offers")
    @GetMapping
    public List<Offering> getAllOffers () {
        return offerService.getAll();
    }

//    @ApiOperation(value = "Delete Offer By Id")
//    @DeleteMapping(value = "{id}")
//    public Offering deleteOffer

}

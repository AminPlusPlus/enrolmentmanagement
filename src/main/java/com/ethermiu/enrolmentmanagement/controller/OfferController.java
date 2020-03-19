package com.ethermiu.enrolmentmanagement.controller;

import com.ethermiu.enrolmentmanagement.domain.*;
import com.ethermiu.enrolmentmanagement.service.Blockservice;
import com.ethermiu.enrolmentmanagement.service.CourseService;
import com.ethermiu.enrolmentmanagement.service.OfferService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;



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

    @ApiOperation(value = "Delete Offer By Id")
    @DeleteMapping(value = "{id}")
    public void deleteOffer(@PathVariable Long id){
        this.offerService.deleteOfferById(id);
    }

    @ApiOperation(value = "Delete Offer By Code")
    @DeleteMapping
    public Offering deleteOffer(@RequestParam(value="Code") String code){
        return this.offerService.deleteOfferByCode(code);
    }


    @ApiOperation(value = "Update Block By Id")
    @PatchMapping (value = "{offerId}/{blockId}")
    public Offering updateBlock(@PathVariable Long offerId,@PathVariable Long blockId){
        Block block = blockservice.findById(blockId);
        return this.offerService.updateBlock(offerId,block);
    }

    @ApiOperation(value = "Update Course By Id")
    @PatchMapping (value = "{offerId}/{courseId}")
    public Offering updateCourse(@PathVariable Long offerId,@PathVariable Long courseId){
        Course course = courseService.findById(courseId);
        return this.offerService.updateCourse(offerId,course);
    }


}

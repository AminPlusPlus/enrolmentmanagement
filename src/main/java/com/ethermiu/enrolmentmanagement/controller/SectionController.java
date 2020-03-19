package com.ethermiu.enrolmentmanagement.controller;

import com.ethermiu.enrolmentmanagement.domain.*;
import com.ethermiu.enrolmentmanagement.service.FacultyService;
import com.ethermiu.enrolmentmanagement.service.OfferService;
import com.ethermiu.enrolmentmanagement.service.SectionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping(value = "/api/v1/sections")
public class SectionController {
    @Autowired
    private SectionService sectionService;
    @Autowired
    private FacultyService facultyService;
    //Create an Offering Service here
    @Autowired
    private OfferService offerService;

    @ApiOperation(value = "Get all Sections")
    @GetMapping
    public List<Section> getAllSection()
    {
        return sectionService.getAllSection();
    }

    @ApiOperation(value = "Get Section by id")
    @GetMapping(value = "/{id}")
    public Section findsectionbyid(@PathVariable Long id) {
        return sectionService.findById(id);
    }

    @ApiOperation(value = "Delete Section  By Id")
    @DeleteMapping(value = "{id}")
    public ResponseEntity<Map<String,String>> deleteById(@PathVariable Long id) {
        Map<String,String> message = new HashMap<>();

        if(sectionService.existById(id)) {
            sectionService.deleteById(id);
            message.put("message","Section removed " + id);
            return new ResponseEntity(message, HttpStatus.OK);
        }
        message.put("message","Section  doesn't exist");
        return new ResponseEntity(message,HttpStatus.BAD_REQUEST);
    }

    @ApiOperation(value = "Create Section")
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> AddSection(@RequestBody Sect sect) {
         //Fetching services of Faculty and Offerings
        try {
            Faculty faculty = facultyService.getFacultyById(sect.getFacultyid());
            Offering offering = offerService.findById(sect.getOfferingid());
            if (faculty != null && offering != null) {
                Section response = sectionService.createSection(faculty, offering);
                return new ResponseEntity<Section>(response, HttpStatus.OK);
            } else {
                HashMap<String, String> map = new HashMap<>();
                map.put("message", "Either Faculty code or Offering code does not exist");
                return new ResponseEntity<HashMap<String, String>>(map, HttpStatus.BAD_REQUEST);
            }
        }
        catch (Exception ex){
            System.out.println("Exception encountered in Add Section");
            HashMap<String, String> map = new HashMap<>();
            map.put("message", "Either Faculty code or Offering code does not exist");
            return new ResponseEntity<HashMap<String, String>>(map, HttpStatus.BAD_REQUEST);
        }

    }
//
//    @ApiOperation(value = "Section update")
//    @PutMapping(consumes = "application/json", produces = "application/json")
//    public Section update(@RequestBody Section section) {
//        return sectionService.update(section);
//    }
}

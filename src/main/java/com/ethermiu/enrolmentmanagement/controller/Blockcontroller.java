package com.ethermiu.enrolmentmanagement.controller;

import com.ethermiu.enrolmentmanagement.domain.Block;
import com.ethermiu.enrolmentmanagement.service.Blockservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Blockcontroller {
    @Autowired
    private Blockservice blockservice;

    @GetMapping(value = "/v1/admin/helo")
    public String Helloworld(){
        return "helloworld";
    }
    @RequestMapping(value = "/v1/admin/block",method = RequestMethod.POST,produces = "application/json",consumes = "application/json")
    public ResponseEntity<Block> insertBlock(@RequestBody Block input){
        //First check that is admin token is valid or not
        //
        Block response=blockservice.insertData(input);
        if(response==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Block>(HttpStatus.OK);
    }

}

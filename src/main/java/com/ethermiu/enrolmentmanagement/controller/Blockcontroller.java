package com.ethermiu.enrolmentmanagement.controller;

import com.ethermiu.enrolmentmanagement.domain.Block;
import com.ethermiu.enrolmentmanagement.domain.Student;
import com.ethermiu.enrolmentmanagement.service.Blockservice;
import io.swagger.annotations.ApiOperation;
import org.aspectj.bridge.IMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/admin/blocks")
public class Blockcontroller {
    @Autowired
    private Blockservice blockservice;

    @ApiOperation(value = "Add Block")
    @RequestMapping(value = "/block",method = RequestMethod.POST,produces = "application/json",consumes = "application/json")
    public ResponseEntity<Block> insertBlock(@RequestBody Block input){
        //First check that is admin token is valid or not
        //
        try {
            Block response = blockservice.insertData(input);
            if (response == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<Block>(response,HttpStatus.OK);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @ApiOperation(value = "Get All")
    @GetMapping(value = "/All")
    public List<Block> getallBlocks(){
        return  blockservice.getallBlocks();
    }

    @ApiOperation(value = "Delete Block By Id")
    @GetMapping("/{id}/delete")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id){
        try {
            if(blockservice.isexistByid(id)){
                blockservice.deleteById(id);
                return new ResponseEntity<Block>(HttpStatus.OK);
            }
            else{
                HashMap<String,String> map=new HashMap<>();
                map.put("message","id does,nt exist");
                return new ResponseEntity<HashMap<String,String>>(map,HttpStatus.BAD_REQUEST);
            }

        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return new ResponseEntity<Block>(HttpStatus.BAD_REQUEST);
        }
    }
    @ApiOperation(value = "Delete Block By Code")
    @GetMapping("/{code}/deletebycode")
    public ResponseEntity<Block> deleteByCode(@PathVariable ("code") String code){
       try {
           blockservice.deleteByCode(code);
           return new ResponseEntity<Block>(HttpStatus.OK);
       }
       catch (Exception ex) {
           return new ResponseEntity<Block>(HttpStatus.INTERNAL_SERVER_ERROR);
       }

    }
    @ApiOperation(value = "Update Block")
    @PutMapping(consumes = "application/json" ,produces = "application/json")
    public void updateBlocks(@RequestBody Block block){
        blockservice.update(block);
    }


}

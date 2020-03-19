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
@RequestMapping("api/v1/blocks")
public class BlockController {
    @Autowired
    private Blockservice blockservice;

    @ApiOperation(value = "Add Block")
    @PostMapping(produces = "application/json",consumes = "application/json")
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
    @ApiOperation(value = "Get All Blocks")
    @GetMapping
    public List<Block> getallBlocks(){
        return  blockservice.getallBlocks();
    }

    @ApiOperation(value = "Delete Block By Id")
    @DeleteMapping(value="/id/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        System.out.println("method calloing in delete");
        try {
            if(blockservice.isExistById(id)){
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
    @DeleteMapping(value = "/code/{code}")
    public ResponseEntity<?> deleteByCode(@PathVariable String code){
       try {
           blockservice.deleteByCode(code);
           return new ResponseEntity<Block>(HttpStatus.OK);
       }
       catch (Exception ex) {
           HashMap<String,String> map=new HashMap<>();
           map.put("message","code does,nt exist");
           return new ResponseEntity<HashMap<String,String>>(map,HttpStatus.BAD_REQUEST);
       }

    }
    @ApiOperation(value = "Update Block")
    @PutMapping(consumes = "application/json" ,produces = "application/json")
    public void updateBlocks(@RequestBody Block block){
        blockservice.update(block);
    }

}

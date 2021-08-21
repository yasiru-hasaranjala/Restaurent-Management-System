package com.example.itemservice.controller;

import com.example.itemservice.model.itemModel;
import com.example.itemservice.servie.itemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class itemController {

    @Autowired
    private itemService iService;

    @PostMapping("/saveitem")
    public ResponseEntity saveItem(@RequestBody itemModel item){
        iService.saveOrder(item);
        return  new ResponseEntity(item, HttpStatus.OK);
    }

    @GetMapping("/getallitem")
    public  ResponseEntity<List<itemModel>> getAllItem(){
        return new ResponseEntity<>(iService.getAllItem(), HttpStatus.OK);
    }

    @PutMapping("updateitem/{itemid}")
    public ResponseEntity updateiTem(@RequestBody itemModel item, @PathVariable String itemid){
        iService.updateItem(item, itemid);
        return new ResponseEntity(item,HttpStatus.OK);
    }

    @DeleteMapping("delete/{itemid}")
    public ResponseEntity deleteItem (@PathVariable String itemid){
        iService.deleteItem(itemid);
        return new ResponseEntity(HttpStatus.OK);
    }


}

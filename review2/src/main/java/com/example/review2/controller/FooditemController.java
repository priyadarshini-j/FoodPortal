package com.example.review2.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.review2.model.Fooditem;
import com.example.review2.service.FooditemService;


@RestController
public class FooditemController {
    @Autowired
    FooditemService evt;
    @PostMapping("/post/fooditem")
    public ResponseEntity<Fooditem>addelements(@RequestBody Fooditem n)
    {
        Fooditem evty=evt.create(n);
        return new ResponseEntity<>(evty,HttpStatus.CREATED);
    }
    @GetMapping("/get/fooditem")
    public ResponseEntity<List<Fooditem>> showinfo()
    {
        return new ResponseEntity<>(evt.getAll(),HttpStatus.OK);
    }
    @GetMapping("/get/fooditem/{fid}")
    public ResponseEntity<Fooditem> getById(@PathVariable Integer fid)
    {
        Fooditem objj=evt.getId(fid);
        return new ResponseEntity<>(objj,HttpStatus.OK);
    }
    @PutMapping("/put/fooditem/{fid}")
    public ResponseEntity<Fooditem> putMethodName(@PathVariable("fid") int fid, @RequestBody Fooditem ee) {
        if(evt.update(fid,ee) == true)
        {
            return new ResponseEntity<>(ee,HttpStatus.OK);
        }
        
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        
    }
    @DeleteMapping("/delete/fooditem/{fid}")
    public ResponseEntity<Boolean> delete(@PathVariable("fid") int fid)
    {
        if(evt.delete(fid) == true)
        {
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
   //sorting
   @GetMapping("/api/fooditem/sortBy/{field}")
   public List<Fooditem> g(@PathVariable String field)
   {
       return evt.sort(field);
   }

   //pagination
   @GetMapping("/api/fooditem/{offset}/{pagesize}")
   public List<Fooditem> get(@PathVariable int offset,@PathVariable int pagesize)
   {
       return evt.page(pagesize, offset);
   }
   
   //sorting and pagination
   @GetMapping("/api/fooditem/{offset}/{pagesize}/{field}")
   public List<Fooditem> getsorting(@PathVariable int offset,@PathVariable int pagesize,@PathVariable String field)
   {
       return evt.getsort(offset,pagesize,field);
   }
   @GetMapping("/rate")
    public List<Fooditem> getUsersWithFooditemRate() {
        return evt.getUsersWithRate();
    }
}
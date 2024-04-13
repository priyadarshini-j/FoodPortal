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

import com.example.review2.model.Orders;
import com.example.review2.service.OrderService;


@RestController
public class OrderController {
    @Autowired
    OrderService  os;
    @PostMapping("/post/order")
    public ResponseEntity<Orders>addelements(@RequestBody Orders k)
    {
        Orders ovt=os.create(k);
        return new ResponseEntity<>(ovt,HttpStatus.CREATED);
    }
    @GetMapping("/get/order")
    public ResponseEntity<List<Orders>> showinfo()
    {
        return new ResponseEntity<>(os.getAll(),HttpStatus.OK);
    }
    @GetMapping("/get/order/{orderid}")
    public ResponseEntity<Orders> getById(@PathVariable Integer orderid)
    {
        Orders objjo=os.getId(orderid);
        return new ResponseEntity<>(objjo,HttpStatus.OK);
    }
    @PutMapping("/put/order/{orderid}")
    public ResponseEntity<Orders> putMethodName(@PathVariable("orderid") int orderid, @RequestBody Orders o) {
        if(os.update(orderid,o) == true)
        {
            return new ResponseEntity<>(o,HttpStatus.OK);
        }
        
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        
    }
    @DeleteMapping("/delete/order/{orderid}")
    public ResponseEntity<Boolean> delete(@PathVariable("orderid") int orderid)
    {
        if(os.delete(orderid) == true)
        {
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
    @GetMapping("order/orderid")
    public List<Orders> getOrdersWithOrderIdd() {
        return os.getOrdersWithorderId();
    }
   
}
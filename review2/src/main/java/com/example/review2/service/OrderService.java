package com.example.review2.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.review2.model.Orders;
import com.example.review2.repository.OrderRepository;

import java.util.List;
@Service
public class OrderService {
     @Autowired
    OrderRepository or;
     public Orders create(Orders eo){
      return or.save(eo);
     }
     public List<Orders> getAll(){
      return or.findAll();
     }
     public Orders getId(int orderid){
      return or.findById(orderid).orElse(null);
     }
     public List<Orders> getOrdersWithorderId() {
        return or.findByOrderId();
    }
     public boolean update(int orderid,Orders eeo){
          if(this.getId(orderid)==null)
          {
              return false;
          }
          try{
              or.save(eeo);
          }
          catch(Exception ex)
          {
              return false;
          }
          return  true;
     }
     public boolean delete(int orderid){
          if(this.getId(orderid)==null){
             return false;
          }
          or.deleteById(orderid);
          return true;
     }
}
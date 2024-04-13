package com.example.review2.model;


import java.util.List;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {
     @Id
     private int eid;
     public int getEid() {
      return eid;
    }
    public void setEid(int eid) {
      this.eid = eid;
    }
    private String name;
    public User()
    {

    }
    
    
     public User(int eid, String name) {
      this.eid = eid;
      this.name = name;
    }
    
    public String getName() {
      return name;
    }
    public void setName(String name) {
      this.name = name;
    }
    
    // @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    // @JsonManagedReference
    // private List<Fooditem> fooditemdata=new ArrayList<>();
    // public List<Fooditem> getFooditemdata() {
    //     return fooditemdata;
    // }
    // public void setFooditemdata(List<Fooditem> fooditemdata) {
    //     this.fooditemdata = fooditemdata;
    // }

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Orders> orderdata=new ArrayList<>();
    public List<Orders> getOrderdata() {
        return orderdata;
    }
    public void setOrderdata(List<Orders> orderdata) {
        this.orderdata = orderdata;
    }
}
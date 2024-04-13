package com.example.review2.model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
//import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Fooditem {
   
    @Id
    private int fid;
    
     public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }
    private String hotel;
    private String foodtype;
    private String foodname;
    private int rate;
    private int phno;
    private String address;
    private int pincode;
   public Fooditem() {
   }
   public String getHotel() {
     return hotel;
   }
   public void setHotel(String hotel) {
     this.hotel = hotel;
   }
   public String getFoodtype() {
     return foodtype;
   }
   public void setFoodtype(String foodtype) {
     this.foodtype = foodtype;
   }
   public String getFoodname() {
     return foodname;
   }
   public void setFoodname(String foodname) {
     this.foodname = foodname;
   }
   public int getRate() {
     return rate;
   }
   public void setRate(int rate) {
     this.rate = rate;
   }
   public int getPhno() {
     return phno;
   }
   public void setPhno(int phno) {
     this.phno = phno;
   }
   public String getAddress() {
     return address;
   }
   public void setAddress(String address) {
     this.address = address;
   }
   public int getPincode() {
     return pincode;
   }
   public void setPincode(int pincode) {
     this.pincode = pincode;
   }
   public Fooditem(int fid, String hotel, String foodtype, String foodname, int rate,
       int phno, String address, int pincode) {
     this.fid = fid;
     this.hotel = hotel;
     this.foodtype = foodtype;
     this.foodname = foodname;
     this.rate = rate;
     this.phno = phno;
     this.address = address;
     this.pincode = pincode;
   }
    

  
    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name="user_eid")
    // @JsonBackReference
    // private User user;

    // public User getUser() {
    //     return user;
    // }

    // public void setUser(User user) {
    //     this.user = user;
    // }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="orders_orderid")
    @JsonBackReference
    private  Orders order;

    public Orders getOrder() {
    return order;
    }

    public void setOrder(Orders order) {
    this.order = order;
}
}
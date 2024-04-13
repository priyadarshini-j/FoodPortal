package com.example.review2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class Orders{
    @Id
    private int orderid;
    public int getOrderid() {
        return orderid;
    }
    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }
    private String timeoforder;
    public Orders()
    {
        
    }
    public Orders(int orderid, String timeoforder) {
        this.orderid = orderid;
        this.timeoforder = timeoforder;
    }
    public String getTimeoforder() {
        return timeoforder;
    }
    public void setTimeoforder(String timeoforder) {
        this.timeoforder = timeoforder;
    }
      @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_eid")
    @JsonBackReference
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Fooditem> fooddata=new ArrayList<>();
    public List<Fooditem> getFooddata() {
        return fooddata;
    }
    public void setFooddata(List<Fooditem> fooddata) {
        this.fooddata = fooddata;
    }
}
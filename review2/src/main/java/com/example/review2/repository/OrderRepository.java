package com.example.review2.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.review2.model.Orders;

public interface OrderRepository extends JpaRepository<Orders,Integer>
{
    @Query("SELECT o FROM Orders o WHERE o.orderid = 1")
    List<Orders> findByOrderId();
    
}
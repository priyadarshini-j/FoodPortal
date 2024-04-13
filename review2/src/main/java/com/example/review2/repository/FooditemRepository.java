package com.example.review2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.review2.model.Fooditem;

public interface FooditemRepository extends JpaRepository<Fooditem,Integer> {
    @Query("SELECT b FROM Fooditem b WHERE b.rate > 200")
    List<Fooditem> findByRate();

}
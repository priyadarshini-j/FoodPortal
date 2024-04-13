package com.example.review2.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.review2.model.Fooditem;
import com.example.review2.repository.FooditemRepository;

import java.util.List;
@Service
public class FooditemService {
     @Autowired
     FooditemRepository avt;
     public Fooditem create(Fooditem em){
      return avt.save(em);
     }
     public List<Fooditem> getAll(){
      return avt.findAll();
     }
     public Fooditem getId(int fid){
      return avt.findById(fid).orElse(null);
     }
     public List<Fooditem> getUsersWithRate() {
        return avt.findByRate();}
     public boolean update(int fid,Fooditem eee){
          if(this.getId(fid)==null)
          {
              return false;
          }
          try{
              avt.save(eee);
          }
          catch(Exception ex)
          {
              return false;
          }
          return  true;
     }
     public boolean delete(int fid){
          if(this.getId(fid)==null){
             return false;
          }
          avt.deleteById(fid);
          return true;
     }
     //sorting by field
    public List<Fooditem> sort(String field)
    {
        Sort sort=Sort.by(Sort.Direction.ASC,field);
        return avt.findAll(sort);
    }

    //pagination
    public List<Fooditem> page(int pageSize,int pageNumber)
    {
        Pageable page=PageRequest.of(pageNumber, pageSize);
        return avt.findAll(page).getContent();
    }

    //sorting and pagination
    public List<Fooditem> getsort(int pageNumber,int pageSize,String field)
    {          return avt.findAll(PageRequest.of(pageNumber, pageSize)
          .withSort(Sort.by(Sort.Direction.ASC,field))).getContent();
    }
}
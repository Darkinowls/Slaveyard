package com.lab7.service;

import com.lab7.model.MyTime;
import com.lab7.repository.MyTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyTimeService {

    private final MyTimeRepository myTimeRepository;

    @Autowired
    public MyTimeService(MyTimeRepository myTimeRepository) {
        this.myTimeRepository = myTimeRepository;
    }


    public MyTime findById(int id){
        return myTimeRepository.findById(id).orElse(null);
    }

    public List<MyTime> findAll(){
        return myTimeRepository.findAll();
    }

    public MyTime saveMyTime(MyTime myTime){
        return myTimeRepository.save(myTime);
    }

    public void deleteById(int id){
        myTimeRepository.deleteById(id);
    }





}

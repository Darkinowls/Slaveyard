package com.slaveyard.services;

import com.slaveyard.models.MyTime;
import com.slaveyard.repositories.MyTimeRepository;
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

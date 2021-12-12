package com.lab7.service;

import com.lab7.model.Day;
import com.lab7.repository.DayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DayService {

    private final DayRepository dayRepository;

    @Autowired
    public DayService(DayRepository dayRepository) {
        this.dayRepository = dayRepository;
    }


    public Day findById(int id){
        return dayRepository.findById(id).orElse(null);
    }

    public List<Day> findAll(){
        return dayRepository.findAll();
    }

    public Day saveDay(Day day){
        return dayRepository.save(day);
    }

    public void deleteById(int id){
        dayRepository.deleteById(id);
    }





}

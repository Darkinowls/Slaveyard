package com.lab7.service;

import com.lab7.model.Lesson;
import com.lab7.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LessonService {

    private final LessonRepository scheduleRepository;

    @Autowired
    public LessonService(LessonRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }


    public Lesson findById(int id){
        return scheduleRepository.findById(id).orElse(null);
    }

    public List<Lesson> findAll(){
        return scheduleRepository.findAll();
    }

    public Lesson saveLesson(Lesson schedule){
        return scheduleRepository.save(schedule);
    }

    public void deleteById(int id){
        scheduleRepository.deleteById(id);
    }





}

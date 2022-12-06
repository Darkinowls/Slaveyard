package com.slaveyard.services;

import com.slaveyard.models.MyClass;
import com.slaveyard.models.Lesson;
import com.slaveyard.models.MyTime;
import com.slaveyard.repositories.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class LessonService {

    private final LessonRepository lessonRepository;

    @Autowired
    public LessonService(LessonRepository scheduleRepository) {
        this.lessonRepository = scheduleRepository;
    }


    public Lesson findById(int id){
        return lessonRepository.findById(id).orElse(null);
    }

    public List<Lesson> findAll(){
        return lessonRepository.findAll();
    }

    public Lesson saveLesson(Lesson schedule){
        return lessonRepository.save(schedule);
    }

    public void deleteById(int id){
        lessonRepository.deleteById(id);
    }

    public Boolean existsByClasAndDateAndMyTime(MyClass myClass, Date date, MyTime myTime){
        return lessonRepository.existsByMyClassAndDateAndMyTime(myClass, date, myTime);
    }

    public Lesson getByClasAndDateAndMyTime(MyClass myClass, Date date, MyTime myTime){
        return lessonRepository.getByMyClassAndDateAndMyTime(myClass, date, myTime);
    }



}

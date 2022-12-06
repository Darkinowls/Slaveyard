package com.slaveyard.repositories;

import com.slaveyard.models.MyClass;
import com.slaveyard.models.Lesson;
import com.slaveyard.models.MyTime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;


public interface LessonRepository extends JpaRepository<Lesson, Integer> {

    Lesson getByMyClassAndDateAndMyTime(MyClass myClass, Date date, MyTime myTime);


    Boolean existsByMyClassAndDateAndMyTime(MyClass myClass, Date date, MyTime myTime);


}
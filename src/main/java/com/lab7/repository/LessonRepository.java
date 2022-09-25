package com.lab7.repository;

import com.lab7.model.MyClass;
import com.lab7.model.Lesson;
import com.lab7.model.MyTime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;


public interface LessonRepository extends JpaRepository<Lesson, Integer> {

    Lesson getByMyClassAndDateAndMyTime(MyClass myClass, Date date, MyTime myTime);


    Boolean existsByMyClassAndDateAndMyTime(MyClass myClass, Date date, MyTime myTime);


}
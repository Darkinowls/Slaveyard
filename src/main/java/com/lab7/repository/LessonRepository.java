package com.lab7.repository;

import com.lab7.model.Clas;
import com.lab7.model.Lesson;
import com.lab7.model.MyTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;


public interface LessonRepository extends JpaRepository<Lesson, Integer> {

    Lesson getByClasAndDateAndMyTime(Clas clas, Date date, MyTime myTime);


    Boolean existsByClasAndDateAndMyTime(Clas clas, Date date, MyTime myTime);


}
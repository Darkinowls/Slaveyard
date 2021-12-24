package com.lab7.repository;

import com.lab7.model.*;
import org.springframework.data.jpa.repository.JpaRepository;



public interface MyRecordRepository extends JpaRepository<MyRecord, Integer> {

    MyRecord getByStudentAndLesson(Student student, Lesson lesson);

    Boolean existsByStudentAndLesson(Student student, Lesson lesson);

}
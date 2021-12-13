package com.lab7.repository;

import com.lab7.model.Lesson;
import com.lab7.model.MyRecord;
import com.lab7.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;



public interface MyRecordRepository extends JpaRepository<MyRecord, Integer> {

    Boolean existsByStudentAndLesson(Student student, Lesson lesson);

}
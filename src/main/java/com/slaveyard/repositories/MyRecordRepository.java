package com.slaveyard.repositories;

import com.slaveyard.models.*;
import org.springframework.data.jpa.repository.JpaRepository;



public interface MyRecordRepository extends JpaRepository<MyRecord, Integer> {

    MyRecord getByStudentAndLesson(Student student, Lesson lesson);

    Boolean existsByStudentAndLesson(Student student, Lesson lesson);

}
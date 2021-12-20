package com.lab7.repository;

import com.lab7.model.Lesson;
import com.lab7.model.MyRecord;
import com.lab7.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    Student getByFirstNameAndSecondName(String firstName, String secondName);

    Boolean existsByFirstNameAndSecondName(String firstName, String secondName);

}


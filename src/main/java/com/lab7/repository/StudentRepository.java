package com.lab7.repository;


import com.lab7.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    Student getByFirstNameAndSecondName(String firstName, String secondName);

    Boolean existsByFirstNameAndSecondName(String firstName, String secondName);

}


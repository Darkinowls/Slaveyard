package com.slaveyard.repositories;


import com.slaveyard.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    Student getByFirstNameAndSecondName(String firstName, String secondName);

    Boolean existsByFirstNameAndSecondName(String firstName, String secondName);

}


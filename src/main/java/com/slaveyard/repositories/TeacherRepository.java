package com.slaveyard.repositories;

import com.slaveyard.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

    Boolean existsByFirstNameAndSecondName(String firstName, String secondName);

    Teacher getByFirstNameAndSecondName(String firstName, String secondName);


}

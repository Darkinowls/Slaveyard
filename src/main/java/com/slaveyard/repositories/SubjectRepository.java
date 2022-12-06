package com.slaveyard.repositories;

import com.slaveyard.models.Subject;
import com.slaveyard.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SubjectRepository extends JpaRepository<Subject, Integer> {

    Boolean existsByNameAndTeacher(String name, Teacher teacher);

}
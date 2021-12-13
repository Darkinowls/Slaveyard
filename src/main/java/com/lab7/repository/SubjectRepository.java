package com.lab7.repository;

import com.lab7.model.Subject;
import com.lab7.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SubjectRepository extends JpaRepository<Subject, Integer> {

    Boolean existsByNameAndTeacher(String name, Teacher teacher);

}